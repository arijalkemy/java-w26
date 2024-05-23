package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Compra;
import com.example.demo.entities.CompraKey;

public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
    
}
