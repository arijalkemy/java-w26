package com.example.sinisestros.repository;

import com.example.sinisestros.dto.VehiculoPatMarModDto;
import com.example.sinisestros.models.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {


    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
    // mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos

    @Query("select sum(s.perdidaEconomica) as perdidaTotal from Siniestro s where s.perdidaEconomica > 10000")
    Double getPerdidaTotalWherePerdidaMayorQue10000();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un
    // siniestro con pérdida mayor de 10000 pesos.
    @Query("select s from Siniestro s where s.perdidaEconomica > 10000")
    List<Siniestro> getDatosVehiculosWherePerdidaMayorQue1000();
}
