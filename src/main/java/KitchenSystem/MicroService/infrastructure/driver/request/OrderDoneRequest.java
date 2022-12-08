package KitchenSystem.MicroService.infrastructure.driver.request;

import KitchenSystem.MicroService.domain.Status;

import static KitchenSystem.MicroService.domain.Status.DONE;

public class OrderDoneRequest {


    public Long orderId;
    public Status status;

    public OrderDoneRequest(Long orderId) {
        this.orderId = orderId;
        this.status = DONE;
    }

}
