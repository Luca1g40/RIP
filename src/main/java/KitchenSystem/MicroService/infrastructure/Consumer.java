package KitchenSystem.MicroService.infrastructure;

import KitchenSystem.MicroService.application.CommandHandler;
import KitchenSystem.MicroService.command.PlaceOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final CommandHandler commandHandler;

    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;

    }

    @RabbitListener(queues = { "place-order-queue" })
    public void consume(PlaceOrder s){
        this.commandHandler.handle(new PlaceOrder(s.getOrderId(),s.getTableNumber(), s.getProducts())
        );
    }


}
