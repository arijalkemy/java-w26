package com.moviesmysql.Repositories;

import com.moviesmysql.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Long> {
    @Query(
            "SELECT s FROM Serie s " +
            "inner join Season se on s.id = se.serie.id " +
            "group by s.id having count(*) > :cantTemporadas"
    )
    List<Serie> findByTemporadasGreaterThan(Integer cantTemporadas);

}
