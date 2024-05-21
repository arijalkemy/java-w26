package org.example.vehiculos.repository;
import org.example.vehiculos.dto.VehiculoSiniestro;
import org.example.vehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> listarTodasLasPatentes();

    List<Vehiculo> findByOrderByAnioDeFabricacionAsc();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricacion = YEAR(CURRENT_DATE)")
    List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio();

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> listarMatriculaMarcaYModeloConSiniestroMayor();

    @Query("SELECT NEW org.example.vehiculos.dto.VehiculoSiniestro(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSiniestro> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
