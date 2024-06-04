package org.responseentity.productos.service;

import org.responseentity.productos.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> listAllProductos();
    ProductoDTO getProductoById(String id);
    ProductoDTO saveProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(String id, ProductoDTO productoDTO);
    void deleteProducto(String id);
}
