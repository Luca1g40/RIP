package com.waiter.system.core.application;

import com.waiter.system.core.application.port.OrderRepository;
import com.waiter.system.core.application.port.WaiterRepository;
import com.waiter.system.core.command.OrderDone;
import com.waiter.system.core.domain.Order;
import com.waiter.system.core.domain.Waiter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommandHandler {

    private final WaiterRepository waiterRepository;
    private final OrderRepository orderRepository;
    private final WebClient webClient = WebClient.create();


    public CommandHandler(WaiterRepository waiterRepository, OrderRepository orderRepository) {
        this.waiterRepository = waiterRepository;
        this.orderRepository = orderRepository;
    }

    public void handle(OrderDone command){
        Order order = new Order(command.getOrderId(), command.getProducts(), command.getTableNumber());

        WebClient.ResponseSpec responseSpec = webClient.get()
                .uri("http://localhost:8090/area/" + command.getTableNumber())
                .retrieve();
        List responseBody = responseSpec.bodyToMono(List.class).block();
        Long l = Long.valueOf(String.valueOf(responseBody.get(0)));

        Waiter waiter = waiterRepository.getById(l);
        waiter.addToOrders(order);
        waiterRepository.save(waiter);
    }

    public void handle(Long orderId){
        Order order = orderRepository.getById(orderId);
        order.setDelivered(true);
        orderRepository.save(order);
    }
}
