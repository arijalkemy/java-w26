package empleadosNOSQL.empleadosNOSQL.repository;

import empleadosNOSQL.empleadosNOSQL.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String> {

}
