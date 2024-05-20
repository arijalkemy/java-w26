package com.ejerciciosjpa.jewelry.repository;

import com.ejerciciosjpa.jewelry.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
