package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FanoutTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage(){
        String exchangeName = "yf.fanout";
        String message = "fanout message";
        rabbitTemplate.convertAndSend(exchangeName, null, message);
    }
}
