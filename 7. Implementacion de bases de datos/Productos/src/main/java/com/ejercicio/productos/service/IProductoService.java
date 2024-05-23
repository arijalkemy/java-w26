package com.ejercicio.productos.service;

import com.ejercicio.productos.dto.ProductoDTO;

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