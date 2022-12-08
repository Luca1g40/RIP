package KitchenSystem.MicroService.infrastructure.driven.messaging;

import KitchenSystem.MicroService.domain.event.ClaimOrderEvent;
import KitchenSystem.MicroService.domain.event.OrderDoneEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{

    private RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendOrderStatus(GenericEvent event){
        this.template.convertAndSend("order-status-queue", event);
    }

    public void sendOrderDoneStatus(GenericEvent event){
        this.template.convertAndSend("order-status-queue", event);
    }


}