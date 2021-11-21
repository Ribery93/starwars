package br.com.starwars.integration.repository;

import br.com.starwars.domain.entity.Galaxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalaxyRepository extends JpaRepository<Galaxy, Long> {

}
