package com.hql.hql.repository;

import com.hql.hql.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findLicensePlate();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findVehiculoOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = :currentYear")
    List<Vehiculo> findVehiculoByCurrentYearRuedas(@Param("currentYear") int currentYear);
}
