package com.example.comprarclavecompuesta.repository;

import com.example.comprarclavecompuesta.model.Compra;
import com.example.comprarclavecompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
