package org.example.showroom.repository;

import org.example.showroom.DTO.ResponseClothesDTO;
import org.example.showroom.model.ClothesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<ClothesModel, Long> {
     List<ClothesModel> findBySize(float size);
     List<ClothesModel> findByNameContainingIgnoreCase(String keyword);
}
