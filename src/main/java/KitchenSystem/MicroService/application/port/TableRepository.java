package KitchenSystem.MicroService.application.port;

import KitchenSystem.MicroService.domain.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
