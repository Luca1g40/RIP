package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.port.IngredientRepository;
import Happlication.microserviceOpdracht.core.domain.Ingredient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class InventoryController {

    private final IngredientRepository ingredientRepository;

    public InventoryController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/{id}")
    public int ingredientAmount(@PathVariable Long id){
        Ingredient ingredient = this.ingredientRepository.getById(id);
        return ingredient.getAmount();
    }
}
