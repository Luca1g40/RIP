package KitchenSystem.MicroService.infrastructure.driver;

import KitchenSystem.MicroService.application.CommandHandler;
import KitchenSystem.MicroService.application.dto.OrderData;
import KitchenSystem.MicroService.infrastructure.driver.request.ClaimOrderRequest;
import KitchenSystem.MicroService.infrastructure.driver.request.OrderDoneRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    private final CommandHandler commandHandler;

    public KitchenController(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping("/order/{id}")
    public void claimOrder(@PathVariable Long id){
        this.commandHandler.handle(new ClaimOrderRequest(id));
    }

    @PostMapping("/order/{id}/done")
    public void orderDone(@PathVariable Long id){
        this.commandHandler.handle(new OrderDoneRequest(id));
    }

    @GetMapping("/allorders")
    public List<OrderData> allOrders(){
        return this.commandHandler.getAllDoneOrders();
    }


}
