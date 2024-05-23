package com.example.Compra.repository;

import com.example.Compra.model.Compra;
import com.example.Compra.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
