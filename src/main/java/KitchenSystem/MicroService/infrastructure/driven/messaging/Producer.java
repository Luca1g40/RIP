package KitchenSystem.MicroService.infrastructure.driven.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Producer{

    private final RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }


    public void sendOrderStatus(GenericEvent event){
        this.template.convertAndSend("order-exchange", "", event);
    }

    public void sendOrderDoneStatus(GenericEvent event){
        this.template.convertAndSend("order-exchange", "", event);
    }

    public void sendOrderedIngredients(List<String> ingredients){
        this.template.convertAndSend("ordered-ingredients", ingredients);
    }

    public void sendProductOutOfStock(String message){
        this.template.convertAndSend("productoutofstock-guest", message);
    }


}