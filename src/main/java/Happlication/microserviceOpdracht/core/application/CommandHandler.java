package Happlication.microserviceOpdracht.core.application;

import Happlication.microserviceOpdracht.core.application.port.IngredientRepository;
import Happlication.microserviceOpdracht.core.command.PlaceNewIngredient;
import Happlication.microserviceOpdracht.core.domain.Amount;
import Happlication.microserviceOpdracht.core.domain.Ingredient;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CommandHandler {

    private final Producer producer;
    private final IngredientRepository ingredientRepository;

    public CommandHandler(Producer producer, IngredientRepository ingredientRepository) {
        this.producer = producer;
        this.ingredientRepository = ingredientRepository;
    }

    public void handle(PlaceNewIngredient command) {
        Amount enumAmount = Amount.LOTS;
        if(command.amount <= 10){
            enumAmount = Amount.FEW;
        }

        Ingredient ingredient = new Ingredient(command.id, command.name, enumAmount,command.amount);
        ingredientRepository.save(ingredient);
    }

    public void handle(List<String> OrderedIngredients) {
        for(String name : OrderedIngredients){
            Ingredient ingredient = ingredientRepository.findByName(name);
            ingredient.removeOne();
            if(ingredient.getAmount() <= 10){
                ingredient.setEnumAmount(Amount.FEW);
                producer.sendUpdatedIngredientAmount(ingredient);
            }
            ingredientRepository.save(ingredient);
        }
    }
}