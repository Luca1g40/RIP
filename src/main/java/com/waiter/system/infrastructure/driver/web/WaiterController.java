package com.waiter.system.infrastructure.driver.web;

import com.waiter.system.core.application.CommandHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/waiter")
public class WaiterController {

    private final CommandHandler commandHandler;

    public WaiterController(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping("/{orderid}")
    public void orderIsDelivered(@PathVariable Long orderid){
        this.commandHandler.handle(orderid);
    }


}
