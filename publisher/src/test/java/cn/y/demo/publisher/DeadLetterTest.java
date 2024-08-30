package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeadLetterTest {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() {
        rabbitTemplate.convertAndSend("simple.direct2", "dlx", "test dlx", message -> {
            message.getMessageProperties().setExpiration("10000");
            return message;
        });
    }
}
