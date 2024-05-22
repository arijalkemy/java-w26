package org.example.vehiculossiniestros.repository;

import org.example.vehiculossiniestros.model.Vehiculo;
import org.example.vehiculossiniestros.model.projections.PatenteMarca;
import org.example.vehiculossiniestros.model.projections.PatenteMarcaModelo;
import org.example.vehiculossiniestros.model.projections.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    public List<String> getPatenteFromAllVehiculo();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.anioDeFabricacion")
    public List<PatenteMarca> getPatenteAndMarcaFromVehiculoOrderByAnioDeFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricacion = :currentYear")
    public List<String> getPatenteFromVehiculosWithMoreThan4WheelsAndManufacturedThisYear(
            @Param("currentYear") int currentYear);

    //@Query("SELECT DISTINCT v.patente AS patente, v.marca AS marca, v.modelo AS modelo " +
    //        "FROM Vehiculo v INNER JOIN Siniestro s ON v.id = s.vehiculo.p WHERE s.perdidaEconomica > 10000")
    @Query("SELECT DISTINCT s.vehiculo.patente AS patente, s.vehiculo.marca AS marca, s.vehiculo.modelo AS modelo " +
            "FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    public List<PatenteMarcaModelo> getPatenteMarcaModeloWhereSiniestroIsBig();

//    @Query("SELECT s.vehiculo.patente AS patente, s.vehiculo.marca AS marca, s.vehiculo.modelo AS modelo, " +
    @Query("SELECT s.vehiculo AS vehiculo, " +
            "SUM(s.perdidaEconomica) AS siniestro " +
            "FROM Siniestro s WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY s.vehiculo.id")
    public List<VehiculoSiniestro> getPatenteMarcaModeloAndTotalLossWhereSiniestroIsBig();
}
