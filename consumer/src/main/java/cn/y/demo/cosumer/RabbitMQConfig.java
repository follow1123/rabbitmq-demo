package cn.y.demo.cosumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // @Bean
    // public FanoutExchange fanoutExchange(){
    //     return new FanoutExchange("test.fanout");
    // }
    //
    // @Bean
    // public Queue queue(){
    //     return new Queue("simple.queue1");
    // }
    //
    // @Bean
    // public Binding binding(FanoutExchange exchange, Queue queue){
    //     return BindingBuilder.bind(queue).to(exchange);
    // }

    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}
