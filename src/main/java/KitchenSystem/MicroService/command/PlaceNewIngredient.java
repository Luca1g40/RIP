package KitchenSystem.MicroService.command;


public class PlaceNewIngredient {
    public Long id;
    public String name;
    public int amount;

    public PlaceNewIngredient() {
    }

    public PlaceNewIngredient(Long id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
