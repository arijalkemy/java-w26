package org.example.producto.service;

import org.example.producto.dto.ProductoDto;
import org.example.producto.model.Producto;

import java.util.List;

public interface IProductService {
    public void saveProducto(ProductoDto productoDto);
    public void updateProducto (ProductoDto productoDto);
    public List<ProductoDto> getAllProductos();
}
