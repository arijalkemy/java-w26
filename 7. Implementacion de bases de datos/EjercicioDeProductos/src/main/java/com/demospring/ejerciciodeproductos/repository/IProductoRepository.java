package com.demospring.ejerciciodeproductos.repository;

import com.demospring.ejerciciodeproductos.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
    List<Producto> findAll();
}
