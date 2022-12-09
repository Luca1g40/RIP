package Happlication.microserviceOpdracht.core.command;

public class ProductCreated {
    public Long id;
    public String productName;
    public String productDetails;
    public String category;
    public boolean inStock;
    public double prijs;

    public ProductCreated(Long id, String productName, String productDetails, String category, boolean inStock, double prijs) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.prijs = prijs;
    }

}
