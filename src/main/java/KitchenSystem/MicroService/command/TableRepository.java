package KitchenSystem.MicroService.command;
import KitchenSystem.MicroService.domain.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("domain")
public interface TableRepository extends JpaRepository<Table, Long> {
}
