package KitchenSystem.MicroService.infrastructure.driver.web.request;

import KitchenSystem.MicroService.domain.Table;
import KitchenSystem.MicroService.domain.Waiter;

import java.util.List;

public class AreaRequest {
    public Long id;
    public List<Table> tables;
    public List<Waiter> waiters;

    public AreaRequest(Long id, List<Table> tables, List<Waiter> waiters) {
        this.id = id;
        this.tables = tables;
        this.waiters = waiters;
    }
}
