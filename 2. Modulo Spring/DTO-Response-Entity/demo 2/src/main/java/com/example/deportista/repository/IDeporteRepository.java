package com.example.deportista.repository;

import com.example.deportista.entities.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeporteRepository extends JpaRepository<Deporte, Long>{

    List<Deporte> findAll();
    Deporte findByNombre(String nombre);
}
