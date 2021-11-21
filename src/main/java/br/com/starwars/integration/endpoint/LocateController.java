package br.com.starwars.integration.endpoint;

import br.com.starwars.domain.entity.Locate;
import br.com.starwars.integration.repository.LocateRepository;
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
public class LocateController {

  @Autowired
  public LocateRepository locateRepository;

  @GetMapping("/locate")
  public ResponseEntity all() {
    List<Locate> locate = new ArrayList<>();
    try {
      locate.addAll(locateRepository.findAll());
    } catch (Exception e) {
    }
    return ResponseEntity.ok(locate);
  }


  @PostMapping("/locate")
  public ResponseEntity newLocate(@RequestBody Locate object) {
    Locate locate = new Locate();
    try {
      locate = locateRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(locate);
  }

  @GetMapping("/locate/{id}")
  public ResponseEntity one(@PathVariable Long id) {
    Locate locate = new Locate();
    try {
      locate = locateRepository.getOne(id);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(locate);
  }

  @PutMapping("/locate/{id}")
  public ResponseEntity put(@RequestBody Locate object) {
    Locate locate = new Locate();
    try {
      locate = locateRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(locate);
  }

  @DeleteMapping("/locate/{id}")
  public void delete(@PathVariable Long id) {
    try {
      locateRepository.delete(locateRepository.getOne(id));
    } catch (Exception e) {
    }
  }

}
