package org.example.joyeria.repository;

import org.example.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyasRepository extends JpaRepository<Joya, Long> {
}
