package com.example.showroom.repository;

import com.example.showroom.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

     List<Clothes> findAllByBrandContains(String name);
     List<Clothes> findAllBySize(String size);
}
