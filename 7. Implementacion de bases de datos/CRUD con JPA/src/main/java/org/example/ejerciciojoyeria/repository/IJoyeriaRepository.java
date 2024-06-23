package org.example.ejerciciojoyeria.repository;

import org.example.ejerciciojoyeria.models.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {
    List<Joya> findAllByVentaTrue();
}
