package org.example.apiobrasliterarias.repository;

import org.example.apiobrasliterarias.domain.ObraLiterariaModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiterariaModel, String> {
    Streamable<ObraLiterariaModel> findByAutor(String autor);
    Streamable<ObraLiterariaModel> findByNombreContaining(String keyword);
    Streamable<ObraLiterariaModel> findTop5ByOrderByCantidadPaginasDesc();
    Streamable<ObraLiterariaModel> findByAnioPublicacionBefore(int year);
    Streamable<ObraLiterariaModel> findByEditorial(String editorial);
}
