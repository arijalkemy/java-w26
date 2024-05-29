package com.w26.movies.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w26.movies.demo.entity.Episode;

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
    
}
