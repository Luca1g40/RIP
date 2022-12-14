package Happlication.microserviceOpdracht.core.application.dto;

public class ProductData {
    public final Long id;
    public final String productName;
    public final String productDetails;
    public final String category;
    public final boolean inStock;
    public final double price;

    public ProductData(Long id, String productName, String productDetails, String category, boolean inStock, double price) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.price = price;
    }
}
