package KitchenSystem.MicroService.domain.event;

import KitchenSystem.MicroService.domain.Status;

import static KitchenSystem.MicroService.domain.Status.DONE;

public class OrderDoneEvent {

    private Long orderId;
    private Status status;

    public OrderDoneEvent(Long orderId) {
        this.orderId = orderId;
        this.status = DONE;
    }

    public OrderDoneEvent() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }

}
