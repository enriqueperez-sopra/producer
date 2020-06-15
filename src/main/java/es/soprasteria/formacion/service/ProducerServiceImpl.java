package es.soprasteria.formacion.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

  @Autowired
  private AmqpTemplate myRabbitTemplate;

  @Override
  public void sendMessage(String message) {
    myRabbitTemplate.send("my-exchange", "key", new Message(message.getBytes(), new MessageProperties()));
  }
}
