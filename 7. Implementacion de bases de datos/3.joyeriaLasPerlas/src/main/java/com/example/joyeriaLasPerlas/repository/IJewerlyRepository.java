package com.example.joyeriaLasPerlas.repository;

import com.example.joyeriaLasPerlas.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
    List<Jewerly> findAllByVentaONoIsTrue();
}
