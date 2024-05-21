package com.meli.PracticaHQL.repository;

import com.meli.PracticaHQL.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {

    List<Vehiculo> findAllByOrderByAnioDeFabricacion();

    List<Vehiculo> findAllByCantidadDeRuedasGreaterThanEqualAAndAnioDeFabricacionGreaterThanEqual(int ruedas, int anio);
}
