package KitchenSystem.MicroService.domain.event;

public class PlaceNewWaiter {
    private Long id;

    public PlaceNewWaiter(Long id) {
        this.id = id;
    }

    public PlaceNewWaiter() {
    }

    public Long getId() {
        return id;
    }
}
