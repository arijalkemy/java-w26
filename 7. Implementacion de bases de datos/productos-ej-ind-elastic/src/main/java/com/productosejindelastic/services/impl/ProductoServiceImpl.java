package com.productosejindelastic.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productosejindelastic.DTOs.ProductoRequestDTO;
import com.productosejindelastic.models.Producto;
import com.productosejindelastic.repositories.IProductoRepository;
import com.productosejindelastic.services.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository productoRepository;
    private final ObjectMapper objectMapper;


    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Producto crear(ProductoRequestDTO productoRequestDTO) {
        Producto producto = this.objectMapper.convertValue(productoRequestDTO, Producto.class);

        this.productoRepository.save(producto);

        return producto;
    }

    @Override
    public Producto findById(String id) {
        Producto producto =  this.productoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto no encontrado")
        );

        return producto;
    }

    @Override
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto update(String id, ProductoRequestDTO productoRequestDTO) {
        if(!this.productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        Producto productoWithUpdates = objectMapper.convertValue(productoRequestDTO, Producto.class);

        productoWithUpdates.setId(id);

        this.productoRepository.save(productoWithUpdates);

        return productoWithUpdates;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }
}
