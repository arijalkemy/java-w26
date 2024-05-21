package meli.bootcamp.hql.repository;

import meli.bootcamp.hql.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestrosRepository extends JpaRepository<Siniestro, Long> {
}
