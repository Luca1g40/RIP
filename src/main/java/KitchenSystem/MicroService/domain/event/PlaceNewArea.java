package KitchenSystem.MicroService.domain.event;

import KitchenSystem.MicroService.domain.Table;
import KitchenSystem.MicroService.domain.Waiter;

import java.util.List;

public class PlaceNewArea {
    private Long id;
    private List<Table> tables;
    private List<Waiter> waiters;

    public PlaceNewArea(Long id, List<Table> tables, List<Waiter> waiters) {
        this.id = id;
        this.tables = tables;
        this.waiters = waiters;
    }

    public PlaceNewArea() {
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
