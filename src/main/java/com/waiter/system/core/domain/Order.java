package com.waiter.system.core.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "bestelling")
public class Order {

    @Id
    private Long id;
    @ElementCollection
    private List<String> products;
    private int tableNumber;
    private boolean delivered;

    public Order(Long id, List<String> products, int tableNumber) {
        this.id = id;
        this.products = products;
        this.tableNumber = tableNumber;
        this.delivered = false;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public List<String> getProducts() {
        return products;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
