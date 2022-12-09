package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    private Long id;
    private String name;
    private int amount;

    public Ingredient(Long id, String name, int amount) {
        this.id = id;
        this.name = name;
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
}
