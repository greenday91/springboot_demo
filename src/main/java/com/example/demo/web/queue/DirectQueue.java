package com.example.demo.web.queue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct")
public class DirectQueue {

    private static Logger log = LoggerFactory.getLogger(DirectQueue.class);

    @RabbitHandler
    public void process(String message) throws Exception {
        if(message.equals("error")){
            throw new Exception("消费失败"+message);
        }
        log.info("取到消息:"+message);
    }

}
