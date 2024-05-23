package org.example.ejercicios_extra_bd_relacional.repository;

import org.example.ejercicios_extra_bd_relacional.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findByTalle(String talle);
    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
}
