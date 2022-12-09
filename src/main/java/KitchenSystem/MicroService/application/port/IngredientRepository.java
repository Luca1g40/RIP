package KitchenSystem.MicroService.application.port;

import KitchenSystem.MicroService.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
