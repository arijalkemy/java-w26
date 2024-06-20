package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationListRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ProductCreationResponseDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.entity.User;
import com.mercadolibre.sprint_3_team_12.entity.UserProduct;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
import com.mercadolibre.sprint_3_team_12.repository.IUserProductRepository;
import com.mercadolibre.sprint_3_team_12.repository.IUserRepository;
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

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserProductRepository userProductRepository;



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

    /**
     * Processes a request to create multiple products for a specified seller. US-06
     *
     * @param productCreationListRequestDTO The request containing product creation details.
     * @param idSeller                      The ID of the seller for whom products are being created.
     * @return A ProductCreationResponseDTO indicating the success of the operation.
     * @throws ApiException If the seller ID is not found, if a product already exists for the seller,
     *                      or if there are any other API-related issues.
     */
    public ProductCreationResponseDTO postProduct(ProductCreationListRequestDTO productCreationListRequestDTO, Long idSeller) {
        //Verifies seller id
        User user = userRepository.findById(idSeller).orElseThrow(() ->
                new ApiException("NotFoundException", "User not found", HttpStatus.NOT_FOUND.value()));

            productCreationListRequestDTO.getProductCreationDTO().forEach(productCreationDTO -> {
            // Searching the product in user scope
            UserProduct userProduct = userProductRepository.findByProductNameAndUserId(productCreationDTO.getName(), idSeller);

            if (userProduct != null) {
                String productName = productCreationDTO.getName() + " already exist";
                throw new ApiException("Product already exists", productName, HttpStatus.CONFLICT.value());
            }

            // Product creation and storage
            Product product = Product.builder()
                    .name(productCreationDTO.getName())
                    .price(productCreationDTO.getPrice())
                    .type(productCreationDTO.getType())
                    .build();

            productRepository.save(product);

            // User - product relationship
            UserProduct userProductSaved = UserProduct.builder().product(product).user(user).build();
            userProductRepository.save(userProductSaved);
        });
        //Returns ProductCreationResponse with operation 1, message product + productName + added by user + userName and status 201 created
        return ProductCreationResponseDTO.builder()
                .operation(1)
                .message("Product created")
                .code(HttpStatus.CREATED.value())
                .build();
    }

    /**
     * Processes a request to update a product owned by a specified seller.
     *
     * @param idProduct          The ID of the product to update.
     * @param productCreationtDTO The updated details of the product.
     * @param idSeller           The ID of the seller who owns the product.
     * @return A ProductCreationResponseDTO indicating the success of the update operation.
     * @throws ApiException If the seller ID is not found, if the product does not exist in the seller's scope,
     *                      if the product with the given ID is not found, or for any other API-related issues.
     */
    public ProductCreationResponseDTO updateProduct(Long idProduct, ProductCreationDTO productCreationtDTO, Long idSeller) {
        //Verifies seller id
        User user = userRepository.findById(idSeller).orElseThrow(() ->
                new ApiException("NotFoundException", "User not found", HttpStatus.NOT_FOUND.value()));

        // Searching the product in user scope
        UserProduct userProduct = userProductRepository.findByProductNameAndUserId(productCreationtDTO.getName(), idSeller);

        if (userProduct == null) {
            String productName = idProduct + " not exist in user: " + idSeller + " scope";
            throw new ApiException("Product not found: ", productName, HttpStatus.CONFLICT.value());
        }

        Product product = productRepository.findById(idProduct).orElseThrow(()-> new ApiException("NotFoundException", "Product not found", HttpStatus.NOT_FOUND.value()));
        product.setName(productCreationtDTO.getName());
        product.setPrice(productCreationtDTO.getPrice());
        product.setType(productCreationtDTO.getType());

        return ProductCreationResponseDTO.builder()
                .operation(2)
                .message("Product updated")
                .code(HttpStatus.CREATED.value())
                .build();
    }
}
