package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue
    private Long tableId;
    private int tableNumber;

    public Table() {
    }

    public Table(Long tableId, int tableNumber) {
        this.tableId = tableId;
        this.tableNumber = tableNumber;
    }
}
