package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.port.IngredientRepository;
import Happlication.microserviceOpdracht.core.application.port.ProductRepository;
import Happlication.microserviceOpdracht.core.command.PlaceNewIngredient;
import Happlication.microserviceOpdracht.core.command.PlaceNewProduct;
import Happlication.microserviceOpdracht.core.domain.Ingredient;
import Happlication.microserviceOpdracht.core.domain.Product;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class CommandHandler {

    private Producer producer;
    private final ProductRepository productRepository;

    private final IngredientRepository ingredientRepository;

    public CommandHandler(Producer producer,  ProductRepository productRepository, IngredientRepository ingredientRepository) {
        this.producer = producer;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void handle(PlaceNewProduct command) {
        Product product = new Product(command.id, command.ingredients, command.productName);
        productRepository.save(product);
    }

    public void handle(PlaceNewIngredient command) {
        Ingredient ingredient = new Ingredient(command.id, command.name, command.amount);
        ingredientRepository.save(ingredient);
    }
}