package KitchenSystem.MicroService.domain.event;

public class PlaceNewTable {
    private Long id;
    private int tableNumber;

    public PlaceNewTable() {
    }

    public PlaceNewTable(Long id, int tableNumber) {
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
