package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.dto.ProductData;
import KitchenSystem.MicroService.application.port.ProductRepository;
import KitchenSystem.MicroService.domain.Product;
import KitchenSystem.MicroService.domain.event.PlaceNewProduct;
import KitchenSystem.MicroService.infrastructure.driven.messaging.Producer;
import KitchenSystem.MicroService.infrastructure.driver.web.request.ProductRequest;
import org.springframework.stereotype.Service;


@Service
public class CommandHandler {
    private final Producer producer;
    private final ProductRepository productRepository;

    public CommandHandler(Producer producer, ProductRepository productRepository) {
        this.producer = producer;
        this.productRepository = productRepository;
    }

    public ProductData handle(ProductRequest command) {
        Product product = new Product(command.productName, command.productDetails, command.category, command.inStock, command.ingredients, command.destination, command.prijs, command.productType);
        productRepository.save(product);

        producer.sendNewProduct(new PlaceNewProduct(
                product.getId(),
                product.getProductName(),
                product.getProductDetails(),
                product.getCategory(),
                product.isInStock(),
                product.getIngredients(),
                product.getDestination(),
                product.getPrijs(),
                product.getProductType()
        ));
        return createProductData(product);
    }


    public ProductData createProductData(Product product) {
        return new ProductData(
                product.getId(),
                product.getProductName(),
                product.getProductDetails(),
                product.getCategory(),
                product.isInStock(),
                product.getIngredients(),
                product.getDestination(),
                product.getPrijs(),
                product.getProductType()
        );
    }
}
