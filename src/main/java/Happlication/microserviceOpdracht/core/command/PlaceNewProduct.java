package Happlication.microserviceOpdracht.core.command;

import Happlication.microserviceOpdracht.core.domain.Ingredient;

import java.util.List;

public class PlaceNewProduct {
    public Long id;
    public List<Ingredient> ingredients;
    public String productName;


    public PlaceNewProduct() {
    }

    public PlaceNewProduct(Long id, List<Ingredient> ingredients, String productName) {
        this.id = id;
        this.ingredients = ingredients;
        this.productName = productName;
    }
}
