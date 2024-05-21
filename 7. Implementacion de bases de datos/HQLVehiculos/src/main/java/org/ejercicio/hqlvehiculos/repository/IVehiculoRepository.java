package org.ejercicio.hqlvehiculos.repository;

import org.ejercicio.hqlvehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    /**
     * Todos los vehiculo registrados
     * findAll()
     */

    /**
     * Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
     */
    @Query("select v.Patente, v.Marca from Vehiculo v order by v.fechaFabricacion asc")
    List<Vehiculo> findByFechaFabricacion();

    /**
     * Listar la patente de todos los vehículos que tengan más de cuatro ruedas y
     * hayan sido fabricados en el corriente año.
     */
    @Query("select v.Patente from Vehiculo v where v.cantidadDeRuedas > 4 and year(v.fechaFabricacion) = year(current_date())")
    List<Vehiculo> findByCantidadDeRuedasAndYear();

    /**
     * Listar la matrícula, marca y modelo de todos los vehículos que
     * hayan tenido un siniestro con pérdida mayor de 10000 pesos.
     */
    @Query("select v.Patente, v.Marca, v.Modelo from Vehiculo v inner join Siniestro s where s.perdidaEconomica > 10000")
    List<Vehiculo> findBySinietro10000();

    /**
     * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido
     * un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la
     * pérdida total de todos ellos.
     */
    @Query("select sum(s.perdidaEconomica) from Vehiculo v inner join Siniestro s where s.perdidaEconomica > 10000")
    Double findPerdidaEconomica();
}
