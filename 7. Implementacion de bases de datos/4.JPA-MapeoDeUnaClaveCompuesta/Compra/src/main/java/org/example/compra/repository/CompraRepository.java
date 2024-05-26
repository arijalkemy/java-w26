package org.example.compra.repository;

import org.example.compra.model.Compra;
import org.example.compra.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
