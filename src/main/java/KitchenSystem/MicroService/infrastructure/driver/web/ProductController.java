package KitchenSystem.MicroService.infrastructure.driver.web;

import KitchenSystem.MicroService.application.CommandHandler;
import KitchenSystem.MicroService.application.dto.IngredientData;
import KitchenSystem.MicroService.application.dto.ProductData;
import KitchenSystem.MicroService.application.dto.TableData;
import KitchenSystem.MicroService.infrastructure.driver.web.request.IngredientRequest;
import KitchenSystem.MicroService.infrastructure.driver.web.request.ProductRequest;
import KitchenSystem.MicroService.infrastructure.driver.web.request.TableRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/administration")
public class ProductController {
    private final CommandHandler commandHandler;

    public ProductController(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping("/product")
    private ProductData createNewProduct(@RequestBody ProductRequest productRequest) {
        try {
            return this.commandHandler.handle(productRequest);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ingredient")
    private IngredientData createNewIngredient(@RequestBody IngredientRequest ingredientRequest) {
        try {
            return this.commandHandler.handle(ingredientRequest);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/table")
    private TableData createNewTable(@RequestBody TableRequest tableRequest) {
        try {
            return this.commandHandler.handle(tableRequest);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
