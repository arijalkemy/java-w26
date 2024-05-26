package com.example.ejerciciojpayhibernatevivo.repository;

import com.example.ejerciciojpayhibernatevivo.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
