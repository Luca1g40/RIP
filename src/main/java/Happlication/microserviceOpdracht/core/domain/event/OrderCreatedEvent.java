package Happlication.microserviceOpdracht.core.domain.event;


public class OrderCreatedEvent {

    public Long id;

    public OrderCreatedEvent(Long id) {
        this.id = id;

    }
}
