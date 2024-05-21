package bootcamp.bendezujonathan.hql.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.hql.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    
    @Query("SELECT a FROM Actor a WHERE a.favMovie IS NOT NULL")
    List<Actor> findAllWithFavMovie();
    

    @Query("SELECT a FROM Actor a where a.rating >= :toSearch")
    List<Actor> findAllOverRating(@Param("toSearch") double rating);

    @Query("SELECT a from Actor a JOIN a.movies m WHERE m.title = :movieTitle")
    List<Actor> findAllByMovie(@Param("movieTitle") String movie);

}
