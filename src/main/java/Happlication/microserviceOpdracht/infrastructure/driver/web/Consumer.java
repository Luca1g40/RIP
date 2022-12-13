package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.command.PlaceNewIngredient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {

    private final CommandHandler commandHandler;

    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = { "ingredient-queue" })
    public void consumeIngredient(PlaceNewIngredient placeNewIngredient){
        System.out.println(placeNewIngredient.name);
        this.commandHandler.handle(new PlaceNewIngredient(placeNewIngredient.id, placeNewIngredient.name, placeNewIngredient.amount));
    }

    @RabbitListener(queues = { "ordered-ingredients" })
    public void orderedIngredients(List<String> orderedIngredients){
        System.out.println(orderedIngredients);
        this.commandHandler.handle(orderedIngredients);
    }

}
