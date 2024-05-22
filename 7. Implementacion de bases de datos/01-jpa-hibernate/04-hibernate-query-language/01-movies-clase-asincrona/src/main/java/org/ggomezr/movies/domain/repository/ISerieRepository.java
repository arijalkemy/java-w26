package org.ggomezr.movies.domain.repository;

import org.ggomezr.movies.domain.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("SELECT DISTINCT s.title, se.number FROM Serie s JOIN Season se ON s.id = se.serie.id WHERE se.number > :seasons")
    List<String> findAllSeriesWithMoreThanSeasons(Integer seasons);

    @Query("SELECT DISTINCT s.title FROM Serie s WHERE s.title LIKE %:title%")
    List<String> findAllSeriesWhereTitleIs(String title);
}
