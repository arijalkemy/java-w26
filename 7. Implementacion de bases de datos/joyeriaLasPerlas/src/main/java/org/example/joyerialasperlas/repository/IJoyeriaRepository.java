package org.example.joyerialasperlas.repository;

import org.example.joyerialasperlas.model.JoyaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJoyeriaRepository extends JpaRepository<JoyaModel, UUID> {
}
