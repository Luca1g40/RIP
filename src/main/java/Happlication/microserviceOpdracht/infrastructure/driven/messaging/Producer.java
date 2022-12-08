package Happlication.microserviceOpdracht.infrastructure.driven.messaging;

import Happlication.microserviceOpdracht.core.domain.event.PlaceOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{

    private RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendOrderToKitchen(PlaceOrder m){
        this.template.convertAndSend("place-order-queue", m);
    }


}