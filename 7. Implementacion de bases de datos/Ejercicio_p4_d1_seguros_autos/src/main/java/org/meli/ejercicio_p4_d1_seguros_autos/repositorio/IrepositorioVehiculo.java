package org.meli.ejercicio_p4_d1_seguros_autos.repositorio;

import org.meli.ejercicio_p4_d1_seguros_autos.dto.VehiculoPatenteMarcaDto;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Vehiculo;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoConSiniestrosProjection;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoPatentenMarca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IrepositorioVehiculo extends CrudRepository<Vehiculo, Integer> {
    //Listar las patentes de todos los vehículos registrados.
    @Query("select v.patente from Vehiculo v")
    List<String> listarLasPatentes();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.agno_fabricacion")
    List<VehiculoPatentenMarca> listarLasPatentesMarcas();

    /*
    *Listar la patente de todos los vehículos que tengan más de cuatro ruedas y
    *hayan sido fabricados en el corriente año.
    */

    @Query("select v.patente from Vehiculo v where v.num_ruedas > :ruedas and v.agno_fabricacion > :agno")
    List<String> listarLasPatentesFilRuedasAgno(@Param("ruedas") Integer ruedas, @Param("agno") Integer agno);

    @Query("SELECT v.matricula AS matricula, v.patente AS patente, v.marca AS marca, v.modelo AS modelo, " +
            " v.agno_fabricacion AS agnoFabricacion, v.num_ruedas AS numRuedas, v.siniestros AS siniestros " +
            " FROM Vehiculo v")
    List<VehiculoConSiniestrosProjection> listarVehiculosConSiniestros();

    @Query("SELECT v.matricula AS matricula, v.patente AS patente, v.marca AS marca, v.modelo AS modelo, " +
            " v.agno_fabricacion AS agnoFabricacion, v.num_ruedas AS numRuedas, v.siniestros AS siniestros " +
            " FROM Vehiculo v" +
            " where v.id = :id")
    List<VehiculoConSiniestrosProjection> listarVehiculosPorId(@Param("id") Long id);

}
