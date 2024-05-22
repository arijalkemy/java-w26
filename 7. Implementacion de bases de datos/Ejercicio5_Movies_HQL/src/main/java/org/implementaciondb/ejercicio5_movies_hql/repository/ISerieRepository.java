package org.implementaciondb.ejercicio5_movies_hql.repository;

import org.implementaciondb.ejercicio5_movies_hql.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s " +
            "FROM Serie s " +
            "WHERE size(s.seasons) > :numberOfSeasons"
    )
    List<Serie> findByMoreSeasonsThan(@Param("numberOfSeasons") Integer numberOfSeasons);

    @Query("SELECT s " +
            "FROM Serie s JOIN s.genre g JOIN s.seasons se JOIN se.episodes e " +
            "WHERE g.name = :genreName " +
            "GROUP BY s.id " +
            "HAVING AVG(e.rating) > :averageRating"
    )
    List<Serie> findByGenreAndAverageEpisodeRatingGreaterThan(
            @Param("genreName") String genreName, @Param("averageRating") Double averageRating
    );

}
