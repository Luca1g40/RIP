package KitchenSystem.MicroService.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private Amount enumAmount;
    private int amount;

    public Ingredient(Long id, String name, Amount enumAmount, int amount) {
        this.id = id;
        this.name = name;
        this.enumAmount = enumAmount;
        this.amount = amount;
    }

    public Ingredient() {
    }


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Amount getEnumAmount() {
        return enumAmount;
    }

    public int getAmount() {return amount;}
}
