package KitchenSystem.MicroService.infrastructure.driver.messaging.event;

import java.util.List;

public class GenericEvent {

    public Long id;
    public String eventKey;
    public List<String> products;
    public int tableNumber;

}
