package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Amount getEnumAmount() {
        return enumAmount;
    }

    public void removeOne(){
        this.amount-= 1;
    }

    public void setEnumAmount(Amount amount){
        enumAmount = amount;
    }
}
