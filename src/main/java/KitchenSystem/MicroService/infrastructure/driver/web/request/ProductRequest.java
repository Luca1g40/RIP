package KitchenSystem.MicroService.infrastructure.driver.web.request;

import KitchenSystem.MicroService.domain.ProductDestination;
import KitchenSystem.MicroService.domain.ProductType;
import java.util.List;

public class ProductRequest {
    public Long id;
    public String productName;
    public String productDetails;
    public String category;
    public boolean inStock;
    public List<String> ingredientNames;
    public ProductDestination destination;
    public double prijs;
    public ProductType productType;


    public ProductRequest(Long id, String productName, String productDetails, String category, boolean inStock, List<String> ingredientNames, ProductDestination destination, double prijs, ProductType productType) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.ingredientNames = ingredientNames;
        this.destination = destination;
        this.prijs = prijs;
        this.productType = productType;
    }
}
