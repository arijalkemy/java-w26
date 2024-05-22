package com.mercadolibre.clothes.repository;

import com.mercadolibre.clothes.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Cloth, Long> {
    List<Cloth> findClothsBySizeEquals(Integer size);
    List<Cloth> findClothsByTypeEqualsIgnoreCase(String type);
}
