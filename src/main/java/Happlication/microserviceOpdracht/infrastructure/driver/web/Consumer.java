package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.command.PlaceNewProduct;
import Happlication.microserviceOpdracht.core.command.OrderClaimed;
import Happlication.microserviceOpdracht.core.command.OrderDone;
import Happlication.microserviceOpdracht.core.command.PlaceNewTable;
import Happlication.microserviceOpdracht.infrastructure.driver.messaging.event.GenericEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    private final CommandHandler commandHandler;

    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = { "order-queue" })
    public void consumeTest(GenericEvent event) throws IOException {

        switch (event.eventKey) {
            case "claimOrder" -> this.commandHandler.handle(new OrderClaimed(event.id));
            case "orderDone" -> this.commandHandler.handle(new OrderDone(event.id));
        }
    }

    @RabbitListener(queues = { "product-guest-queue" })
    public void consumeProduct(PlaceNewProduct placeNewProduct){
        this.commandHandler.handle(new PlaceNewProduct(placeNewProduct.id, placeNewProduct.productName, placeNewProduct.productDetails, placeNewProduct.category, true, placeNewProduct.prijs));
    }

    @RabbitListener(queues = { "productoutofstock-guest" })
    public void productOutOfStock(String message){
        System.out.println("aangekomen");
        System.out.println(message);
    }

    @RabbitListener(queues = { "table-queue" })
    public void consumeTafel(PlaceNewTable placeNewTable){
        System.out.println(placeNewTable.tableNumber);
        this.commandHandler.handle(new PlaceNewTable(placeNewTable.id, placeNewTable.tableNumber));
        System.out.println("na de handel functie");
    }

}
