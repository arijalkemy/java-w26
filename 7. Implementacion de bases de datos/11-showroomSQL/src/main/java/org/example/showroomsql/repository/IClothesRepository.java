package org.example.showroomsql.repository;

import org.example.showroomsql.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothesRepository extends JpaRepository<Clothes, Long> {

    List<Clothes> findAllBySize(String size);
    List<Clothes> findAllByNameContainingIgnoreCase(String size);
}
