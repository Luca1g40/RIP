package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.dto.*;
import KitchenSystem.MicroService.application.port.*;
import KitchenSystem.MicroService.domain.*;
import KitchenSystem.MicroService.domain.event.*;
import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;
import KitchenSystem.MicroService.infrastructure.driver.web.request.*;
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
    private final AreaRepository areaRepository;
    private final WaiterRepository waiterRepository;

    public CommandHandler(Producer producer, ProductRepository productRepository, IngredientRepository ingredientRepository, TableRepository tableRepository, AreaRepository areaRepository, WaiterRepository waiterRepository) {
        this.producer = producer;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.tableRepository = tableRepository;
        this.areaRepository = areaRepository;
        this.waiterRepository = waiterRepository;

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

    public AreaData handle(AreaRequest command) {
        Area area = new Area(command.tables, command.waiters);
        areaRepository.save(area);

        producer.sendNewArea(new PlaceNewArea(
                area.getId(),
                area.getTables(),
                area.getWaiters()
        ));
        return createAreaData(area);
    }

    public WaiterData handle() {
        Waiter waiter = new Waiter();
        waiterRepository.save(waiter);

        producer.sendNewWaiter(new PlaceNewWaiter(
                waiter.getId()
        ));
        return createWaiterData(waiter);
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

    public AreaData createAreaData(Area area) {
        return new AreaData(
                area.getId(),
                area.getTables(),
                area.getWaiters()
        );
    }
    public WaiterData createWaiterData(Waiter waiter) {
        return new WaiterData(
                waiter.getId()
        );
    }
}
