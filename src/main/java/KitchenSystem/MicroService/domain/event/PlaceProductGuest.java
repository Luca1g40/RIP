package KitchenSystem.MicroService.domain.event;


public class PlaceProductGuest {
    public Long id;
    public String imagePath;
    public String productDetails;
    public String productCategory; //todo --> moet dit een klasse zijn?
    public String naam;
    public double prijs;

    public PlaceProductGuest() {}

    public PlaceProductGuest(Long id, String imagePath, String productDetails, String productCategory, String naam, double prijs) {
        this.id = id;
        this.imagePath = imagePath;
        this.productDetails = productDetails;
        this.productCategory = productCategory;
        this.naam = naam;
        this.prijs = prijs;
    }


    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrijs() {
        return prijs;
    }
}


