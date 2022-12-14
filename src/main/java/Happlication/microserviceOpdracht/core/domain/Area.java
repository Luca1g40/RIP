package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Area {

    @Id
    private Long id;
    @OneToMany
    private List<Table> tables;
    @ElementCollection
    private List<Long> waiterIds;

    public Area(Long id, List<Long> waiterIds) {
        this.id = id;
        this.tables = new ArrayList<>();
        this.waiterIds = waiterIds;
    }

    public Area() {
    }

    public void addTablesToArea(Table table){
        tables.add(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Long> getWaiterIds() {
        return waiterIds;
    }
}
