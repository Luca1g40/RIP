package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.dto.ProductData;
import Happlication.microserviceOpdracht.core.application.port.OrderRepository;
import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.application.port.TableRepository;
import Happlication.microserviceOpdracht.core.command.*;
import Happlication.microserviceOpdracht.core.domain.Order;
import Happlication.microserviceOpdracht.core.domain.Product;
import Happlication.microserviceOpdracht.core.domain.ShoppingCart;
import Happlication.microserviceOpdracht.core.domain.Table;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.GenericEvent;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import Happlication.microserviceOpdracht.core.domain.event.OrderCreatedEvent;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CommandHandler {

    private Producer producer;
    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    private final ProductRepository productRepository;

    public CommandHandler(Producer producer, OrderRepository orderRepository, TableRepository tableRepository, ProductRepository productRepository) {
        this.producer = producer;
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
        this.productRepository = productRepository;
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
        table.addToShoppingCart(command.getProduct());
        tableRepository.save(table);
        return table;
    }


    public void handle(PlaceNewProduct command) {
        Product product = new Product(command.id, command.productName, command.productDetails, command.category, true, command.prijs);
        productRepository.save(product);
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