package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();
    public Iterable<Producto> getProductosByName(String nombre);
    public Producto insertProducto(Producto producto);
   // public Producto updateProduct(Producto producto,int id);
   // public Producto deleteProducto(int id);
}
