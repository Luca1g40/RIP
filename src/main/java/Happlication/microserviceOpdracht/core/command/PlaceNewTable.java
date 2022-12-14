package Happlication.microserviceOpdracht.core.command;

public class PlaceNewTable {
    public Long id;
    public int tableNumber;

    public PlaceNewTable() {
    }

    public PlaceNewTable(Long id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }


}
