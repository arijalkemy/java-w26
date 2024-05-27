package meli.bootcamp.movies.Repositories;

import meli.bootcamp.movies.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {
    public List<Actor> findByFavoriteMovieIsNotNull();
    public List<Actor> findByRatingGreaterThan(Double rating);
    @Query("SELECT a FROM Actor a JOIN ActorMovie am on a.id = am.actor.id " +
            "where am.movie.id = :peliculaId")
    public List<Actor> findAllActorsByMovieId(Long peliculaId);
}
