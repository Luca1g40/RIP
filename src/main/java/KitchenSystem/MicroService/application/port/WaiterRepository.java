package KitchenSystem.MicroService.application.port;

import KitchenSystem.MicroService.domain.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Long> {
}
