package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
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

}
