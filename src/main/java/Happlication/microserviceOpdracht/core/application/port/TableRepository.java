package Happlication.microserviceOpdracht.core.application.port;

import Happlication.microserviceOpdracht.core.domain.Table;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepository extends JpaRepository<Table, Long> {
}
