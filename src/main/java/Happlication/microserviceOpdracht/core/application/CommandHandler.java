package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.port.OrderRepository;
import Happlication.microserviceOpdracht.core.command.OrderClaimed;
import Happlication.microserviceOpdracht.core.command.OrderDone;
import Happlication.microserviceOpdracht.core.domain.Order;
import Happlication.microserviceOpdracht.core.domain.event.PlaceOrder;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import Happlication.microserviceOpdracht.infrastructure.driver.web.request.OrderCreated;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class CommandHandler {

    private Producer producer;
    private final OrderRepository orderRepository;

    public CommandHandler(Producer producer, OrderRepository orderRepository) {
        this.producer = producer;
        this.orderRepository = orderRepository;
    }

    public Order handle(OrderCreated command) {
        Order order = new Order(command.tableNumber, command.products);
        this.orderRepository.save(order);
        producer.sendOrderToKitchen(new PlaceOrder(order.getOrderId(), order.getTableNumber(), order.getProducts()));
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




}