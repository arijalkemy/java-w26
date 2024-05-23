package com.prendas.repositories;

import com.prendas.models.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long>{
    List<Prenda> findByTalle(String size);
    List<Prenda> findByNombre(String nombre);
}
