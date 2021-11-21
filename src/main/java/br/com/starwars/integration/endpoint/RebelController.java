package br.com.starwars.integration.endpoint;

import br.com.starwars.domain.entity.Rebel;
import br.com.starwars.integration.repository.RebelRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebelController {

  @Autowired
  public RebelRepository rebelRepository;

  @GetMapping("/rebel")
  public ResponseEntity all() {
    List<Rebel> rebel = new ArrayList<>();
    try {
      rebel.addAll(rebelRepository.findAll());
    } catch (Exception e) {
    }
    return ResponseEntity.ok(rebel);
  }


  @PostMapping("/rebel")
  public ResponseEntity newRebel(@RequestBody Rebel object) {
    Rebel rebel = new Rebel();
    try {
      rebel = rebelRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(rebel);
  }

  @GetMapping("/rebel/{id}")
  public ResponseEntity one(@PathVariable Long id) {
    Rebel rebel = new Rebel();
    try {
      rebel = rebelRepository.getOne(id);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(rebel);
  }

  @PutMapping("/rebel/{id}")
  public ResponseEntity put(@RequestBody Rebel object) {
    Rebel rebel = new Rebel();
    try {
      rebel = rebelRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(rebel);
  }

  @DeleteMapping("/rebel/{id}")
  public void delete(@PathVariable Long id) {

    try {
      rebelRepository.delete(rebelRepository.getOne(id));
    } catch (Exception e) {
    }
  }

}
