package com.meli.obrasliterarias.repository;

import com.meli.obrasliterarias.model.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObrasRepository extends ElasticsearchRepository<ObrasLiterarias,String> {
    List<ObrasLiterarias> findObrasLiterariasByNombreDeAutor(String nombreDeAutor);

    //Requisito 2.
    List<ObrasLiterarias> findByNombreContainingIgnoreCase(String keyword);

}
