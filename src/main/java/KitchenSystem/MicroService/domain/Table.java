package KitchenSystem.MicroService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tafel")
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private int tableNumber;

    public Table() {
    }

    public Table(int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }

    public Long getId() {
        return id;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
