package co.com.mercadolibre.siniestros.repository;

import co.com.mercadolibre.siniestros.dto.MarcaModeloPatenteDTO;
import co.com.mercadolibre.siniestros.dto.MarcaModeloPatentePerdidaDTO;
import co.com.mercadolibre.siniestros.entity.Vehiculo;
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

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<MarcaModeloPatenteDTO> listarMatriculaMarcaYModeloConSiniestroMayor();

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<MarcaModeloPatentePerdidaDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
