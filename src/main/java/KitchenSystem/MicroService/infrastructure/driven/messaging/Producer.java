package KitchenSystem.MicroService.infrastructure.driven.messaging;

import KitchenSystem.MicroService.domain.event.PlaceProductGuest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendMessageToGuest(PlaceProductGuest product){
        this.template.convertAndSend("administration-guest-queue", product);
        System.out.println("product ontvangen " + product.naam);

    }
//
//    public void sendOrderToKitchen(PlaceOrder m){
//        this.template.convertAndSend("demo-queue", m);
//    }
}
