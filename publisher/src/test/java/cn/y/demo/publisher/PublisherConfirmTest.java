package cn.y.demo.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublisherConfirmTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testPublisherConfirm() {
        CorrelationData cd = new CorrelationData();
        cd.getFuture().exceptionally(throwable -> {
                    System.out.println("消息回调失败");
                    return null;
                })
                .thenAccept(confirm -> {
                    if (confirm == null) return;
                    if (confirm.isAck()) {
                        System.out.println("消息发送成功，收到ack");
                    } else {
                        System.out.println("消息发送失败，收到nack，原因：" + confirm.getReason());
                    }
                });
        // rabbitTemplate.convertAndSend("test.direct", "red", "test msg", cd); // 收到ack
        // rabbitTemplate.convertAndSend("test.direct", "red1", "test msg", cd); // 触发publisher-returns机制，收到ack
        rabbitTemplate.convertAndSend("test.direct2", "red", "test msg", cd); // 收到nack
    }
}
