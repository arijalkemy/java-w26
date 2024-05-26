package com.prendas.repositories;

import com.prendas.models.VentaPrenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaPrendaRepository extends JpaRepository<VentaPrenda, Long> {
}
