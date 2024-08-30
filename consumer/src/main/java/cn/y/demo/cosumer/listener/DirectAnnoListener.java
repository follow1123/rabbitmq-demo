package cn.y.demo.cosumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

// @Component
public class DirectAnnoListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "test.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    // @RabbitListener(queuesToDeclare = @Queue(
    //         name = "lazy.queue",
    //         durable = "true",
    //         arguments = @Argument(name = "x-queue-mode", value = "lazy")
    // ))
    public void listenDirect1Exchange(String msg){
        System.out.println("queue1 message received: " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "test.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirect2Exchange(String msg){
        System.out.println("queue2 message received: " + msg);
    }
}
