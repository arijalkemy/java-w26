package com.productosejindelastic.services;

import com.productosejindelastic.DTOs.ProductoRequestDTO;
import com.productosejindelastic.models.Producto;

import java.util.List;

public interface IProductoService {
    public Producto crear(ProductoRequestDTO productoRequestDTO);
    public Producto findById(String id);
    public List<Producto> findAll();
    public Producto update(String id, ProductoRequestDTO productoRequestDTO);
}
