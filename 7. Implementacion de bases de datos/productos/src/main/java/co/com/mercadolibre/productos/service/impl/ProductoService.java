package co.com.mercadolibre.productos.service.impl;

import co.com.mercadolibre.productos.dto.ProductoDTO;
import co.com.mercadolibre.productos.entity.Producto;
import co.com.mercadolibre.productos.repository.IProductoRepository;
import co.com.mercadolibre.productos.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductoDTO create(ProductoDTO productoDTO) {
        Producto saved = productoRepository.save(modelMapper.map(productoDTO, Producto.class));
        return modelMapper.map(saved, ProductoDTO.class);
    }

    @Override
    public ProductoDTO update(ProductoDTO productoDTO, String id) {
        if (productoRepository.existsById(id)) {
            productoDTO.setId(id);
            Producto updated = productoRepository.save(modelMapper.map(productoDTO, Producto.class));
            return modelMapper.map(updated, ProductoDTO.class);
        }
        return null;
    }

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .toList();
    }
}
