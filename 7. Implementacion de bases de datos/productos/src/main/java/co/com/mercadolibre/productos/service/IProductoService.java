package co.com.mercadolibre.productos.service;

import co.com.mercadolibre.productos.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    ProductoDTO create(ProductoDTO productoDTO);
    ProductoDTO update(ProductoDTO productoDTO, String id);
    List<ProductoDTO> findAll();
}
