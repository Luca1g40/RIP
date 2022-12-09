package Happlication.microserviceOpdracht.infrastructure.config;

;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public Queue orderStatusQueue(){
        return QueueBuilder.durable("order-queue").build();
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("order-exchange");
    }

    @Bean
    Binding deliveryBinding(Queue orderQue, FanoutExchange exchange) {
        return BindingBuilder.bind(orderQue).to(exchange);
    }








}