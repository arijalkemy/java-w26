package com.mercadolibre.sprint_3_team_12.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductAddDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductInjectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.MessageDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
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
     * Method used to create registers in the database
     * @param productInjectionDTO
     * @return
     */
    @Override
    public MessageDTO postProducts(ProductInjectionDTO productInjectionDTO) {
        productInjectionDTO.getProductAddDTOS().stream()
                .forEach(productAddDTO -> postProduct(productAddDTO));
        return new MessageDTO("Products added to the database");
    }

    /**
     * Auxiliar method used to add a product to the database
     * @param productAddDTO
     */
    private void postProduct(ProductAddDTO productAddDTO){
        Optional<Product> product = productRepository.findByName(productAddDTO.getName());
        if(product.isPresent())
            throw new ApiException("Product found","Product already on database", 409);
        if(productAddDTO.getType().equals(Category.FF) &&
                productAddDTO.getType().equals(Category.FS) &&
                productAddDTO.getType().equals(Category.RF))
            throw new ApiException("Not valid category","Not valid category", 406);
        Product productAux = Product.builder()
                .productDesc(productAddDTO.getProductDesc())
                .price(productAddDTO.getPrice())
                .type(productAddDTO.getType())
                .name(productAddDTO.getName())
                .build();
        productRepository.save(productAux);
    }

    /**
     * Update a product using the name to identify it
     * @param productAddDTO
     * @return
     */
    @Override
    public MessageDTO updateProduct(ProductAddDTO productAddDTO) {
        Optional<Product> product = productRepository.findByName(productAddDTO.getName());
        if(!product.isPresent())
            throw new ApiException("Product not found","Product not found with the given name",404);
        Product product1 = product.get();
        if(productAddDTO.getType().equals(Category.FF) &&
                productAddDTO.getType().equals(Category.FS) &&
                productAddDTO.getType().equals(Category.RF))
            throw new ApiException("Not valid category","Not valid category", 406);
        Product productAux = Product.builder()
                .id(product1.getId())
                .productDesc(productAddDTO.getProductDesc())
                .price(productAddDTO.getPrice())
                .type(productAddDTO.getType())
                .name(productAddDTO.getName())
                .build();
        productRepository.save(productAux);
        return new MessageDTO("Product updated on the database");
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
