package KitchenSystem.MicroService.application.port;

import KitchenSystem.MicroService.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
