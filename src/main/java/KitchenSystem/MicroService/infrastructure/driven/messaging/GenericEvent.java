package KitchenSystem.MicroService.infrastructure.driven.messaging;

public class GenericEvent {

    public Long id;
    public String eventKey;

    public GenericEvent(Long id, String eventKey) {
        this.id = id;
        this.eventKey = eventKey;
    }
}
