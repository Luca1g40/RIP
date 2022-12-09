package Happlication.microserviceOpdracht.core.application.port;

import Happlication.microserviceOpdracht.core.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
