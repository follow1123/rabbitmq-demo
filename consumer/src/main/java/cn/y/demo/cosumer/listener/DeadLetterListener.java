package cn.y.demo.cosumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DeadLetterListener {

    @RabbitListener(queues = "dlx.queue")
    public void listenDLX(String message){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        System.out.println("message received: " + message);
    }
}
