package org.example.producto.service;

import org.example.producto.dto.ProductoDto;
import org.example.producto.exception.NotFoundException;
import org.example.producto.model.Producto;
import org.example.producto.repository.IPrductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements IProductService{
    @Autowired
    IPrductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();
    

    @Override
    public void saveProducto(ProductoDto productoDto) {
        productRepository.save(modelMapper.map(productoDto, Producto.class));
    }

    @Override
    public void updateProducto(ProductoDto productoDto) {
        String idProducto = productoDto.getId();
        Producto empleado = productRepository.findById(idProducto).orElseThrow(
                () -> new NotFoundException("NO SE ENCONTRÓ AL EMPLEADO CON ID:" + idProducto)
        );
        productRepository.save(modelMapper.map(productoDto, Producto.class));

    }

    @Override
    public List<ProductoDto> getAllProductos() {
        Iterable<Producto> empleados = productRepository.findAll();
        return StreamSupport.stream(empleados.spliterator(), false)
                .map(producto -> modelMapper.map(producto, ProductoDto.class))
                .toList();
    }
}
