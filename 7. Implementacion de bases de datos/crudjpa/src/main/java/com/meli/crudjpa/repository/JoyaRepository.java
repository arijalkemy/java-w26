package com.meli.crudjpa.repository;

import com.meli.crudjpa.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Integer> {
}
