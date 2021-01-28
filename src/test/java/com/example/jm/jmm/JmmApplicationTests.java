package com.example.jm.jmm;

import com.example.jm.jmm.entity.MqDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class JmmApplicationTests {

	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
    RabbitTemplate rabbitTemplate;

	@Test
	void createExchange() {
		//创建交换机
		DirectExchange directExchange = new DirectExchange("java.direct.exchange");
		amqpAdmin.declareExchange(directExchange);
		log.info("创建交换机[{}]成功",directExchange.getName());
	}
	
	@Test
	void createQueue() {
	    //创建队列
        Queue queue = new Queue("java.queue");
        amqpAdmin.declareQueue(queue);
        log.info("创建交换机[{}]成功",queue.getName());
    }

    @Test
    void createBind() {
        //创建交换机和和队列的绑定关系
        // String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object> arguments
        Binding binding = new Binding("java.queue",
                Binding.DestinationType.QUEUE,
                "java.direct.exchange",
                "test",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("交换机绑定队列成功");
    }

    @Test
    void sendMsg() {
	    //发送消息
        MqDto m = new MqDto().setName("张三").setAddress("北京");
        rabbitTemplate.convertAndSend("java.direct.exchange","test",m);
        log.info("消息发送成功");

    }
}
