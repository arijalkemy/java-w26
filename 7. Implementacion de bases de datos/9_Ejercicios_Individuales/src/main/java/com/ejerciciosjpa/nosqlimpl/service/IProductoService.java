package com.ejerciciosjpa.nosqlimpl.service;

import com.ejerciciosjpa.nosqlimpl.dto.ProductoRequestDto;
import com.ejerciciosjpa.nosqlimpl.dto.ProductoResponseDto;

import java.util.List;

public interface IProductoService {
    List<ProductoResponseDto> getAllProducto();
    ProductoResponseDto save(ProductoRequestDto request);
    ProductoResponseDto modify(String id, ProductoRequestDto request);
}
