package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
public class SendObjectTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() {
        String queueName = "object.queue1";
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "zs");
        data.put("age", 18);
        rabbitTemplate.convertAndSend(queueName, data);
    }
}
