package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothesRepository extends JpaRepository<Clothes, Long> {

    List<Clothes> findAllBySize(String size);
    List<Clothes> findAllByNameContainingIgnoreCase(String size);
}
