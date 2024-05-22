package com.productosejindelastic.repositories;

import com.productosejindelastic.models.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
    List<Producto> findAll();
}
