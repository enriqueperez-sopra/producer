package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producer")
public class ProducerController {
  @Autowired
  private ProducerService producerService;

  @GetMapping(value = "/{message}")
  public ResponseEntity publishMessage(@PathVariable(name="message") String message) {
    producerService.sendMessage(message);
    return ResponseEntity.ok().build();
  }

}
