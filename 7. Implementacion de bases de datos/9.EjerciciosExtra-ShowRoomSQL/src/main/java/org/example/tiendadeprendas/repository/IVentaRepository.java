package org.example.tiendadeprendas.repository;

import org.example.tiendadeprendas.dto.VentaDto;
import org.example.tiendadeprendas.model.Prenda;
import org.example.tiendadeprendas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    Venta findVentaByIdVenta(Long code);
    List<Venta> findAllByFecha(LocalDate fecha);
}
