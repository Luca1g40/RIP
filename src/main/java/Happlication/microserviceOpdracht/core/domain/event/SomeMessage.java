package Happlication.microserviceOpdracht.core.domain.event;

import java.util.UUID;

public class SomeMessage {
    private Long id;
    private String content;

    protected SomeMessage(){}

    public SomeMessage(String message){
        this.id = 2L;
        this.content = message;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
