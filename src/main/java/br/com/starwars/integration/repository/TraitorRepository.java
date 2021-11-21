package br.com.starwars.integration.repository;

import br.com.starwars.domain.entity.Traitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitorRepository extends JpaRepository<Traitor,Long> {

}
