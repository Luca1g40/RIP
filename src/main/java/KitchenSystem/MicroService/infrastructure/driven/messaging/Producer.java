package KitchenSystem.MicroService.infrastructure.driven.messaging;

import KitchenSystem.MicroService.domain.event.PlaceNewIngredient;
import KitchenSystem.MicroService.domain.event.PlaceNewProduct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate template;

    public Producer(RabbitTemplate template){
        this.template = template;
    }

    public void sendNewProduct(PlaceNewProduct product){
        this.template.convertAndSend("product-queue", product);
        System.out.println("product ontvangen " + product.getProductName());
    }

    public void sendNewIngredient(PlaceNewIngredient ingredient){
        this.template.convertAndSend("ingredient-queue", ingredient);
        System.out.println("ingredient ontvangen " + ingredient.getName());
    }

}
