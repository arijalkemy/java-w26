package org.example.movies_hql.repository;

import org.example.movies_hql.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<MoviesEntity, Integer> {
}
