package KitchenSystem.MicroService.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private Amount amount;

    public Ingredient(Long id, String name, Amount amount) {
        this.id = id;
        this.name = name;
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

    public Amount getAmount() {
        return amount;
    }
}
