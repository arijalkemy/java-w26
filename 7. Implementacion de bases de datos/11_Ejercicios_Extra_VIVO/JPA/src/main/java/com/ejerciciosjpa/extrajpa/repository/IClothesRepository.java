package com.ejerciciosjpa.extrajpa.repository;

import com.ejerciciosjpa.extrajpa.entities.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothesRepository extends JpaRepository<Cloth,Long> {
    List<Cloth> findAll();
    Cloth findByCodigo(Long codigo);
    List<Cloth> findClothByTalle(Integer talle);
    List<Cloth> findClothByNombre(String query);
    List<Cloth> findBy
}
