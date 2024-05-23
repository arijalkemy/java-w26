package com.exercise.demo.repository;

import com.exercise.demo.entity.MiniSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerieEntity, Long> {
}
