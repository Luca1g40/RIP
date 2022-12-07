package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "bestelling")
public class Order {

    @GeneratedValue
    @Id
    private Long orderId;
    private int tableNumber;
    @ElementCollection
    private List<String> products;

    public Order(int tableNumber, List<String> products) {
        this.tableNumber = tableNumber;
        this.products = products;
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<String> getProducts() {
        return products;
    }

    public void addProducts(Product product){
        products.add(product.getProductName());
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
