package Happlication.microserviceOpdracht.infrastructure.driven.messaging;

import java.util.List;

public class GenericEvent {

    public Long id;
    public int tableNumber;
    public List<String> products;
    public String eventKey;

    public GenericEvent() {
    }

    public GenericEvent(Long id, int tableNumber, List<String> products, String eventKey) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.products = products;
        this.eventKey = eventKey;
    }
}
