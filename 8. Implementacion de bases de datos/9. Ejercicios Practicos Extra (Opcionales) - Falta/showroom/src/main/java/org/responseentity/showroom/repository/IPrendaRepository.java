package org.responseentity.showroom.repository;

import org.responseentity.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

    public List<Prenda> findAllByTalla(String talla);

}
