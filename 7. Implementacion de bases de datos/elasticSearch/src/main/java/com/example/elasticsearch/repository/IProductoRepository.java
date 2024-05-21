package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto,String> {
    public Iterable<Producto> getProductosByNombre(String nombre);
    List<Producto> findAll();
}
