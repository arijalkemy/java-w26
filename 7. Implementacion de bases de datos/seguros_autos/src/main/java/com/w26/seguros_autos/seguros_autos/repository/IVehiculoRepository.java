package com.w26.seguros_autos.seguros_autos.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.w26.seguros_autos.seguros_autos.entity.Vehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.projection.PatenteMarcaModelo;
import com.w26.seguros_autos.seguros_autos.mediator.projection.PatenteMarcaVehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo as v")
    List<String> findAllVehiculoPatente();

    @Query("select v from Vehiculo as v order by v.anoFabricacion")
    List<PatenteMarcaVehiculo> getPatenteMarcaAll();
    //En este caso la query obtiene todos los datos de un objeto, pero podria ser mejor solo seleccionar directamente PatenteMarca
  
    @Query("select v.patente from Vehiculo as v where v.cantidadRuedas > 4 and v.anoFabricacion = current_date")
    List<String> findPatenteByActualAnoFabricacion();

    @Query("select s.vehiculo from Siniestro as s where s.perdidaEconomica > 10000 group by s.vehiculo")
    List<PatenteMarcaModelo> findMajorPerdidaEconomica();

    @Query("select sum(s.perdidaEconomica) from Siniestro as s where s.perdidaEconomica > 10000")
    Double findMajorPerdidaEconomicaTotal();
}

