package cn.y.demo.cosumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ObjectDirectListener {

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String, Object> msg){
        System.out.println("queue2 message received: " + msg);
    }
}
