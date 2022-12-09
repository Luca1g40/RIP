package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;
import java.util.List;
import static Happlication.microserviceOpdracht.core.domain.Status.*;


@Entity(name = "bestelling")
public class Order {


    @GeneratedValue
    @Id
    private Long orderId;
    private int tableNumber;
    @ElementCollection
    private List<String> products;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(int tableNumber, List<String> products) {
        this.tableNumber = tableNumber;
        this.products = products;
        this.status = UNCLAIMED;
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

    public void addProducts(String product){
        products.add(product);
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
