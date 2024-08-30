package cn.y.demo.cosumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    @RabbitListener(queues = "topic.queue1")
    public void listenTopic1Exchange(String msg){
        System.out.println("queue1 message received: " + msg);
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopic2Exchange(String msg){
        System.out.println("queue2 message received: " + msg);
    }
}
