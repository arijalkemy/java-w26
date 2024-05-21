package com.example.consultashql.repository;

import com.example.consultashql.entity.Vehiculo;
import com.example.consultashql.projections.ResponsePatenteAndMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getPatente();

    //@Query("SELECT V.patente,V.marca,V.anio FROM Vehiculo as V ORDER BY V.anio")


    //@Query("SELECT new com.example.consultashql.dto.ResponsePatenteAndMarcaDTO(V.patente, V.marca, V.anio) FROM Vehiculo as V ORDER BY V.anio")
    @Query("SELECT V.patente as patente,V.marca as marca FROM Vehiculo as V ORDER BY V.anio")
    List<ResponsePatenteAndMarca> getPatenteAndMarca();
}
