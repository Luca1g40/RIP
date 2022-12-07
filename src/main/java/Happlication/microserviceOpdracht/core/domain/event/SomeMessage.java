package Happlication.microserviceOpdracht.core.domain.event;

import java.util.UUID;

public class SomeMessage {
    private Long id;
    private String naam;

    protected SomeMessage(){}

    public SomeMessage(String message){
        this.id = 3L;
        this.naam = message;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
