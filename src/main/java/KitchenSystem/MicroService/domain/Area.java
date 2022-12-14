package KitchenSystem.MicroService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Table> tables;

    @OneToMany
    private List<Waiter> waiters;

    public Area( List<Table> tables, List<Waiter> waiters) {
        this.tables = tables;
        this.waiters = waiters;
    }

    public Area() {
    }

    public void addWaiter(Waiter waiter) {
        this.waiters.add(waiter);
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public Long getId() {
        return id;
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Waiter> getWaiters() {
        return waiters;
    }
}
