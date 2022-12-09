package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String imagePath;
    private String productName;
    private String productDetails;
    private String category;
    private boolean inStock;

    public Product() {
    }

    public Product(Long id, String imagePath, String productName, String productDetails, String category, boolean inStock) {
        this.id = id;
        this.imagePath = imagePath;
        this.productName = productName;
        this.productDetails = productDetails;
        this.category = category;
        this.inStock = inStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", category='" + category + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
