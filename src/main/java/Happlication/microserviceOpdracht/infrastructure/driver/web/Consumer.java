package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.command.PlaceNewIngredient;
import Happlication.microserviceOpdracht.core.command.PlaceNewProduct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final CommandHandler commandHandler;

    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = { "product-queue" })
    public void consumeProduct(PlaceNewProduct placeNewProduct){
        System.out.println(placeNewProduct.productName);
        this.commandHandler.handle(new PlaceNewProduct(placeNewProduct.id, placeNewProduct.ingredients, placeNewProduct.productName));
    }

    @RabbitListener(queues = { "ingredient-queue" })
    public void consumeIngredient(PlaceNewIngredient placeNewIngredient){
        System.out.println(placeNewIngredient.name);
        this.commandHandler.handle(new PlaceNewIngredient(placeNewIngredient.id, placeNewIngredient.name, placeNewIngredient.amount));
    }

}
