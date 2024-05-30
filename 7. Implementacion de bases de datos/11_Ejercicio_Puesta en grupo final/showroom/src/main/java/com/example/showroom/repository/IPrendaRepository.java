package com.example.showroom.repository;

import com.example.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda,Long> {

    List<Prenda> findPrendasByTalla(String talla);
    List<Prenda> findPrendasByTipo(String tipo);
}
