package br.com.starwars.integration.repository;

import br.com.starwars.domain.entity.Item;
import br.com.starwars.domain.entity.Traitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
