package org.example.hqlvivo.Repository;

import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.Repository.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> listAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anio ASC")
    List<PatenteMarcaModeloResponseDto> listAllPatenteMarcaOrderAsc();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.anio = :anio AND v.cantRuedas > 4")
    List<String> listAllPatentesByAnioAndMoreThanFourRuedas(Integer anio);
}
