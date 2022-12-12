package KitchenSystem.MicroService.infrastructure.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue orderQueue(){
        return QueueBuilder.durable("order-queue").build();
    }
    @Bean
    public Queue ingredientCreatedQueue(){
        return QueueBuilder.durable("ingredient-queue").build();
    }

    @Bean
    public Queue ingredientUpdatedQueue(){
        return QueueBuilder.durable("ingredient-amount-changed").build();
    }
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


}