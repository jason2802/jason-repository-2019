package it.rabbit.mq.prjCustomRabbitMqReceiver.service;

import it.rabbit.mq.prjCustomRabbitMqReceiver.config.RabbitMqConfig;
import it.rabbit.mq.prjCustomRabbitMqReceiver.domain.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    AmqpTemplate rabbitTemplate1;

    @Autowired
    RabbitMqConfig rabbitMqConfig;

    private String exchange;

    private String routingkey;

    public void send( Employee employee) {
        exchange = rabbitMqConfig.getExchange();
        routingkey = rabbitMqConfig.getRoutingKey();
        rabbitTemplate1.convertAndSend(exchange, routingkey, employee);

        System.out.println("************* Send msg by = " + employee);

    }

    public String send_with_reponsebody( Employee employee) {
        exchange = rabbitMqConfig.getExchange();
        routingkey = rabbitMqConfig.getRoutingKey();
        rabbitTemplate1.convertAndSend(exchange, routingkey, employee);

        return ("************* Send msg by = " + employee);

    }
}
