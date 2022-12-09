package Happlication.microserviceOpdracht.infrastructure.driven.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{

    private RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendOrderToKitchen(GenericEvent m){
        this.template.convertAndSend("order-queue", m);
    }


}