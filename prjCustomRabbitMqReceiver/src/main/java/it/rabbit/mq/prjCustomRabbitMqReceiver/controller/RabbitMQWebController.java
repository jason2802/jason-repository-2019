package it.rabbit.mq.prjCustomRabbitMqReceiver.controller;

import it.rabbit.mq.prjCustomRabbitMqReceiver.domain.Employee;
import it.rabbit.mq.prjCustomRabbitMqReceiver.service.RabbitMQSender;
import it.rabbit.mq.prjCustomRabbitMqReceiver.service.RabbitMQSubcriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping( value = "/javainuse-rabbitmq/2" )
public class RabbitMQWebController {

    @Autowired
    RabbitMQSubcriber rabbitMQSubcriber;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/receiver")
    public ResponseEntity<String>  receiver( @RequestBody Employee emp,  HttpServletRequest httpServletRequest ) {

        rabbitMQSubcriber.receivedMessage(emp);
        String message = "\n  ????????? METHOD RECEIVER - Message RECEIVED FROM the RabbitMQ JavaInUse Successfully ";
        return new ResponseEntity<>( message, HttpStatus.OK);
    }

}
