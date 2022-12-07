package Happlication.microserviceOpdracht.core.application.port;

import Happlication.microserviceOpdracht.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
