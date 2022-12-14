package KitchenSystem.MicroService.infrastructure.driver.messaging.event;

import java.util.List;

public class WaiterEvent {
    public Long id;
    public int tableNumber;
    public List<String> products;

    public WaiterEvent(Long id, int tableNumber, List<String> products) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.products = products;
    }
}
