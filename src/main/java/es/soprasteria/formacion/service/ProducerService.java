package es.soprasteria.formacion.service;

import es.soprasteria.formacion.dto.SampleMessage;

public interface ProducerService {
  void sendMessage(SampleMessage message);
}
