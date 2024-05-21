package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Producto;
import com.example.elasticsearch.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {
    private final IProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Iterable<Producto> getProductosByName(String nombre) {
        return productoRepository.getProductosByNombre(nombre);
    }

    public Producto insertProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    /*
    public Producto updateProduct(Producto producto,int id) {
        Producto productoFind = productoRepository.findById(id).get();
        productoFind.setPrecio(producto.getPrecio());
        return productoFind;
    }

    public Producto deleteProducto(int id){
        Producto productoFind = productoRepository.findById(id).get();
        productoRepository.deleteById(productoFind.getId());
        return productoFind;
    }
    }
     */


}
