package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.port.OrderRepository;
import KitchenSystem.MicroService.application.port.ProductRepository;
import KitchenSystem.MicroService.command.CreateTable;
import KitchenSystem.MicroService.command.PlaceOrder;
import KitchenSystem.MicroService.command.TableRepository;
import KitchenSystem.MicroService.domain.Order;
import KitchenSystem.MicroService.domain.Product;
import KitchenSystem.MicroService.domain.Table;
import KitchenSystem.MicroService.domain.event.ClaimOrderEvent;
import KitchenSystem.MicroService.domain.event.OrderDoneEvent;
import KitchenSystem.MicroService.infrastructure.driven.messaging.GenericEvent;
import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;
import KitchenSystem.MicroService.infrastructure.driver.request.ClaimOrderRequest;
import KitchenSystem.MicroService.infrastructure.driver.request.OrderDoneRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandHandler {

    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final Producer producer;

    public CommandHandler(TableRepository tableRepository, OrderRepository orderRepository, ProductRepository productRepository, Producer producer) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.producer = producer;
    }

    public void handle(PlaceOrder command){
        List<Product> products = new ArrayList<>();

        for (String product : command.getProducts()){
            products.add(productRepository.findByProductName(product));
        }

        Order order = new Order(command.getOrderId(), command.getTableNumber(), products);

        this.orderRepository.save(order);

    }

    public void handle(ClaimOrderRequest command){
        Order order = orderRepository.getById(command.orderId);

        order.setStatus(command.status);

        this.orderRepository.save(order);

        producer.sendOrderStatus(new GenericEvent(order.getOrderId(), "claimOrder"));

    }

    public void handle(OrderDoneRequest command){
        Order order = orderRepository.getById(command.orderId);

        order.setStatus(command.status);

        this.orderRepository.save(order);

        producer.sendOrderDoneStatus(new GenericEvent(order.getOrderId(), "orderDone"));

    }


}
