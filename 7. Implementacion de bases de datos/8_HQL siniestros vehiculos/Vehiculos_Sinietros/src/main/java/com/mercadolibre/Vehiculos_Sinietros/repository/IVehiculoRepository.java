package com.mercadolibre.Vehiculos_Sinietros.repository;

import com.mercadolibre.Vehiculos_Sinietros.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    List<Vehiculo> findAllBy;

}
