package KitchenSystem.MicroService.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    private Long id;
    private String productName;
    @ManyToMany
    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private ProductDestination productDestination;

    public Product(Long id, String productName, List<Ingredient> ingredients, ProductDestination productDestination) {
        this.id = id;
        this.productName = productName;
        this.ingredients = ingredients;
        this.productDestination = productDestination;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public ProductDestination getDestination() {
        return productDestination;
    }

    public Long getId() {
        return id;
    }
}
