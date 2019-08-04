package it.rabbit.mq.prjCustomRabbitMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PrjCustomRabbitMqProducerApplication {

    public static void main( String[] args ) {

        SpringApplication.run( PrjCustomRabbitMqProducerApplication.class, args );
    }

}
