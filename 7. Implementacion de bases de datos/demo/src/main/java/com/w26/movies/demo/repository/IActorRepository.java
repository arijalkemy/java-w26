package com.w26.movies.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w26.movies.demo.entity.Actor;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
    public List<Actor> findByfavoriteMovieIsNotNull();
    public List<Actor> findByratingIsGreaterThan(BigDecimal decimal);
}
