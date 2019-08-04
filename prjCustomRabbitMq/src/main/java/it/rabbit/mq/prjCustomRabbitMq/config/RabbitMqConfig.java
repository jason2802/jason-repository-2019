package it.rabbit.mq.prjCustomRabbitMq.config;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitMqConfig {

    @Value ( "${javainuse.rabbitmq.exchange}" )
    private String exchange;

    @Value ( "${javainuse.rabbitmq.queue}" )
    private String queueName;

    @Value ( "${javainuse.rabbitmq.routingkey}" )
    private String routingKey;

    @Bean
    public Queue queue() {

        return new Queue( queueName, false );
    }

    @Bean
    public DirectExchange exchange() {

        return new DirectExchange( exchange );
    }

    @Bean
    public Binding binding( Queue queue, DirectExchange exchange ) {

        return BindingBuilder.bind( queue ).to( exchange ).with( routingKey );
    }

    @Bean
    public MessageConverter jsonMessageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean ( name = "rabbitTemplate1" )
    public AmqpTemplate rabbitTemplate( ConnectionFactory connectionFactory ) {
        final RabbitTemplate rabbitTemplate1 = new RabbitTemplate( connectionFactory );
        rabbitTemplate1.setMessageConverter( jsonMessageConverter() );
        return rabbitTemplate1;
    }

    /*
    private String host;
    private int port;
    private String username;
    private String password;
    */

}
