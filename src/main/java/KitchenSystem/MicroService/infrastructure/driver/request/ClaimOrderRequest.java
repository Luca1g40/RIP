package KitchenSystem.MicroService.infrastructure.driver.request;

import KitchenSystem.MicroService.domain.Status;

import static KitchenSystem.MicroService.domain.Status.CLAIMED;

public class ClaimOrderRequest {

    public Long orderId;
    public Status status;

    public ClaimOrderRequest(Long orderId) {
        this.orderId = orderId;
        this.status = CLAIMED;
    }
}
