package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DelayTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendDelayMessage() {
        rabbitTemplate.convertAndSend("delay.direct", "delay", "test delay", message -> {
            message.getMessageProperties().setDelayLong(10000L);
            return message;
        });
    }
}
