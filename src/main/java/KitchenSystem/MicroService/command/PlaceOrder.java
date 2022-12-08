package KitchenSystem.MicroService.command;

import java.util.List;

public class PlaceOrder {
    private long orderId;
    private int tableNumber;
    private List<String> products;

    public PlaceOrder(Long orderId, int tableNumber, List<String> products) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.products = products;
    }

    public PlaceOrder() {
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<String> getProducts() {
        return products;
    }

    public long getOrderId() {
        return orderId;
    }
}
