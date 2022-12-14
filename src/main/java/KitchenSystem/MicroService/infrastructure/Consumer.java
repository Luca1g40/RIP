package KitchenSystem.MicroService.infrastructure;

import KitchenSystem.MicroService.application.CommandHandler;
import KitchenSystem.MicroService.command.PlaceNewIngredient;
import KitchenSystem.MicroService.command.PlaceNewProduct;
import KitchenSystem.MicroService.command.PlaceOrder;
import KitchenSystem.MicroService.domain.Ingredient;
import KitchenSystem.MicroService.infrastructure.driver.messaging.event.GenericEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Consumer {

    private final CommandHandler commandHandler;


    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;

    }

    @RabbitListener(queues = { "order-placed-queue" })
    public void consume(GenericEvent event){
        switch (event.eventKey) {
            case "placeOrder" -> {
                this.commandHandler.handle(new PlaceOrder(event.id, event.tableNumber, event.products));
                break;
            }
        }
    }

    @RabbitListener(queues = { "ingredient-queue" })
    public void consumeIngredient(PlaceNewIngredient placeNewIngredient){
        System.out.println("Naam binnengekomen ingredient " + placeNewIngredient.name);
        this.commandHandler.handle(new PlaceNewIngredient(placeNewIngredient.id, placeNewIngredient.name, placeNewIngredient.amount));
    }

    @RabbitListener(queues = { "product-kitchen-queue" })
    public String consumeProduct(PlaceNewProduct placeNewProduct){
        this.commandHandler.handle(new PlaceNewProduct(placeNewProduct.id, placeNewProduct.ingredientNames, placeNewProduct.productName, placeNewProduct.destination));
        return "Product " + placeNewProduct.productName + " is aangekomen bij de keukenmodule";
    }

    @RabbitListener(queues = { "ingredient-amount-changed" })
    public void ingredientAmountChanged(Ingredient ingredient){
        this.commandHandler.handle(ingredient);
    }
}
