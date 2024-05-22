package com.implementaciondb.ejercicio8_productos_elasticsearch.mapper;

import com.implementaciondb.ejercicio8_productos_elasticsearch.model.domain.Product;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductRequestDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductResponseDto;

public class ProductMapper {

    public static Product mapToProduct(ProductRequestDto ProductRequestDto) {
        return Product.builder()
                .nombre(ProductRequestDto.getNombre())
                .tipo(ProductRequestDto.getTipo())
                .precioVenta(ProductRequestDto.getPrecioVenta())
                .precioCosto(ProductRequestDto.getPrecioCosto())
                .cantidadDisponible(ProductRequestDto.getCantidadDisponible())
                .build();
    }

    public static ProductResponseDto mapToProductResponseDto(Product Product) {
        return ProductResponseDto.builder()
                .id(Product.getId())
                .nombre(Product.getNombre())
                .tipo(Product.getTipo())
                .precioVenta(Product.getPrecioVenta())
                .precioCosto(Product.getPrecioCosto())
                .cantidadDisponible(Product.getCantidadDisponible())
                .build();
    }

}
