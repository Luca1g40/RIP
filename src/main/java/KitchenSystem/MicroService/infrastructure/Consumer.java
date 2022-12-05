package KitchenSystem.MicroService.infrastructure;

import KitchenSystem.MicroService.command.PlaceOrder;
import KitchenSystem.MicroService.command.TableRepository;
import KitchenSystem.MicroService.domain.Table;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    TableRepository tableRepository;

    public Consumer(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Consumer() {
    }

    @RabbitListener(queues = { "demo-queue" })
    public void consume(PlaceOrder s){
        System.out.printf("Message %s %s%n", s.getId(),s.getContent());
        Table table = new Table(s.getId());

    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


}
