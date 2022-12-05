package KitchenSystem.MicroService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Table {
    @Id
    @GeneratedValue
    private Long id;

    public Table(Long id) {
        this.id = id;
    }

    public Table() {
    }

    public Long getId() {
        return id;
    }
}
