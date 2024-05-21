package com.example.joyeria.repository;

import com.example.joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJewelryRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findByVentaONoTrue();
}
