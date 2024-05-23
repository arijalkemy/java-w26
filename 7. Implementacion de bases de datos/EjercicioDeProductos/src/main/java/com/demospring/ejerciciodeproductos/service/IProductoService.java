package com.demospring.ejerciciodeproductos.service;

import com.demospring.ejerciciodeproductos.model.Producto;

import java.util.List;

public interface IProductoService {
    void agregarProducto(Producto producto);
    List<Producto> obtenerProductos();
}
