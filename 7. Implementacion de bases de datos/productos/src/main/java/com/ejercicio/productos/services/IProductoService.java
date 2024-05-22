package com.ejercicio.productos.services;

import com.ejercicio.productos.dtos.ProductoDTO;

import java.util.List;

/**
 * IProductoService
 */
public interface IProductoService {
    String actualizar(String id, ProductoDTO producto);
    String crearProducto(ProductoDTO producto);
    List<ProductoDTO> obtenerProductos();
    ProductoDTO obtenerProductoPorId(String id);
    String eliminarProducto(String id);
}