package KitchenSystem.MicroService.domain;

import javax.persistence.*;
import java.util.List;
import static KitchenSystem.MicroService.domain.Status.*;

@Entity(name = "bestelling")
public class Order {

    @Id
    private Long orderId;
    private int tableNumber;
    @ManyToMany
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(Long orderId, int tableNumber, List<Product> products) {
        this.tableNumber = tableNumber;
        this.products = products;
        this.orderId = orderId;
        this.status = UNCLAIMED;
    }

    public Order() {
    }


    public int getTableNumber() {
        return tableNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Status getStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
