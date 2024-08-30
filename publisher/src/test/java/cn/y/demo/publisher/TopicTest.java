package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() {
        String exchangeName = "test.topic";
        String message = "topic message";
        // rabbitTemplate.convertAndSend(exchangeName, "china.weather", message);
        // rabbitTemplate.convertAndSend(exchangeName, "japan.news", message);
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
    }
}
