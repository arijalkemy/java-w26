package com.example.showroom.repository;

import com.example.showroom.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

     List<Clothes> findAllByBrandContains(String name);
     List<Clothes> findAllBySize(String size);
}
