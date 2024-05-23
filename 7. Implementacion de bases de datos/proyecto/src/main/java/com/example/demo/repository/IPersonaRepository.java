package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Persona;
import com.example.demo.entities.PersonaKey;

public interface IPersonaRepository extends JpaRepository<Persona, PersonaKey> {
    
}
