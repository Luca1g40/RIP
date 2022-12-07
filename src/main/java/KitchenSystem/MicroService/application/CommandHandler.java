package KitchenSystem.MicroService.application;

import KitchenSystem.MicroService.application.dto.ProductData;
import KitchenSystem.MicroService.application.port.ProductRepository;
import KitchenSystem.MicroService.domain.Product;
import KitchenSystem.MicroService.domain.event.PlaceProductGuest;
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
        Product product = new Product(command.imagePath, command.productName, command.productDetails, command.category, command.inStock, command.ingredients, command.destination, command.prijs, command.productType);
        productRepository.save(product);

        producer.sendMessageToGuest(new PlaceProductGuest(
                product.getId(),
                product.getImagePath(),
                product.getProductDetails(),
                product.getCategory(),
                product.getProductName(),
                product.getPrijs()
        ));
        return createProductData(product);
    }


    public ProductData createProductData(Product product) {
        return new ProductData(
                product.getId(),
                product.getImagePath(),
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
