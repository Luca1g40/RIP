package KitchenSystem.MicroService.application.dto;

public class IngredientData {
    public Long id;
    public String name;
    public int amount;

    public IngredientData(Long id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
