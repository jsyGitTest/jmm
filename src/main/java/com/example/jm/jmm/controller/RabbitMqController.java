package com.example.jm.jmm.controller;


import com.example.jm.jmm.entity.MqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RabbitMqController {

    @RabbitListener(queues = {"java.queue"})
    public void receiveMsg(Message message, MqDto mqDto){
        log.info("接收到了消息:{}",message);
        log.info("接收到了消息:{}",mqDto);
    }
}
