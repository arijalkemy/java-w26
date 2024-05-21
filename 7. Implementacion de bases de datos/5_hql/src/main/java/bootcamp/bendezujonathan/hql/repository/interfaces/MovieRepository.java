package bootcamp.bendezujonathan.hql.repository.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.hql.model.Movie;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long> {
    
    @Query("SELECT m FROM Movie m join m.actors a where a.rating > :rating")
    List<Movie> findByActorsRating(@Param("rating") double rating);

}
