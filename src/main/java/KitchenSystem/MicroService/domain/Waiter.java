package KitchenSystem.MicroService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Waiter {
    @Id
    @GeneratedValue
    private Long id;

    public Waiter() {
    }

    public Long getId() {
        return id;
    }
}
