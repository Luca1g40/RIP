package Happlication.microserviceOpdracht.core.command;

public class ProductOutOfStock {

    private final Long productId;
    private final boolean inStock;

    public ProductOutOfStock(Long productId) {
        this.productId = productId;
        this.inStock = false;
    }

}
