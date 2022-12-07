package Happlication.microserviceOpdracht.core.application.port;

import Happlication.microserviceOpdracht.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
