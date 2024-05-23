package org.example.elasticksearch.service;

import org.example.elasticksearch.domain.Producto;
import org.example.elasticksearch.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductosService {

    @Autowired
    ProductoRepository productoReposiroty;

    @Override
    public Producto createProducto(Producto producto) {
        return productoReposiroty.save(producto);
    }
}
