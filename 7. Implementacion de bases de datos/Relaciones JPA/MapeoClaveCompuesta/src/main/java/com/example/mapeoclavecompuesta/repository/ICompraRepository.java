package com.example.mapeoclavecompuesta.repository;

import com.example.mapeoclavecompuesta.model.Compra;
import com.example.mapeoclavecompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ICompraRepository extends JpaRepository<Compra, Long> {
}
