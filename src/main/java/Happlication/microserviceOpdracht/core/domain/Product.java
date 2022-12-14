package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String productDetails;
    private String category;
    private boolean inStock;
    private double price;

    public Product() {
    }

    public Product(Long id, String productName, String productDetails, String category, boolean inStock, double price) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Long getId() {
        return id;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public String getCategory() {
        return category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public double getPrice() {
        return price;
    }

}
