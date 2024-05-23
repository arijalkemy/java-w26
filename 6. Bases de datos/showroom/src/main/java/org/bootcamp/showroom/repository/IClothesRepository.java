package org.bootcamp.showroom.repository;

import org.bootcamp.showroom.entities.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClothesRepository extends JpaRepository<Clothe, Long> {
    Optional<Clothe> findClotheByCode(String code);
    List<Clothe> findClotheByWaistEquals(String waist);
    List<Clothe> findClotheByNameIgnoreCase(String name);
}
