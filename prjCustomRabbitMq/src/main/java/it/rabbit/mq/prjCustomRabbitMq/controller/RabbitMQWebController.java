package it.rabbit.mq.prjCustomRabbitMq.controller;

import it.rabbit.mq.prjCustomRabbitMq.domain.Employee;
import it.rabbit.mq.prjCustomRabbitMq.service.RabbitMQSender;
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
@RequestMapping ( value = "/javainuse-rabbitmq/1" )
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping ( value = "/producer" )
    public ResponseEntity<String> producer( @RequestParam ( "empName" ) String empName, @RequestParam ( "empId" ) String empId ) {
        Employee emp = new Employee();
        emp.setEmpId( empId );
        emp.setEmpName( empName );

        rabbitMQSender.send( emp );
        String myMsg = " +++++++++++++++ Message sent to the RabbitMQ JavaInUse Successfully";
        return new ResponseEntity<>( myMsg, HttpStatus.OK );
    }

    @RequestMapping ( method = RequestMethod.POST, produces = "application/json", value = "/producer_with_body" )
    public ResponseEntity<String> producer_with_body( @RequestBody Employee emp, HttpServletRequest httpServletRequest ) {

        String msg = rabbitMQSender.send_with_reponsebody( emp );
        return new ResponseEntity<>( msg, HttpStatus.OK );
    }

}
