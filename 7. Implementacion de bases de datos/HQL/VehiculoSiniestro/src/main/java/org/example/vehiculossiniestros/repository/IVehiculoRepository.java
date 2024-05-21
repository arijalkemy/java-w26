package org.example.vehiculossiniestros.repository;

import org.example.vehiculossiniestros.model.Vehiculo;
import org.example.vehiculossiniestros.projections.PatenteAndMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    public List<String> getPatenteFromAllVehiculo();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.anioDeFabricacion")
    public List<PatenteAndMarca> getPatenteAndMarcaFromVehiculoOrderByAnioDeFabricacion();
}
