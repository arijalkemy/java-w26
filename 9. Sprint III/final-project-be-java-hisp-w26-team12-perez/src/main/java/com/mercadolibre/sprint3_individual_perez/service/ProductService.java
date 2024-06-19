package com.mercadolibre.sprint3_individual_perez.service;

import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.ProductRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ProductResponseDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.enums.Category;
import com.mercadolibre.sprint3_individual_perez.exceptions.ApiException;
import com.mercadolibre.sprint3_individual_perez.projections.ProductProjection;
import com.mercadolibre.sprint3_individual_perez.repository.IProductRepository;
import com.mercadolibre.sprint3_individual_perez.entity.Product;
import com.mercadolibre.sprint3_individual_perez.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;

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
     * Method to create a new product.
     * @param product
     * @return ProductResponseDTO with the new product
     */
    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO product) {
        User user = getUserFromAuthentication();
        Optional<Product> productEntity = productRepository.findProductByName(product.getName());
        if (productEntity.isPresent()) {
            throw new ApiException("Bad Request",
                    "Product already exists with that name",
                    HttpStatus.BAD_REQUEST.value());
        }
        Product newProduct = productRepository.save(Product.builder()
                .seller(user)
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType())
                .build());
        return ProductResponseDTO.builder()
                .idProduct(newProduct.getId().intValue())
                .name(newProduct.getName())
                .price(newProduct.getPrice())
                .type(newProduct.getType())
                .build();
    }

    @Override
    public List<ProductResponseDTO> getProducts() {
        User user = getUserFromAuthentication();
        List<Product> products = productRepository.getProductsBySeller(user);
        return products.stream()
                .map(product -> ProductResponseDTO.builder()
                        .idProduct(product.getId().intValue())
                        .name(product.getName())
                        .price(product.getPrice())
                        .type(product.getType())
                        .build())
                .toList();
    }

    /**
     * Method to get user from authentication.
     *
     * @return the user
     */
    private User getUserFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userRepository.findByUsername(currentPrincipalName)
                .orElseThrow(null);
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
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
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
}
