package cn.y.demo.cosumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class DirectListener {

    @RabbitListener(queues = "direct.queue1")
    public void listenDirect1Exchange(String msg){
        System.out.println("queue1 message received: " + msg);
    }

    @RabbitListener(queues = "direct.queue2")
    public void listenDirect2Exchange(String msg){
        System.out.println("queue2 message received: " + msg);
        // throw new RuntimeException("test ");
    }
}
