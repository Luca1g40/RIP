package Happlication.microserviceOpdracht.core.command;

public class ProductInStock {

    private final Long productId;
    private final boolean inStock;

    public ProductInStock(Long productId, boolean inStock) {
        this.productId = productId;
        this.inStock = true;
    }
}
