package es.soprasteria.formacion.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

  @Bean
  public Queue rabbitQueue() {
    return QueueBuilder.durable("my-queue").build();
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange("my-exchange", true, false);
  }

  @Bean
  public Binding binding() {
    return BindingBuilder.bind(rabbitQueue()).to(exchange()).with("key");
  }

  @Bean
  public AmqpTemplate myRabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    return rabbitTemplate;
  }
}
