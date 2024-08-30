package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage(){
        String queueName = "simple.queue";
        String message = "Hello rabbitmq!";
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testSendMultiSimpleMessage(){
        String queueName = "work.queue";

        for (int i = 1; i <= 50; i++) {
            String message = "message-" + i;
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
}
