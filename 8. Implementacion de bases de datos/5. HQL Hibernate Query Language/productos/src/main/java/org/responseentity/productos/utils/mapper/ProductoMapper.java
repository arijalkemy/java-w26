package org.responseentity.productos.utils.mapper;

import org.responseentity.productos.dto.ProductoDTO;
import org.responseentity.productos.model.Producto;

public class ProductoMapper {
    public static Producto dtoToEntity(ProductoDTO productoDTO) {
        return Producto.builder()
                .id(productoDTO.getId())
                .nombre(productoDTO.getNombre())
                .tipo(productoDTO.getTipo())
                .precioVenta(productoDTO.getPrecioVenta())
                .precioCosto(productoDTO.getPrecioCosto())
                .cantidadDisponible(productoDTO.getCantidadDisponible())
                .build();
    }

    public static ProductoDTO entityToDto(Producto producto) {
        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .tipo(producto.getTipo())
                .precioVenta(producto.getPrecioVenta())
                .precioCosto(producto.getPrecioCosto())
                .cantidadDisponible(producto.getCantidadDisponible())
                .build();
    }
}
