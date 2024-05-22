package com.ejerciciosjpa.nosqlimpl.service;

import com.ejerciciosjpa.nosqlimpl.domain.Producto;
import com.ejerciciosjpa.nosqlimpl.dto.ProductoRequestDto;
import com.ejerciciosjpa.nosqlimpl.dto.ProductoResponseDto;
import com.ejerciciosjpa.nosqlimpl.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<ProductoResponseDto> getAllProducto() {
        ModelMapper mapper = new ModelMapper();
        return productoRepository.findAll().stream().map(e->mapper.map(e,ProductoResponseDto.class)).toList();
    }

    @Override
    public ProductoResponseDto save(ProductoRequestDto request) {
        ModelMapper mapper = new ModelMapper();
        Producto response = productoRepository.save(mapper.map(request, Producto.class));
        return mapper.map(response,ProductoResponseDto.class);
    }

    @Override
    public ProductoResponseDto modify(String id,ProductoRequestDto request) {
        ModelMapper mapper = new ModelMapper();
        Producto productToUpdate = productoRepository.findById(id).orElse(null);
        productToUpdate.setNombre(request.getNombre());
        Producto response = productoRepository.save(mapper.map(request, Producto.class));
        return mapper.map(response,ProductoResponseDto.class);
    }
}
