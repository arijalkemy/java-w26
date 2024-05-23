package org.example.ejercicios_extra_bd_relacional.repository;

import org.example.ejercicios_extra_bd_relacional.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

}
