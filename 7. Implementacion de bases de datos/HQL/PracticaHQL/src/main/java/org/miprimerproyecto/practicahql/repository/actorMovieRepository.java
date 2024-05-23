package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface actorMovieRepository extends CrudRepository<ActorMovie,Long> {
    List<ActorMovie> findAll();
}
