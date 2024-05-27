package meli.bootcamp.obrasliterarias.repository;

import meli.bootcamp.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findObraLiterariasByAutor(String autor);

    List<ObraLiteraria> findObraLiterariasByNombreContaining(String contenido);

    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> findAllByAnioPrimeraPublicacionBefore(Integer year);

    List<ObraLiteraria> findAllByEditorialEqualsIgnoreCase(String editorial);
}
