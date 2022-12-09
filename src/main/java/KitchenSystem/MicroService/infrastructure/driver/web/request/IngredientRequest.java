package KitchenSystem.MicroService.infrastructure.driver.web.request;

public class IngredientRequest {

    public Long id;
    public String name;
    public int amount;

    public IngredientRequest(Long id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
