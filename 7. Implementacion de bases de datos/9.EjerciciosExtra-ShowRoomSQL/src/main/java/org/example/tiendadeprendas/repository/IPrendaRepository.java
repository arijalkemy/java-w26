package org.example.tiendadeprendas.repository;

import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.example.tiendadeprendas.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findPrendasByTalla(String size);
    List<Prenda> findByNombre(String nombre);
    List<Prenda> findByCodigo(Long codigo);
}
