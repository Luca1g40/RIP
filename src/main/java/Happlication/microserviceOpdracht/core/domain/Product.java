package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Product {
    @Id
    private Long id;
    @OneToMany
    private List<Ingredient> ingredients;
    private String productName;


    public Product() {
    }

    public Product(Long id, List<Ingredient> ingredients, String productName) {
        this.id = id;
        this.ingredients = ingredients;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getProductName() {
        return productName;
    }
}
