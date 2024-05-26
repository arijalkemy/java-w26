package org.responseentity.elasticspring.repository;

import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    Iterable<ObraLiteraria> findObraLiterariaByAutor(String autor);

    Iterable<ObraLiteraria> findObraLiterariaByNombreContains(String nombre);

    Iterable<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    Iterable<ObraLiteraria> findObraLiterariaByAnioPrimerPublicacionBefore(Integer anioPrimerPublicacion);

    Iterable<ObraLiteraria> findObraLiterariasByEditorial(String editorial);
}
