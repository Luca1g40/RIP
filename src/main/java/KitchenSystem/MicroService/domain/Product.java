package KitchenSystem.MicroService.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String imagePath;
    private String productName;
    private String productDetails;
    private String category;
    private boolean inStock;

    @OneToMany
    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private ProductDestination destination;
    private double prijs;
    @Enumerated(EnumType.STRING)
    private ProductType productType;


    public Product() {}


    public Product(String imagePath, String productName, String productDetails, String category, boolean inStock, List<Ingredient> ingredients, ProductDestination destination, double prijs, ProductType productType) {
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

    public Long getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
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
