package org.example.joyerialasperlas.repository;

import org.example.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {

}
