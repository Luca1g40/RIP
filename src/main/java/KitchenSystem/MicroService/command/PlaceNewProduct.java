package KitchenSystem.MicroService.command;

import KitchenSystem.MicroService.domain.Destination;
import KitchenSystem.MicroService.domain.Ingredient;

import java.util.List;

public class PlaceNewProduct {
    public Long id;
    public List<Ingredient> ingredients;
    public String productName;
    public Destination destination;


    public PlaceNewProduct() {
    }

    public PlaceNewProduct(Long id, List<Ingredient> ingredients, String productName, Destination destination) {
        this.id = id;
        this.ingredients = ingredients;
        this.productName = productName;
        this.destination = destination;
    }
}
