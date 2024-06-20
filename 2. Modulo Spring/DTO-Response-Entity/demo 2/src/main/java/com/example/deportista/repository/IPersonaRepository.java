package com.example.deportista.repository;



import com.example.deportista.entities.Persona;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{


        List<Persona> findAll();
}
