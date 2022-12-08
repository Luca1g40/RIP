package Happlication.microserviceOpdracht.core.command;

import Happlication.microserviceOpdracht.core.domain.Status;
import static Happlication.microserviceOpdracht.core.domain.Status.CLAIMED;

public class OrderClaimed {

    private Long orderId;
    private Status status;

    public OrderClaimed(Long orderId) {
        this.orderId = orderId;
        this.status = CLAIMED;
    }

    public OrderClaimed() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }
}
