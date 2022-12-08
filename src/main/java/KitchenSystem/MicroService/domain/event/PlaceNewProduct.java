package KitchenSystem.MicroService.domain.event;


import KitchenSystem.MicroService.domain.Ingredient;
import KitchenSystem.MicroService.domain.ProductDestination;
import KitchenSystem.MicroService.domain.ProductType;

import java.util.List;

public class PlaceNewProduct {
    private Long id;
    private String productName;
    private String productDetails;
    private String category;
    private boolean inStock;
    private List<Ingredient> ingredients;
    private ProductDestination destination;
    private double prijs;
    private ProductType productType;

    public PlaceNewProduct() {}

    public PlaceNewProduct(Long id, String productName, String productDetails, String category, boolean inStock, List<Ingredient> ingredients, ProductDestination destination, double prijs, ProductType productType) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.ingredients = ingredients;
        this.destination = destination;
        this.prijs = prijs;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public String getCategory() {
        return category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public ProductDestination getDestination() {
        return destination;
    }

    public double getPrijs() {
        return prijs;
    }

    public ProductType getProductType() {
        return productType;
    }
}


