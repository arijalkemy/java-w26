package com.bootcamp.joyeria.repositories;

import com.bootcamp.joyeria.entities.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
