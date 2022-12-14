package KitchenSystem.MicroService.command;

import KitchenSystem.MicroService.domain.ProductDestination;

import java.util.List;

public class PlaceNewProduct {
    public Long id;
    public String productName;
    public List<String> ingredientNames;
    public ProductDestination destination;


    public PlaceNewProduct() {
    }

    public PlaceNewProduct(Long id, List<String> ingredientNames, String productName, ProductDestination destination) {
        this.id = id;
        this.ingredientNames = ingredientNames;
        this.productName = productName;
        this.destination = destination;
    }
}
