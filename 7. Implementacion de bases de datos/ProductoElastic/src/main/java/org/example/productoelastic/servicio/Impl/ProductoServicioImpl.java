package org.example.productoelastic.servicio.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productoelastic.dto.ProductoDTO;
import org.example.productoelastic.entity.Producto;
import org.example.productoelastic.repository.ProductoRepository;
import org.example.productoelastic.servicio.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    private ObjectMapper objectMapper;

    public ProductoServicioImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO empleado) {
        return converToDTO(productoRepository.save(converToProducto(empleado)));
    }

    Producto converToProducto(ProductoDTO producto){
        return objectMapper.convertValue(producto, Producto.class);
    }

    ProductoDTO converToDTO(Producto producto){
        return objectMapper.convertValue(producto, ProductoDTO.class);
    }
}
