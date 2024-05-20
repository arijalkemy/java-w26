package com.backendbootcamp.firstcrud.repository;

import com.backendbootcamp.firstcrud.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
