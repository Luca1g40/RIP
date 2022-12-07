package Happlication.microserviceOpdracht.core.domain.event;

import java.util.List;

public class PlaceOrder {

    private Long orderId;
    private int tableNumber;
    private List<String> products;

    public PlaceOrder() {
    }

    public PlaceOrder(Long orderId, int tableNumber, List<String> products) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.products = products;
    }


    public int getTableNumber() {
        return tableNumber;
    }

    public List<String> getProducts() {
        return products;
    }

    public Long getOrderId() {
        return orderId;
    }
}
