package com.w26.seguros_autos.seguros_autos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.w26.seguros_autos.seguros_autos.entity.Siniestro;
import com.w26.seguros_autos.seguros_autos.mediator.projection.SimpleSiniestro;

@Repository
public interface ISiniestroRepository extends  JpaRepository<Siniestro, Long> {

    @Query(value = "SELECT s from Siniestro as s")
    List<SimpleSiniestro> findAllSimpleSiniestro();
}
