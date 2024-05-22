package org.ggomezr.productselasticsearch.application.service.impl;

import org.ggomezr.productselasticsearch.application.service.interfaces.IProductService;
import org.ggomezr.productselasticsearch.domain.dto.ProductDTO;
import org.ggomezr.productselasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.productselasticsearch.domain.exception.NotFoundException;
import org.ggomezr.productselasticsearch.domain.model.Product;
import org.ggomezr.productselasticsearch.domain.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(IProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToProductDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> createProducts(List<ProductDTO> productDTOList) {
        List<Product> products = productDTOList.stream()
                .map(this::convertToProduct).toList();
        List<Product> savedProducts = (List<Product>) productRepository.saveAll(products);
        return savedProducts.stream()
                .map(this::convertToProductDTO).toList();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        Stream<Product> productStream = StreamSupport.stream(products.spliterator(), false);
        return productStream
                .map(this::convertToProductDTO).toList();
    }

    @Override
    public ProductDTO getProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) throw new NotFoundException("Product not found");

        return convertToProductDTO(productOptional.get());
    }

    @Override
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) throw new NotFoundException("Product not found");

        Product product = convertToProduct(productDTO);
        product.setId(id);

        Product updatedProduct = productRepository.save(product);
        return convertToProductDTO(updatedProduct);
    }

    @Override
    public ResponseDTO deleteProduct(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) throw new NotFoundException("Product not found");

        productRepository.deleteById(id);
        return new ResponseDTO("Product deleted successfully");
    }

    private ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
