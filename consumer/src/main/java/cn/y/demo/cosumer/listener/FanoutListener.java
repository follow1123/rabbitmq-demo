package cn.y.demo.cosumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutListener {

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanout1Exchange(String msg){
        System.out.println("message received: " + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanout2Exchange(String msg){
        System.out.println("message received: " + msg);
    }
}
