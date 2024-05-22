package meli.bootcamp.hql.repository;

import java.util.List;
import meli.bootcamp.hql.model.Vehiculo;
import meli.bootcamp.hql.projection.PatenteYMarcaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVehiculosRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v order by v.anioFabricacion desc")
    List<PatenteYMarcaView> findAllPatentesYMarcasOrdenadasPorAnioFabricacionDesc();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v order by v.anioFabricacion")
    List<PatenteYMarcaView> findAllPatentesYMarcasOrdenadasPorAnioFabricacionAsc();

    @Query(
        "SELECT v.patente FROM Vehiculo v " +
        "WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = year(CURRENT DATE)"
    )
    List<String> findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio();
}
