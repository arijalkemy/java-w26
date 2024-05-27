package co.com.mercadolibre.siniestros.repository;

import co.com.mercadolibre.siniestros.entity.projection.VehiculoProjection;
import co.com.mercadolibre.siniestros.entity.Vehiculo;
import co.com.mercadolibre.siniestros.entity.projection.VehiculoSumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> listarTodasLasPatentes();

    List<Vehiculo> findByOrderByAnioDeFabricacionAsc();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricacion = YEAR(CURRENT_DATE)")
    List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio();

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<VehiculoProjection> listarMatriculaMarcaYModeloConSiniestroMayor();

    @Query("SELECT v.patente as patente, v.marca as marca, v.modelo as modelo, SUM(s.perdidaEconomica) as suma FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSumProjection> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
