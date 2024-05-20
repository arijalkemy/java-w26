package org.example.pearl_jewelry.repository;

import org.example.pearl_jewelry.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewel, Long> {
}
