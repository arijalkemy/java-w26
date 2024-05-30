package com.mercadolibre.Obras_Literarias.repository;


import com.mercadolibre.Obras_Literarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreIsLike(String nombre);
    List<ObraLiteraria> findObraLiterariaByAnioPublicacionIsBefore(int year);
    List<ObraLiteraria> findObraLiterariaByEditorial(String editorial);
}
