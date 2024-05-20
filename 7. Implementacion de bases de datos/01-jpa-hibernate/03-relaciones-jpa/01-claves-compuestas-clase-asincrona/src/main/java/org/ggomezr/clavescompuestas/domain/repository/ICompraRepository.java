package org.ggomezr.clavescompuestas.domain.repository;

import org.ggomezr.clavescompuestas.domain.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {
}
