package Happlication.microserviceOpdracht.core.command;

import Happlication.microserviceOpdracht.core.domain.Status;

import static Happlication.microserviceOpdracht.core.domain.Status.DONE;

public class OrderDone {

    private Long orderId;
    private Status status;

    public OrderDone(Long orderId) {
        this.orderId = orderId;
        this.status = DONE;
    }

    public OrderDone() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }

}
