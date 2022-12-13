package KitchenSystem.MicroService.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue demoQueue(){
        return QueueBuilder.durable("administration-guest-queue").build();
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("product-exchange");
    }


    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Binding deliveryBinding(Queue orderQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(orderQueue).to(exchange);
    }

}
