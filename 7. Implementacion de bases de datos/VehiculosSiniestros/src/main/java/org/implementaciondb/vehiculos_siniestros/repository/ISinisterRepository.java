package org.implementaciondb.vehiculos_siniestros.repository;

import org.implementaciondb.vehiculos_siniestros.model.entity.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISinisterRepository extends JpaRepository<Sinister, Long> {

    @Query("SELECT s " +
            "FROM Sinister s " +
            "WHERE s.vehicle.id = :id"
    )
    List<Sinister> findByVehicleId(@Param("id") Long id);

    @Query("SELECT s " +
            "FROM Sinister s")
    List<Sinister> findAll();



}
