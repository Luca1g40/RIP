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
    private Destination destination;

    public Product(Long id, String productName, List<Ingredient> ingredients, Destination destination) {
        this.id = id;
        this.productName = productName;
        this.ingredients = ingredients;
        this.destination = destination;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Destination getDestination() {
        return destination;
    }

    public Long getId() {
        return id;
    }
}
