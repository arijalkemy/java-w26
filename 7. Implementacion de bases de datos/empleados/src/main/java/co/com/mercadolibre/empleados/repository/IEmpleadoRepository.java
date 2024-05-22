package co.com.mercadolibre.empleados.repository;

import co.com.mercadolibre.empleados.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    List<Empleado> findAll();
}
