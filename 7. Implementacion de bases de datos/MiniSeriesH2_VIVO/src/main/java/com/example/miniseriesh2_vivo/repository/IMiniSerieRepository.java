package com.example.miniseriesh2_vivo.repository;


import com.example.miniseriesh2_vivo.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
