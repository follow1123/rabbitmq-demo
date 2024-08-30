package cn.y.demo.cosumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AMQPListener {
    @RabbitListener(queues = "simple.queue")
    public void simpleQueueListener(String message){
        System.out.println("message received: " + message);
    }
    @RabbitListener(queues = "work.queue")
    public void workQueue1Listener(String message) throws InterruptedException {
        // 模拟处理能力弱的服务
        Thread.sleep(20);
        System.out.println("message received: " + message);
    }
    @RabbitListener(queues = "work.queue")
    public void workQueue2Listener(String message){
        System.err.println("message received: " + message);
    }
}
