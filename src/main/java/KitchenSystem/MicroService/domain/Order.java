package KitchenSystem.MicroService.domain;

import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate dateOfOrder;

    public Order(Long orderId, int tableNumber, List<Product> products) {
        this.tableNumber = tableNumber;
        this.products = products;
        this.orderId = orderId;
        this.status = UNCLAIMED;
        this.dateOfOrder = LocalDate.now();
    }

    public Order() {
    }


    public int getTableNumber() {
        return tableNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<String> getProductNames(){
        List<String> productNames = new ArrayList<>();
        for (Product product : products){
            productNames.add(product.getProductName());
        }
        return productNames;
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

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }
}
