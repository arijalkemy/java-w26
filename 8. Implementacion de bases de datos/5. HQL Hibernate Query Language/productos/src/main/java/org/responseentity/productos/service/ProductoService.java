package org.responseentity.productos.service;

import org.responseentity.productos.dto.ProductoDTO;
import org.responseentity.productos.model.Producto;
import org.responseentity.productos.repository.ProductoRepository;
import org.responseentity.productos.utils.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listAllProductos() {
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return productos.stream()
                .map(producto -> ProductoMapper.entityToDto(producto))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO getProductoById(String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(!producto.isPresent())
        {
            throw new RuntimeException("producto not found");
        }
        return ProductoMapper.entityToDto(producto.get());
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDTO) {
        Producto producto = productoRepository.save(ProductoMapper.dtoToEntity(productoDTO));
        return ProductoMapper.entityToDto(producto);
    }

    @Override
    public ProductoDTO updateProducto(String id, ProductoDTO productoDTO) {
        Optional<Producto> productoTemp = productoRepository.findById(id);
        if(!productoTemp.isPresent())
        {
            throw new RuntimeException("producto not found");
        }

        Producto producto = productoTemp.get();
        producto.setNombre(productoDTO.getNombre());
        producto.setTipo(productoDTO.getTipo());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setPrecioCosto(productoDTO.getPrecioCosto());
        producto.setCantidadDisponible(producto.getCantidadDisponible());

        Producto productoUpdated = productoRepository.save(producto);
        return ProductoMapper.entityToDto(productoUpdated);
    }

    @Override
    public void deleteProducto(String id) {
        productoRepository.deleteById(id);
    }
}
