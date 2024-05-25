package com.example.demo.repository;

import com.example.demo.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Integer> {

    @Query("SELECT DISTINCT v.patente AS matricula, v.marca AS marca, v.modelo AS modelo " +
            "FROM Siniestro s " +
            "JOIN s.vehiculoDenunciado v " +
            "WHERE s.perdidaEconomica > 10000")
    List<Object[]> findPerdidaMayor10000();

    @Query("SELECT v.patente AS matricula, v.marca AS marca, v.modelo AS modelo, SUM(s.perdidaEconomica) AS perdidaTotal " +
            "FROM Siniestro s " +
            "JOIN s.vehiculoDenunciado v " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> findPerdidaMayor10000Total();

}
