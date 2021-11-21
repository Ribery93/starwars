package br.com.starwars.integration.endpoint;

import br.com.starwars.domain.entity.Galaxy;
import br.com.starwars.integration.repository.GalaxyRepository;
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
public class GalaxyController {

  @Autowired
  private GalaxyRepository galaxyRepository;

  @GetMapping("/galaxy")
  public ResponseEntity all() {
    List<Galaxy> galaxy = new ArrayList<>();
    try {
      galaxy.addAll(galaxyRepository.findAll());
    } catch (Exception e) {
    }
    return ResponseEntity.ok(galaxy);
  }


  @PostMapping("/galaxy")
  public ResponseEntity newGalaxy(@RequestBody Galaxy object) {
    Galaxy galaxy = new Galaxy();
    try {
      galaxy = galaxyRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(galaxy);
  }

  @GetMapping("/galaxy/{id}")
  public ResponseEntity one(@PathVariable Long id) {
    Galaxy galaxy = new Galaxy();
    try {
      galaxy = galaxyRepository.getOne(id);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(galaxy);
  }

  @PutMapping("/galaxy/{id}")
  public ResponseEntity put(@RequestBody Galaxy object) {
    Galaxy galaxy = new Galaxy();
    try {
      galaxy = galaxyRepository.save(object);
    } catch (Exception e) {
    }
    return ResponseEntity.ok(galaxy);
  }

  @DeleteMapping("/galaxy/{id}")
  public void delete(@PathVariable Long id) {
    try {
      galaxyRepository.delete(galaxyRepository.getOne(id));
    } catch (Exception e) {
    }
  }

}
