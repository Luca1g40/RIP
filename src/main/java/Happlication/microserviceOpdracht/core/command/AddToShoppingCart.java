package Happlication.microserviceOpdracht.core.command;

import java.util.List;

public class AddToShoppingCart {

    private Long tableId;
    private String product;

    public AddToShoppingCart(Long tableId, String product) {
        this.tableId = tableId;
        this.product = product;
    }

    public AddToShoppingCart() {
    }

    public Long getTableId() {
        return tableId;
    }

    public String getProduct() {
        return product;
    }
}
