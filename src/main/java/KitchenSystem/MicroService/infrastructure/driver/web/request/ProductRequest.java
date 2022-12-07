package KitchenSystem.MicroService.infrastructure.driver.web.request;

import KitchenSystem.MicroService.domain.Ingredient;
import KitchenSystem.MicroService.domain.ProductDestination;
import KitchenSystem.MicroService.domain.ProductType;
import java.util.List;

public class ProductRequest {
    public String imagePath;
    public String productName;
    public String productDetails;
    public String category;
    public boolean inStock;
    public List<Ingredient> ingredients;
    public ProductDestination destination;
    public double prijs;
    public ProductType productType;

    public ProductRequest(String imagePath, String productName, String productDetails, String category, boolean inStock, List<Ingredient> ingredients, ProductDestination destination, double prijs, ProductType productType) {
        this.imagePath = imagePath;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.ingredients = ingredients;
        this.destination = destination;
        this.prijs = prijs;
        this.productType = productType;
    }
}
