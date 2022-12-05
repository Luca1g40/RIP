package Happlication.microserviceOpdracht.rip;

import Happlication.microserviceOpdracht.core.domain.event.PlaceOrder;
import Happlication.microserviceOpdracht.core.domain.event.SomeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = { "demo-queue" })
    public void consume(SomeMessage s){
        System.out.println(s.getContent());
    }

}
