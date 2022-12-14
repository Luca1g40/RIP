package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.port.AreaRepository;
import Happlication.microserviceOpdracht.core.application.port.OrderRepository;
import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.application.port.ReviewRepository;
import Happlication.microserviceOpdracht.core.application.port.TableRepository;
import Happlication.microserviceOpdracht.core.command.AddToShoppingCart;
import Happlication.microserviceOpdracht.core.command.PlaceNewProduct;
import Happlication.microserviceOpdracht.core.command.OrderClaimed;
import Happlication.microserviceOpdracht.core.command.OrderDone;
import Happlication.microserviceOpdracht.core.domain.Area;
import Happlication.microserviceOpdracht.core.domain.Order;
import Happlication.microserviceOpdracht.core.domain.Product;
import Happlication.microserviceOpdracht.core.domain.Table;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.GenericEvent;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import Happlication.microserviceOpdracht.core.domain.event.OrderCreatedEvent;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CommandHandler {

    private Producer producer;
    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    private final ProductRepository productRepository;
    private final AreaRepository areaRepository;
    private final ReviewRepository reviewRepository;

    public CommandHandler(Producer producer, OrderRepository orderRepository, TableRepository tableRepository, ProductRepository productRepository, AreaRepository areaRepository) {
        this.producer = producer;
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
        this.productRepository = productRepository;
        this.areaRepository = areaRepository;
        this.reviewRepository = reviewRepository;
    }

    public Order handle(OrderCreatedEvent event) {
        Table table = tableRepository.getById(event.id);
        table.placeOrder();
        Table table1 = tableRepository.save(table);
        Order order = table1.getOrders().get(table1.getOrders().size()-1);
        producer.sendOrderToKitchen(new GenericEvent(order.getOrderId(), order.getTableNumber(), order.getProducts(), "placeOrder"));
        return order;
    }

    public Order handle(OrderClaimed command){
        Order order = orderRepository.getById(command.getOrderId());
        order.setStatus(command.getStatus());
        orderRepository.save(order);
        return order;
    }

    public Order handle(OrderDone command){
        Order order = orderRepository.getById(command.getOrderId());
        order.setStatus(command.getStatus());
        orderRepository.save(order);
        return order;
    }

    public Table handle(AddToShoppingCart command){
        Table table = tableRepository.getById(command.getTableId());
        if(productRepository.existsByProductName(command.getProduct())){
            table.addToShoppingCart(command.getProduct());
        }
        tableRepository.save(table);
        return table;
    }


    public void handle(PlaceNewProduct command) {
        Product product = new Product(command.id, command.productName, command.productDetails, command.category, true, command.prijs);
        productRepository.save(product);
    }

    public Review handle(Long orderId, String foodReview, int foodScore, String foodDeliveryReview, int foodDeliveryScore){
       Order order = orderRepository.getById(orderId);
       Review review = new Review(foodReview,foodScore,foodDeliveryReview,foodDeliveryScore, order) ;
       reviewRepository.save(review);
       return review;
    }


    public List<Long> handle(int tableNumber) {
        List<Area> areas = areaRepository.findAll();
        for (Area area : areas){
            for (Table table : area.getTables()){
                if (table.getTableNumber() == tableNumber){
                    return area.getWaiterIds();
                }
            }
        }
        return null;
    }
    public void handle(PlaceNewTable command) {
        List<Order> orders = new ArrayList<>();
        Table table = new Table(command.id, command.tableNumber, orders);
        tableRepository.save(table);
    }

    public List<ProductData> getAllProducts() {
        List<ProductData> products = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if (product.isInStock()) {
                products.add(createProductData(product));
            }
            else {
                System.out.println(product.getProductName() + " is niet op voorraad!");
            }
        }
        System.out.println("Er zijn "+ products.size() + " producten in de Menukaart");
        return products;
    }

    public ProductData createProductData(Product product) {
        return new ProductData(
                product.getId(),
                product.getProductName(),
                product.getProductDetails(),
                product.getCategory(),
                product.isInStock(),
                product.getPrice()
        );
    }
}