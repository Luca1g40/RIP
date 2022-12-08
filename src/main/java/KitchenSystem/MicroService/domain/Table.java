package KitchenSystem.MicroService.domain;

import javax.persistence.*;

@Entity(name = "tafel")
public class Table {
    @Id
    private Long id;
    private String naam;

    public Table(Long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Table() {
    }

    public String getNaam() {
        return naam;
    }

    public Long getId() {
        return id;
    }
}
