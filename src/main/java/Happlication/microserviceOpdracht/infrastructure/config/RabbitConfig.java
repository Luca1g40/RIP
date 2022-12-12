package Happlication.microserviceOpdracht.infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public Queue orderStatusQueue(){
        return QueueBuilder.durable("order-status-queue").build();
    }

    @Bean
    public Queue ingredientCreatedQueue(){
        return QueueBuilder.durable("ingredient-queue").build();
    }

    @Bean
    public Queue OrderedIngredientQueue(){
        return QueueBuilder.durable("ordered-ingredients").build();
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

}