package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.domain.Product;
import org.responseentity.elasticspring.dto.request.ProductRequestDto;
import org.responseentity.elasticspring.dto.response.ProductResponseDto;
import org.responseentity.elasticspring.repository.IProdcutRepository;
import org.responseentity.elasticspring.utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProdcutRepository iProdcutRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product = iProdcutRepository.save(ProductMapper.mapToProduct(productRequestDto));

        return ProductMapper.mapToResponse(product);
    }

    @Override
    public ProductResponseDto editProduct(String id, ProductRequestDto productRequestDto) {
        Product product = iProdcutRepository.findById(id).orElseThrow();

        product.setNombre(productRequestDto.getNombre());
        product.setTipo(productRequestDto.getTipo());
        product.setPrecioVenta(productRequestDto.getPrecioVenta());
        product.setPrecioCosto(productRequestDto.getPrecioCosto());
        product.setCantidad(productRequestDto.getCantidad());

        iProdcutRepository.save(product);

        return ProductMapper.mapToResponse(product);
    }
}
