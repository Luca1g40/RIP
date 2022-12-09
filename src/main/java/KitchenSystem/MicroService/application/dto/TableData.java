package KitchenSystem.MicroService.application.dto;

public class TableData {
    public Long id;
    public int tableNumber;

    public TableData(Long id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }
}