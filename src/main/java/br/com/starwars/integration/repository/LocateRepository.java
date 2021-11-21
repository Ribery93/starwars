package br.com.starwars.integration.repository;

import br.com.starwars.domain.entity.Locate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocateRepository extends JpaRepository<Locate,Long> {

}
