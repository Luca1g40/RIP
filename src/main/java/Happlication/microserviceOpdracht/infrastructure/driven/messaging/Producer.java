package Happlication.microserviceOpdracht.infrastructure.driven.messaging;

import Happlication.microserviceOpdracht.core.domain.Ingredient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer{

    private final RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendUpdatedIngredientAmount(Ingredient ingredient){
        this.template.convertAndSend("ingredient-amount-changed", ingredient);
    }
}