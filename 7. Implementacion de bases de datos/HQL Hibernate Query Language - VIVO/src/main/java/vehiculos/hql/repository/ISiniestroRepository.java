package vehiculos.hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vehiculos.hql.model.Siniestro;
import vehiculos.hql.model.Vehiculo;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
    List<Siniestro> findByVehiculo(Vehiculo vehiculo);

}
