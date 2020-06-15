package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.dto.SampleMessage;
import es.soprasteria.formacion.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producer")
public class ProducerController {
  @Autowired
  private ProducerService producerService;

  @PostMapping()
  public ResponseEntity publishMessage(@RequestBody SampleMessage message) {
    producerService.sendMessage(message);
    return ResponseEntity.ok().build();
  }

}
