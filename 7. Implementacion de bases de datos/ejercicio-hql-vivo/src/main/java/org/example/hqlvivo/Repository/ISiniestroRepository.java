package org.example.hqlvivo.Repository;

import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloTotalPerdidaResponseDto;
import org.example.hqlvivo.Repository.Entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo FROM Siniestro s WHERE s.perdida > 10000")
    List<PatenteMarcaModeloResponseDto> findAllDatosSiniestroWithPerdidaMayorDiezMil();

    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo, SUM(s.perdida) AS totalPerdida FROM Siniestro s WHERE s.perdida > 10000 GROUP BY s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo ORDER BY SUM(s.perdida) DESC")
    List<PatenteMarcaModeloTotalPerdidaResponseDto> findAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida();
}
