package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
public class PersistentTest {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMultiSimpleMessage() {
        String queueName = "simple.queue";
        Message message = MessageBuilder.withBody("hello".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT).build();
        for (int i = 1; i <= 10000000; i++) {
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
}
