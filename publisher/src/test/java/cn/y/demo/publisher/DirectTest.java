package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DirectTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() {
        String exchangeName = "test.direct";
        String message = "direct";
        rabbitTemplate.convertAndSend(exchangeName, "yellow", message);
    }
}
