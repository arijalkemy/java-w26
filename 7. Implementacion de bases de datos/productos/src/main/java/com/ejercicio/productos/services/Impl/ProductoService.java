package com.ejercicio.productos.services.Impl;

import java.util.List;

import com.ejercicio.productos.services.IProductoService;
import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.productos.dtos.ProductoDto;
import com.ejercicio.productos.models.Producto;
import com.ejercicio.productos.repositories.IProductoRepository;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public String actualizar(String id, ProductoDto producto) {
        Producto productoActual = productoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No existe el producto con id: " + id)
        );
        modelMapper.map(producto, productoActual);
        productoRepository.save(productoActual);
        return "Producto con id "+id+" actualizado";
    }

    @Override
    public String crearProducto(ProductoDto producto) {
        Producto productoNuevo = modelMapper.map(producto, Producto.class);
        productoNuevo = productoRepository.save(productoNuevo);
        return "Producto creado con exito con id "+productoNuevo.getId();
    }

    @Override
    public List<ProductoDto> listaProducto() {
        return modelMapper.map(productoRepository.findAll(), new TypeToken<List<ProductoDto>>() {}.getType());
    }

    @Override
    public ProductoDto obtenerProducto(String id) {
        return modelMapper.map(productoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id " + id + " no encontrado")
        ), ProductoDto.class);
    }
}
