package com.ejercicio.productos.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ejercicio.productos.model.Producto;

public interface IProductoRepository extends ElasticsearchRepository<Producto,String>{
    List<Producto> findAll();
} 
