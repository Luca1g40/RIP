package Happlication.microserviceOpdracht.rip;

import Happlication.microserviceOpdracht.core.domain.event.PlaceOrder;
import Happlication.microserviceOpdracht.core.domain.event.SomeMessage;
import Happlication.microserviceOpdracht.infrastructure.driven.messaging.Producer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private Producer producer;

    public Runner(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            this.producer.sendMessageToDemo(new SomeMessage("dfgd"));
            Thread.sleep(2000);
        }
    }
}