package bootcamp.vivo.obras.repository.interfaces;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bootcamp.vivo.obras.model.Obra;
import java.time.LocalDate;


@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
 
    List<Obra> findAll();
    List<Obra> findAllByAutorNombre(String name);
    List<Obra> findAllByNombre(String title);
    List<Obra> findTop5ByOrderByCantidadPaginas();
    List<Obra> findByFechaPrimerPublicacionBefore(LocalDate fechaPrimerPublicacion);
    List<Obra> findByEditorialNombre(String name);
    
}
