package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.application.dto.ProductData;
import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.command.AddToShoppingCart;
import Happlication.microserviceOpdracht.core.domain.Order;
import Happlication.microserviceOpdracht.core.domain.event.OrderCreatedEvent;
import Happlication.microserviceOpdracht.infrastructure.driver.web.request.ProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/guest")
public class GuestController {

    private final CommandHandler commandHandler;
    private final ProductRepository productRepository;

    public GuestController(CommandHandler commandHandler, ProductRepository productRepository) {
        this.commandHandler = commandHandler;
        this.productRepository = productRepository;
    }

    @PostMapping("/order/{id}")
    public Order placeOrder(@PathVariable Long id){
        return this.commandHandler.handle(new OrderCreatedEvent(id));
    }

    @PostMapping("/addproduct/{id}")
    public void addShoppingCart(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        this.commandHandler.handle(new AddToShoppingCart(id, productRequest.name));
    }

    @GetMapping("/menu")
    public List<ProductData> getAllProducts() {
        return this.commandHandler.getAllProducts();
    }

}
