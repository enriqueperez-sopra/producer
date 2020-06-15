package es.soprasteria.formacion.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

  @Bean
  public Queue rabbitQueue() {
    return QueueBuilder.durable("my-queue").build();
  }

  @Bean
  public Queue rabbitQueue2() {
    return QueueBuilder.durable("my-queue-2").build();
  }

  @Bean
  public FanoutExchange exchange() {
    return new FanoutExchange("my-exchange", true, false);
  }

  @Bean
  public Binding binding() {
    return BindingBuilder.bind(rabbitQueue()).to(exchange());
  }

  @Bean
  public Binding binding2() {
    return BindingBuilder.bind(rabbitQueue2()).to(exchange());
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public AmqpTemplate myRabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }
}
