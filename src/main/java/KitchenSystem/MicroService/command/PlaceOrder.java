package KitchenSystem.MicroService.command;

public class PlaceOrder {

    private Long id;
    private String content;

    public PlaceOrder(Long id, String content) {
        this.id = id;
        this.content = content;

    }

    public PlaceOrder() {
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }
}
