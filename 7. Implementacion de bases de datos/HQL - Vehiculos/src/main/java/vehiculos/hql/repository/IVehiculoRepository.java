package vehiculos.hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vehiculos.hql.model.Vehiculo;
import vehiculos.hql.model.projection.PatenteAndMarca;
import vehiculos.hql.model.projection.PatenteMarcaAndModelo;
import vehiculos.hql.model.projection.PerdidaTotal;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.anoFabricacion")
    List<PatenteAndMarca> findAllPatentesAndMarcaOrderedByAnoFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anoFabricacion = year(CURRENT_DATE)")
    List<String> findAllPatentesWithMoreThanFourWheelsAndFabricatedThisYear();

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<PatenteMarcaAndModelo> findAllVehiculosWithSiniestroGreaterThan10000();

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo, SUM(s.perdidaEconomica) AS perdidaTotal FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.id")
    List<PerdidaTotal> findAllVehiculosWithSiniestroGreaterThan10000AndTotalLoss();
}
