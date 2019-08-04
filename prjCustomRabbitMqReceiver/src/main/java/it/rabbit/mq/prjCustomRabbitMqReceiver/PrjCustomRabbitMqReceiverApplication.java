package it.rabbit.mq.prjCustomRabbitMqReceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PrjCustomRabbitMqReceiverApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrjCustomRabbitMqReceiverApplication.class, args);
	}

}
