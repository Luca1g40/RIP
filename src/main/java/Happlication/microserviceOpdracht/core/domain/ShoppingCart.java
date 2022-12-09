package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection
    private List<String> products;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, List<String> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public List<String> getProducts() {
        return products;
    }

    public void addProductToShoppingCart(String product){
        this.products.add(product);
    }

    public void clearShoppingCart(){
        products.clear();
    }
}
