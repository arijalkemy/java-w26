package com.crudpractice.movies.repository;

import com.crudpractice.movies.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Integer> {
}
