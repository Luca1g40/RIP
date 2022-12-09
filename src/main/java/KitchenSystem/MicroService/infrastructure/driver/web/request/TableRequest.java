package KitchenSystem.MicroService.infrastructure.driver.web.request;

public class TableRequest {
    public Long id;
    public int tableNumber;

    public TableRequest(Long id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }
}
