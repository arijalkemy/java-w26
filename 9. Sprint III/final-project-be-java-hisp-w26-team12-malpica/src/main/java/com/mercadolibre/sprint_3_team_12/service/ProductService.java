package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductNameDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    /**
     * Method to select the method to get the products. REQ 02
     * @param category
     * @return ResponseProductDTO with a list of ProductDTO
     */
    @Override
    public ResponseProductDTO selectMethod(String category) {
        if(category==null) {
            //return all products
            return getAllProducts();
        }
        //return products by category
        return getProductsByCategory(category);
    }

    /**
     * Method to get a list all products. REQ 02
     * it use the method findAllProducts from productRepository
     * @return ResponseProductDTO with a list of ProductDTO
     */
    public ResponseProductDTO getAllProducts() {
        //Get all products
        List<ProductDTO> productsDTO = productRepository.findAllProducts().stream()
                .map(this::productProjectionToProductDTO).toList();
        //Check if products were found
        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }
        //Return products building ResponseProductDTO
        return ResponseProductDTO.builder().productDTOList(productsDTO).build();
    }
    /**
     * Method to get a list of product by Category (FF, FS, RF). REQ 02
     * it use the method findProductsByCategory from productRepository
     * @param category
     * @return ResponseProductDTO with a list of ProductDTO
     */
    public ResponseProductDTO getProductsByCategory(String category) {
        //Check if category is valid
        if (Arrays.stream(Category.values()).noneMatch(c -> c.name().equals(category))) {
            throw new ApiException("Not Acceptable", "The Category is not recognized", HttpStatus.NOT_ACCEPTABLE.value());
        }
        //Convert category to enum
        Category categoryEnum = Category.valueOf(category.toUpperCase());
        //Get products by category
        List<ProductDTO> productsDTO = productRepository.findProductsByCategory(categoryEnum).stream()
                .map(this::productProjectionToProductDTO).toList();
        //Check if products were found
        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }
        //Return products building ResponseProductDTO
        return ResponseProductDTO.builder().productDTOList(productsDTO).build();
    }

    /**
     * Method to convert a ProductProjection to a ProductDTO
     * @param productProjection
     * @return ProductDTO
     */
    public ProductDTO productProjectionToProductDTO(ProductProjection productProjection) {
        if(productProjection.getQuantity()==null ){
            return new ProductDTO(
                    productProjection.getIdProduct().intValue(),
                    0
            );
        }
        return new ProductDTO(
                productProjection.getIdProduct().intValue(),
          productProjection.getQuantity()
        );
    }

    /**
     * Method to post a product. REQ 06
     * @param newProduct - ProductDTO with the product to post
     * @return ProductDTO - ProductDTO with the product posted
     */
    @Override
    public Object postProduct(ProductNameDTO newProduct) {
        //Check if product exists by name
        Optional<Product> product = productRepository.findProductByName(newProduct.getProductName());
        if(product.isPresent()){
            throw new ApiException("Conflict", "Product already exists", HttpStatus.CONFLICT.value());
        }
        // Example of creating a singleton ModelMapper instance
        ModelMapper modelMapper = new ModelMapper();
        // Make a Product object with the newProduct data using modelmapper
        Product toSave = modelMapper.map(newProduct, Product.class);
        //Post product
        productRepository.save(toSave);
        // Return productDTO
        return newProduct;
    }

    /**
     * Method to put a product. REQ 06
     * @param product - ProductDTO with the product to put
     * @return ProductDTO - ProductDTO with the product put
     */
    @Override
    public Object putProduct(ProductNameDTO product) {
        //Check if product exists by id
        Optional<Product> productOptional = productRepository.findProductByName(product.getProductName());
        if (productOptional.isEmpty()) {
            throw new ApiException("Not Found", "Product not found", HttpStatus.NOT_FOUND.value());
        }
        // Modify the product with the new data
        Product toSave = productOptional.get();
        toSave.setName(product.getProductName());
        toSave.setPrice(product.getPrice());
        //Put product
        productRepository.save(toSave);
        // Return productDTO
        return product;
    }

    /**
     * Method to get all products with name. REQ 06
     * @return List<ProductNameDTO> - List of ProductNameDTO with the products
     */
    @Override
    public List<ProductNameDTO> getAllProductsWithName() {
        //Get all products.
        List<Product> products = productRepository.findAll();
        // Map all products to ProductNameDTO
        List<ProductNameDTO> productsDTO = products.stream()
                .map(product -> ProductNameDTO.builder()
                        .productName(product.getName())
                        .price(product.getPrice())
                        .build())
                .toList();
        //Check if products were found
        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }
        //Return products
        return productsDTO;
    }

}
