package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.port.IngredientRepository;
import KitchenSystem.MicroService.application.port.OrderRepository;
import KitchenSystem.MicroService.application.port.ProductRepository;
import KitchenSystem.MicroService.command.PlaceNewIngredient;
import KitchenSystem.MicroService.command.PlaceNewProduct;
import KitchenSystem.MicroService.command.PlaceOrder;
import KitchenSystem.MicroService.domain.Amount;
import KitchenSystem.MicroService.domain.Ingredient;
import KitchenSystem.MicroService.domain.Order;
import KitchenSystem.MicroService.domain.Product;
import KitchenSystem.MicroService.application.port.TableRepository;
import KitchenSystem.MicroService.command.*;
import KitchenSystem.MicroService.domain.*;
import KitchenSystem.MicroService.infrastructure.driven.messaging.GenericEvent;
import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;
import KitchenSystem.MicroService.infrastructure.driver.messaging.event.WaiterEvent;
import KitchenSystem.MicroService.infrastructure.driver.request.ClaimOrderRequest;
import KitchenSystem.MicroService.infrastructure.driver.request.OrderDoneRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommandHandler {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final Producer producer;
    private final WebClient webClient = WebClient.create();


    public CommandHandler(OrderRepository orderRepository, ProductRepository productRepository, IngredientRepository ingredientRepository, Producer producer) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.producer = producer;
    }

    public void handle(PlaceOrder command){
        List<Product> products = new ArrayList<>();

        for (String product : command.getProducts()){
            products.add(productRepository.findByProductName(product));
        }

        Order order = new Order(command.getOrderId(), command.getTableNumber(), products);
        for (Product product : products){
            for(Ingredient ingredient : product.getIngredients()){
                if(ingredient.getEnumAmount() == Amount.FEW){
                    WebClient.ResponseSpec responseSpec = webClient.get()
                            .uri("http://localhost:8090/stock/" + ingredient.getId())
                            .retrieve();
                    String responseBody = responseSpec.bodyToMono(String.class).block();
                    System.out.println("response: " + responseBody);
                    if(Integer.parseInt(responseBody) <= 0){
                        producer.sendProductOutOfStock("Helaas is het gerecht " + product.getProductName() + " niet beschikbaar");
                        return;
                    }
                }
            }
        }
        this.orderRepository.save(order);

    }

    public void handle(ClaimOrderRequest command){
        List<String> ingredients = new ArrayList<>();
        Order order = orderRepository.getById(command.orderId);

        order.setStatus(command.status);

        this.orderRepository.save(order);

        for (Product product : order.getProducts()){
            for(Ingredient ingredient : product.getIngredients()){
                ingredients.add(ingredient.getName());
                ingredient.removeOne();
            }
        }
        producer.sendOrderedIngredients(ingredients);
        producer.sendOrderStatus(new GenericEvent(order.getOrderId(), "claimOrder"));

    }

    public void handle(OrderDoneRequest command){
        Order order = orderRepository.getById(command.orderId);

        order.setStatus(command.status);

        this.orderRepository.save(order);

        producer.sendOrderDoneStatus(new GenericEvent(order.getOrderId(), "orderDone"));
        producer.sendOrderDoneToWaiter(new WaiterEvent(order.getOrderId(), order.getTableNumber(), order.getProductNames()));

    }

    public void handle(PlaceNewIngredient command) {
        Amount enumAmount = Amount.LOTS;
        if(command.amount <= 10){
            enumAmount = Amount.FEW;
        }
        Ingredient ingredient = new Ingredient(command.id, command.name, enumAmount,command.amount);
        ingredientRepository.save(ingredient);
    }

    public void handle(PlaceNewProduct command) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(String ingredientName : command.ingredientNames){
            Ingredient ingredient = ingredientRepository.findByName(ingredientName);
            ingredients.add(ingredient);
        }

        Product product = new Product(command.id, command.productName, ingredients, command.destination);
        productRepository.save(product);
    }

    public void handle(Ingredient updatedIngredient) {
        Ingredient ingredient = ingredientRepository.getById(updatedIngredient.getId());
        ingredient.setEnumAmount(updatedIngredient.getEnumAmount());
        System.out.println("Ingredient: " + ingredient.getName());
        System.out.println("Amount: " + ingredient.getEnumAmount());
        ingredientRepository.save(ingredient);
    }

    public List<OrderData> getAllDoneOrders() {
        List<OrderData> doneOrders = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            if (order.getStatus() == Status.DONE){
                doneOrders.add(createOrderData(order));
            }
        }
        System.out.println("Er zijn " + doneOrders.size() + " aantal orders die done zijn");
        return doneOrders;
    }

    public OrderData createOrderData(Order order) {
        return new OrderData(
                order.getOrderId(),
                order.getTableNumber(),
                order.getStatus()
        );
    }

}
