package com.vehiculossegurovivo.repositories;

import com.vehiculossegurovivo.models.Vehiculo;
import com.vehiculossegurovivo.models.projections.MatriculaMarcaModelo;
import com.vehiculossegurovivo.models.projections.MatriculaMarcaModeloPerdidaTotal;
import com.vehiculossegurovivo.models.projections.PatenteMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> findAllPatentes();
    List<PatenteMarca> findByOrderByAnioFabricacion();
    @Query("select v.patente from Vehiculo v where v.cantidadRuedas>4 and v.anioFabricacion=year(current_date)")
    List<String> findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual();

    @Query("select v " +
            "from Vehiculo v " +
            "inner join Siniestro s on s.vehiculo.id = v.id " +
            "where s.perdidaEconomica > :amount")
    List<MatriculaMarcaModelo> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA(Integer amount);

    @Query("select v.patente as patente, " +
            "v.modelo as modelo, " +
            "v.marca as marca, " +
            "sum(s.perdidaEconomica) as perdidaEconomica " +
            "from Vehiculo v " +
            "inner join Siniestro s on s.vehiculo.id = v.id " +
            "where v in (select v1 from Vehiculo  v1 inner join Siniestro s2 on v1.id = s2.vehiculo.id where " +
            "s2.perdidaEconomica > :amount) " +
            "group by v.id ")
    List<MatriculaMarcaModeloPerdidaTotal> findAllMatriculaMarcaModeloBySiniestroPerdidaTotalMayorA(Integer amount);

}
