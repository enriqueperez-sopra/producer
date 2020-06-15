package es.soprasteria.formacion.service;

import es.soprasteria.formacion.dto.SampleMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

  @Autowired
  private AmqpTemplate myRabbitTemplate;

  @Override
  public void sendMessage(SampleMessage message) {
    myRabbitTemplate.convertAndSend("my-exchange", null, message);
  }
}
