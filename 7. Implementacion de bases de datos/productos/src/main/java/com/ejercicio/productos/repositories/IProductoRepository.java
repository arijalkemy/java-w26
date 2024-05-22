package com.ejercicio.productos.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ejercicio.productos.models.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto,String>{
    List<Producto> findAll();
} 
