package org.example.showroom.repository;

import org.example.showroom.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothesRepository extends JpaRepository<Clothes,Long> {
    List<Clothes> findAllBySize(String size);
    List<Clothes> findAllByNameContainingIgnoreCase(String name);
}
