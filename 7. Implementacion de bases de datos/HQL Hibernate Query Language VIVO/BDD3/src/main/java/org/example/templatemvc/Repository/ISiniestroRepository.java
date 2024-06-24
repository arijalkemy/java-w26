package org.example.templatemvc.Repository;

import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.Repository.Entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    List<Siniestro> findAllByPerdidaGreaterThan(Double perdida);


    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, SUM(s.perdida) FROM Siniestro s WHERE s.perdida"
            + " > " + "10000 GROUP BY s.vehiculo.patente, s.vehiculo.marca ORDER BY SUM(s.perdida) DESC")
    List<PatenteMarca> findAllPatenteMarcaSumPerdida();

}
