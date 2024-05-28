package com.practicasextra.showroom.repository;

import com.practicasextra.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findAllByTalle(String talle);
    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
}