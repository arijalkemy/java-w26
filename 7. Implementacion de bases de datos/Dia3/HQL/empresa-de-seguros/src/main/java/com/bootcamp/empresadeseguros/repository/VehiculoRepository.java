package com.bootcamp.empresadeseguros.repository;

import com.bootcamp.empresadeseguros.model.Vehiculo;
import com.bootcamp.empresadeseguros.model.projections.VehiculoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos registrados.
    @Query("select v.patente from Vehiculo v")
    public List<String> findAllPatentes();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select v.patente, v.marca from Vehiculo v order by v.añoDeFabricacion")
    public List<Object> findPatenteYMarca();


    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.cantidadDeRuedas > 4 and v.añoDeFabricacion = 2024")
    public List<Object> findPatenteMasDeCuatroRuedas();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
}
