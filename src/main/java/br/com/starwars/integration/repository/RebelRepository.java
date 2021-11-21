package br.com.starwars.integration.repository;

import br.com.starwars.domain.entity.Item;
import br.com.starwars.domain.entity.Rebel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RebelRepository extends JpaRepository<Rebel,Long> {

  List<Rebel> findByNameOrderById(@Param("name") String name);
  Rebel getByIventory(Item item);
}
