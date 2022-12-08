package KitchenSystem.MicroService.command;

public class CreateTable {

    private final Long id;
    private final String naam;

    public CreateTable(Long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
