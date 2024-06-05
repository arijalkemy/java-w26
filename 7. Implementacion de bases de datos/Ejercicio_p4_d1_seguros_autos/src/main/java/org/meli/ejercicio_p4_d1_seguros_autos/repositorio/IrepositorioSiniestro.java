package org.meli.ejercicio_p4_d1_seguros_autos.repositorio;

import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Siniestro;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoMatriculaMarcaModelo;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoDetallePerdida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IrepositorioSiniestro extends CrudRepository<Siniestro, Long> {
    /*
     *Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
     * con pérdida mayor de 10000 pesos.
     */
    @Query("SELECT v.matricula as matricula, v.marca as marca, v.modelo as modelo " +
            "FROM Siniestro s INNER JOIN s.vehiculo v " +
            "GROUP BY v.matricula, v.marca, v.modelo " +
            "HAVING SUM(s.perdida_economica) > 10000 ")
    List<VehiculoMatriculaMarcaModelo> listarLosVehicuSinDetallePerdida();

    /*
    * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    * con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
     */
    @Query("SELECT v.matricula as matricula, v.marca as marca, v.modelo as modelo, " +
            " SUM(s.perdida_economica) AS perdida " +
            " FROM Siniestro s INNER JOIN s.vehiculo v " +
            " GROUP BY v.matricula, v.marca, v.modelo " +
            " HAVING SUM(s.perdida_economica) > 10000")
    List<VehiculoDetallePerdida> listarLosVehicuConDetallePerdida();

}
