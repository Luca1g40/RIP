package KitchenSystem.MicroService.domain.event;

import KitchenSystem.MicroService.domain.Status;
import static KitchenSystem.MicroService.domain.Status.*;

public class ClaimOrderEvent {

    private Long orderId;
    private Status status;

    public ClaimOrderEvent(Long orderId) {
        this.orderId = orderId;
        this.status = CLAIMED;
    }

    public ClaimOrderEvent() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }
}
