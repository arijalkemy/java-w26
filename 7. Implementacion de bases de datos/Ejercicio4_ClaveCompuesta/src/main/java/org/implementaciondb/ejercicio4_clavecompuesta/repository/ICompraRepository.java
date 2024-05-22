package org.implementaciondb.ejercicio4_clavecompuesta.repository;

import org.implementaciondb.ejercicio4_clavecompuesta.entity.Compra;
import org.implementaciondb.ejercicio4_clavecompuesta.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
