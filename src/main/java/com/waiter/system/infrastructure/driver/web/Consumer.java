package com.waiter.system.infrastructure.driver.web;

import com.waiter.system.core.application.CommandHandler;
import com.waiter.system.core.command.OrderDone;
import com.waiter.system.infrastructure.driver.messaging.event.GenericEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {
    private final CommandHandler commandHandler;

    public Consumer(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = { "waiter-order-done-queue" })
    public void consumeTest(GenericEvent event) throws IOException {

        this.commandHandler.handle(new OrderDone(event.id, event.tableNumber, event.products));

    }


}
