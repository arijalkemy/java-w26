package com.ejercicio.productos.service.Impl;

import com.ejercicio.productos.dto.ProductoDTO;
import com.ejercicio.productos.model.Producto;
import com.ejercicio.productos.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.productos.repository.IProductoRepository;

import java.util.List;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public String actualizar(String id, ProductoDTO producto) {
        Producto productoFind = productoRepository.findById(id).orElse(null);
        if (productoFind == null) {
            return "No se encontró el producto con el id " + id;
        }
        Producto producto1 = productoDtoToProducto(producto);
        producto1.setId(id);
        productoRepository.save(producto1);
        return "Producto actualizado con éxito";
    }

    @Override
    public String crearProducto(ProductoDTO producto) {
        Producto producto1 = productoDtoToProducto(producto);
        productoRepository.save(producto1);
        return "Producto creado con éxito";
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        return productoRepository.findAll().stream().map(this::productoToProductoDto).toList();
    }

    @Override
    public ProductoDTO obtenerProductoPorId(String id) {
        return productoToProductoDto(productoRepository.findById(id).orElse(null));
    }

    @Override
    public String eliminarProducto(String id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) {
            return "No se encontró el producto con el id " + id;
        }
        productoRepository.delete(producto);
        return "Producto eliminado con éxito";
    }


    public ProductoDTO productoToProductoDto(Producto producto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(producto, ProductoDTO.class);
    }

    public Producto productoDtoToProducto(ProductoDTO productoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productoDTO, Producto.class);
    }
}
