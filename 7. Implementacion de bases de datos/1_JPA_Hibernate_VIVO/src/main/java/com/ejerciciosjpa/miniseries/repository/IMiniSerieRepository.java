package com.ejerciciosjpa.miniseries.repository;

import com.ejerciciosjpa.miniseries.entities.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
