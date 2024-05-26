package com.prendas.repositories;

import com.prendas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentasRepository extends JpaRepository<Venta, Long> {
}
