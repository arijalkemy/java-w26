package com.ejercicio.showroom.repository;

import com.ejercicio.showroom.entities.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClotheRepository extends JpaRepository<Clothe, Long> {
    List<Clothe> findClothesByWaist(String waist);
    List<Clothe> findClothesByName(String name);
}
