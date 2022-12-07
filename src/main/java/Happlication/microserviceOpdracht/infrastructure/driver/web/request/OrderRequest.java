package Happlication.microserviceOpdracht.infrastructure.driver.web.request;

import Happlication.microserviceOpdracht.core.domain.Product;

import java.util.List;

public class OrderRequest {

    public int tableNumber;
    public List<String> products;

    public OrderRequest(int tableNumber, List<String> products) {
        this.tableNumber = tableNumber;
        this.products = products;
    }
}
