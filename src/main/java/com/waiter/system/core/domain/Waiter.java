package com.waiter.system.core.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Waiter {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    public Waiter(Long id, List<Order> orders) {
        this.id = id;
        this.orders = orders;
    }

    public Waiter() {
    }

    public Long getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addToOrders(Order order){
        orders.add(order);
    }

}
