package com.ejercicio.productos.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ejercicio.productos.models.Producto;

public interface IProductoRepository extends ElasticsearchRepository<Producto,String>{
    List<Producto> findAll();
} 
