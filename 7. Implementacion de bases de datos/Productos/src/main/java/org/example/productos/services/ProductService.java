package org.example.productos.services;

import org.example.productos.exceptions.NotFoundException;
import org.example.productos.model.DTO.ProductRequestDTO;
import org.example.productos.model.DTO.ProductResponseDTO;
import org.example.productos.model.Product;
import org.example.productos.repository.IProductRespository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final String NOT_FOUND_MESSAGE="No product with the provided id was found";

    private final ModelMapper mapper;

    private final IProductRespository productRespository;

    public ProductService(IProductRespository productRespository) {
        this.productRespository = productRespository;
        this.mapper=new ModelMapper();
    }


    @Override
    public List<ProductResponseDTO> findAll() {
        return productRespository.findAll()
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO findById(String id) {
        return convertModelToDTO( this.findByID(id));
    }

    @Override
    public ProductResponseDTO createNew(ProductRequestDTO product) {
        Product newProduct = convertDTOtoModel(product);
        newProduct = productRespository.save(newProduct);
        return convertModelToDTO(newProduct);
    }

    @Override
    public ProductResponseDTO updateProductById(String id, ProductRequestDTO product) {
        this.findByID(id);
        Product productToUpdate = convertDTOtoModel(product);
        productToUpdate.setId(id);
        productRespository.save(productToUpdate);
        return convertModelToDTO(productToUpdate);
    }

    @Override
    public String deleteProduct(String id) {
        this.findByID(id);
        productRespository.deleteById(id);
        return "Product was deleted successfully";
    }

    @Override
    public List<ProductResponseDTO> findProductByType(String type) {
        return productRespository.findAllByTypeContainingIgnoreCase(type, Pageable.unpaged()).stream().map(this::convertModelToDTO).toList();
    }

    private Product findByID(String id){
        return productRespository.findById(id).orElseThrow(()->
                new NotFoundException(NOT_FOUND_MESSAGE));
    }

    private Product convertDTOtoModel(ProductRequestDTO product){
        return  mapper.map(product, Product.class);
    }
    private ProductResponseDTO convertModelToDTO(Product product){
        return mapper.map(product,ProductResponseDTO.class);
    }
}
