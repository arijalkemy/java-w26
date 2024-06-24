package org.example.templatemvc.Repository;

import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.Repository.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> listAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anio ASC")
    List<PatenteMarca> listAllPatenteMarcaOrderAsc();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.anio = :anio AND v.cantRuedas > '4' ")
    List<String> listAllPatentesByAnioAndCantRuedas(Integer anio);




}
