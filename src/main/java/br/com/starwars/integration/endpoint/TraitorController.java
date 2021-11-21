package br.com.starwars.integration.endpoint;

import br.com.starwars.domain.entity.Traitor;
import br.com.starwars.integration.repository.TraitorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraitorController {

  @Autowired
  public TraitorRepository traitorRepository;

  @GetMapping("/traitor")
  public ResponseEntity all() {
    List<Traitor> traitor = new ArrayList<>();
    try {
      traitor.addAll(traitorRepository.findAll());
    } catch (Exception e) {
    }
    return ResponseEntity.ok(traitor);
  }


  @PostMapping("/traitor")
  public ResponseEntity newTraitor(@RequestBody Traitor object) {
    Traitor traitor = new Traitor();
    try {
      traitor = traitorRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(traitor);
  }


  @DeleteMapping("/traitor/{id}")
  public void delete(@PathVariable Long id) {
    try {
      traitorRepository.delete(traitorRepository.getOne(id));
    } catch (Exception e) {
    }
  }

}
