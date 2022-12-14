package Happlication.microserviceOpdracht.core.application.port;

import Happlication.microserviceOpdracht.core.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {

}
