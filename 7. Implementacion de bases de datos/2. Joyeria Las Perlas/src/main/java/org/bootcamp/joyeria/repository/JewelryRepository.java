package org.bootcamp.joyeria.repository;

import org.bootcamp.joyeria.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Integer> {
    List<Jewelry> findAllBySellTrue();
}
