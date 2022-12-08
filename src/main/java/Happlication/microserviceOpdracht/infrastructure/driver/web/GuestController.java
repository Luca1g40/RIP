package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.domain.Order;
import Happlication.microserviceOpdracht.core.domain.Product;
import Happlication.microserviceOpdracht.infrastructure.driver.web.request.OrderCreated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @PostMapping("/order")
    public Order placeOrder(){
        List<String> productNames = new ArrayList<>();
        for (Product product: productRepository.findAll()){
            productNames.add(product.getProductName());
        }
        return this.commandHandler.handle(new OrderCreated(1, productNames));
    }
}
