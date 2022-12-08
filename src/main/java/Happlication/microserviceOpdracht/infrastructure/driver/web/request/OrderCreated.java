package Happlication.microserviceOpdracht.infrastructure.driver.web.request;

import java.util.List;

public class OrderCreated {

    public int tableNumber;
    public List<String> products;

    public OrderCreated(int tableNumber, List<String> products) {
        this.tableNumber = tableNumber;
        this.products = products;
    }
}
