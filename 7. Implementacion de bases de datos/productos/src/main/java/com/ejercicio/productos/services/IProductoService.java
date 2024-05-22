package com.ejercicio.productos.services;

import java.util.List;

import com.ejercicio.productos.dtos.ProductoDto;

/**
 * IProductoService
 */
public interface IProductoService {
    String actualizar(String id, ProductoDto producto);
    String crearProducto(ProductoDto producto);
    List<ProductoDto> listaProducto();
    ProductoDto obtenerProducto(String id);
}