package KitchenSystem.MicroService.infrastructure.driven.messaging;

import KitchenSystem.MicroService.domain.event.PlaceNewIngredient;
import KitchenSystem.MicroService.domain.event.PlaceNewProduct;
import KitchenSystem.MicroService.domain.event.PlaceNewTable;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendNewProduct(PlaceNewProduct product){
        Object returnMessage = this.template.convertSendAndReceive("product-exchange", "", product);
        System.out.println("Bericht: " + returnMessage.toString());
    }

    public void sendNewIngredient(PlaceNewIngredient ingredient){
        this.template.convertAndSend("ingredient-queue", ingredient);
        System.out.println("ingredient ontvangen " + ingredient.getName());
    }

    public void sendNewTable(PlaceNewTable table){
        this.template.convertAndSend("table-queue", table);
        System.out.println("table ontvangen " + table.getTableNumber());
    }


}
