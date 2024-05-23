package com.demospring.ejerciciodeproductos.service.impl;

import com.demospring.ejerciciodeproductos.model.Producto;
import com.demospring.ejerciciodeproductos.repository.IProductoRepository;
import com.demospring.ejerciciodeproductos.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService {
    private final IProductoRepository productoRepository;

    @Override
    public void agregarProducto(Producto producto){
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }
}
