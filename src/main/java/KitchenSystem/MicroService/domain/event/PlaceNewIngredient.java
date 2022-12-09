package KitchenSystem.MicroService.domain.event;

public class PlaceNewIngredient {
    private Long id;
    private String name;
    private int amount;

    public PlaceNewIngredient() {
    }

    public PlaceNewIngredient(Long id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
