package com.waiter.system.core.command;

import java.util.List;

public class OrderDone {

    private Long orderId;
    private int tableNumber;
    private List<String> products;

    public OrderDone(Long orderId, int tableNumber, List<String> products) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.products = products;
    }

    public OrderDone() {
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
}
