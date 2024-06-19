package com.mercadolibre.sprint_3_team_12_malacara.service;

import com.mercadolibre.sprint_3_team_12_malacara.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12_malacara.entity.Product;
import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;
import com.mercadolibre.sprint_3_team_12_malacara.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12_malacara.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    /**
     * Method to get a list of products by seller and by quantity. REQ 06
     * it use the method findAllProductsBySellerAndQuantity from productRepository
     * @param userId
     * @param quantity
     * @return ResponseProductDTO with a list of ProductDTO
     */
    @Override
    public ResponseProductDTO getProductsBySellerAndByQuantity(Long userId, double quantity) {
        //Get all products
        List<ProductDTO> productsDTO = productRepository.findAllProductsBySellerAndQuantity(userId,quantity).stream()
                .map(this::productProjectionToProductDTO).toList();
        //Check if products were found
        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }
        //Return products building ResponseProductDTO
        return ResponseProductDTO.builder().productDTOList(productsDTO).build();
    }
    /**
     * Method to get a list of products by seller. REQ 06
     * it use the method findAllProductsBySeller from productRepository
     * @param userId
     * @return ResponseProductDTO with a list of ProductDTO
     */
    @Override
    public ResponseProductDTO getProductsBySeller(Long userId) {
        //Get all products
        List<ProductDTO> productsDTO = productRepository.findAllProductsBySeller(userId).stream()
                .map(this::productProjectionToProductDTO).toList();
        //Check if products were found
        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }
        //Return products building ResponseProductDTO
        return ResponseProductDTO.builder().productDTOList(productsDTO).build();
    }

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
