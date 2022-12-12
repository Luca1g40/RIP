package Happlication.microserviceOpdracht.core.command;


import Happlication.microserviceOpdracht.core.domain.Amount;

public class PlaceNewIngredient {
    public Long id;
    public String name;
    public int amount;

    public Amount amountEnum;

    public PlaceNewIngredient() {
    }

    public PlaceNewIngredient(Long id, String name, int amount, Amount amountEnum) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.amountEnum = amountEnum;
    }
}
