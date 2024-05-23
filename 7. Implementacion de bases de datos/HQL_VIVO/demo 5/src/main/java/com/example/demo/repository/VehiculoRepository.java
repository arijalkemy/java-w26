package com.example.demo.repository;

import com.example.demo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> obtenerPatentesRegistradas();
}
