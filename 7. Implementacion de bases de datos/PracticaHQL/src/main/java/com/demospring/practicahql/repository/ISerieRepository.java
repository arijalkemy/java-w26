package com.demospring.practicahql.repository;

import com.demospring.practicahql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends CrudRepository<Serie, Long> {

    @Query("SELECT s.title FROM Serie s WHERE SIZE(s.seasons) > :cantSeasons")
    List<String> findSerieByCantSeasonsOver(int cantSeasons);
}
