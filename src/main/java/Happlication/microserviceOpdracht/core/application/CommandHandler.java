package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.command.PlaceNewProduct;
import Happlication.microserviceOpdracht.core.domain.Product;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class CommandHandler {

    private Producer producer;
    private final ProductRepository productRepository;

    public CommandHandler(Producer producer,  ProductRepository productRepository) {
        this.producer = producer;
        this.productRepository =productRepository;
    }

    public void handle(PlaceNewProduct command) {
        Product product = new Product(command.id, command.ingredients, command.productName);
        productRepository.save(product);
    }
}