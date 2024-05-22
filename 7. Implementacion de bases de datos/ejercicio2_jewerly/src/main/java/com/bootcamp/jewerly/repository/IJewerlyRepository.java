package com.bootcamp.jewerly.repository;

import com.bootcamp.jewerly.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
