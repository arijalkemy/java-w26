package com.prendas.repositories;

import com.prendas.models.Prenda;
import com.prendas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVentasRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFecha(LocalDate date);

    @Query(
            "SELECT vp.prenda FROM Venta v " +
                    "inner join VentaPrenda vp on vp.venta.number = v.number " +
                    "where v.number = :number"
    )
    List<Prenda> findClothesByNumber(Long number);
}
