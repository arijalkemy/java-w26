package com.example.showroom_vivo.repository;

import com.example.showroom_vivo.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findBySize(Double size);
    List<Clothes> findClothesByNameContainsIgnoreCase(String name);
}
