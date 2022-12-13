package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.dto.IngredientData;
import KitchenSystem.MicroService.application.dto.ProductData;
import KitchenSystem.MicroService.application.dto.TableData;
import KitchenSystem.MicroService.application.port.IngredientRepository;
import KitchenSystem.MicroService.application.port.ProductRepository;
import KitchenSystem.MicroService.application.port.TableRepository;
import KitchenSystem.MicroService.domain.Ingredient;
import KitchenSystem.MicroService.domain.Product;
import KitchenSystem.MicroService.domain.Table;
import KitchenSystem.MicroService.domain.event.PlaceNewIngredient;
import KitchenSystem.MicroService.domain.event.PlaceNewProduct;
import KitchenSystem.MicroService.domain.event.PlaceNewTable;
import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;
import KitchenSystem.MicroService.infrastructure.driver.web.request.IngredientRequest;
import KitchenSystem.MicroService.infrastructure.driver.web.request.ProductRequest;
import KitchenSystem.MicroService.infrastructure.driver.web.request.TableRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CommandHandler {
    private final Producer producer;
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final TableRepository tableRepository;

    public CommandHandler(Producer producer, ProductRepository productRepository, IngredientRepository ingredientRepository, TableRepository tableRepository) {
        this.producer = producer;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.tableRepository = tableRepository;
    }

    public ProductData handle(ProductRequest command) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(String ingredientName : command.ingredientNames){
            Ingredient ingredient = ingredientRepository.findByName(ingredientName);
            ingredients.add(ingredient);
        }
        Product product = new Product(command.productName, command.productDetails, command.category, command.inStock, ingredients, command.destination, command.prijs, command.productType);
        productRepository.save(product);

            producer.sendNewProduct(new PlaceNewProduct(
                    product.getId(),
                    product.getProductName(),
                    product.getProductDetails(),
                    product.getCategory(),
                    product.isInStock(),
                    command.ingredientNames,
                    product.getDestination(),
                    product.getPrijs(),
                    product.getProductType()
            ));
        return createProductData(product);
    }

    public IngredientData handle(IngredientRequest command) {
        Ingredient ingredient = new Ingredient(command.name, command.amount);
        ingredientRepository.save(ingredient);

        producer.sendNewIngredient(new PlaceNewIngredient(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getAmount()
        ));
        return createIngredientData(ingredient);
    }

    public TableData handle(TableRequest command) {
        Table table = new Table(command.tableNumber);
        tableRepository.save(table);

        producer.sendNewTable(new PlaceNewTable(
                table.getId(),
                table.getTableNumber()
        ));
        return createTableData(table);
    }

    public TableData createTableData(Table table) {
        return new TableData(
                table.getId(),
                table.getTableNumber()
        );
    }

    public IngredientData createIngredientData(Ingredient ingredient) {
        return new IngredientData(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getAmount()
        );
    }

    public ProductData createProductData(Product product) {
        return new ProductData(
                product.getId(),
                product.getProductName(),
                product.getProductDetails(),
                product.getCategory(),
                product.isInStock(),
                product.getIngredients(),
                product.getDestination(),
                product.getPrijs(),
                product.getProductType()
        );
    }
}
