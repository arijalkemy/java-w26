package com.example.miniseries.repository;

import com.example.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long>{

}
