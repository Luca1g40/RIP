package KitchenSystem.MicroService.application.dto;

import KitchenSystem.MicroService.domain.Table;
import KitchenSystem.MicroService.domain.Waiter;

import java.util.List;

public class AreaData {
    public Long id;
    public List<Table> tables;
    public List<Waiter> waiters;

    public AreaData(Long id, List<Table> tables, List<Waiter> waiters) {
        this.id = id;
        this.tables = tables;
        this.waiters = waiters;
    }
}
