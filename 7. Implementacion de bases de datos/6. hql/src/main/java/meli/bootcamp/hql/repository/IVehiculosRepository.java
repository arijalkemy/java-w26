package meli.bootcamp.hql.repository;

import meli.bootcamp.hql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculosRepository extends JpaRepository<Vehiculo, Long> {

}
