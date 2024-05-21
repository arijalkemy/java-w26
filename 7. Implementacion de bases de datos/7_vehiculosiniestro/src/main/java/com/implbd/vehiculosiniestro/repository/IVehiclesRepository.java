package com.implbd.vehiculosiniestro.repository;

import com.implbd.vehiculosiniestro.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiclesRepository extends JpaRepository<Vehicle, Long> {
}
