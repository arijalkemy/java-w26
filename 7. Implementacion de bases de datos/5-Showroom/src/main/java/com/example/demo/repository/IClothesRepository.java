package com.example.demo.repository;

import com.example.demo.model.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes,Integer> {

    Clothes findClothesByCode(Long code);
    List<Clothes> findClothesBySize(String size);
    List<Clothes> findClothesByType(String type);
}
