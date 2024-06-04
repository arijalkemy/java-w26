package org.responseentity.movies.repository;

import org.responseentity.movies.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, Integer> {
}