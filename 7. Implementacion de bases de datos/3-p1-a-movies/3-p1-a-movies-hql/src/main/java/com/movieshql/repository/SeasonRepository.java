package com.movieshql.repository;

import com.movieshql.trash.Season;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long> {
    @Query("SELECT s FROM Season s WHERE SIZE(s.episodes) > :count")
    List<Season> findByEpisodeCountGreaterThan(int count);
}
