package it.rabbit.mq.prjCustomRabbitMqReceiver.service;

import it.rabbit.mq.prjCustomRabbitMqReceiver.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class RabbitMQSubcriber {

   @RabbitListener(queues="${javainuse.rabbitmq.queue}")
    public void receivedMessage( Employee msg) {
       System.out.println("\n\n RabbitMQSubcriber.class --- METHOD :  Received Message: " + msg.toString());
    }
}