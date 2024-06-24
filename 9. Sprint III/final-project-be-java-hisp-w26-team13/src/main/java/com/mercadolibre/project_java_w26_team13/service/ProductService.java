package com.mercadolibre.project_java_w26_team13.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.project_java_w26_team13.dtos.ProductDto;
import com.mercadolibre.project_java_w26_team13.entity.Batch;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.IBatchRepository;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import com.mercadolibre.project_java_w26_team13.util.Helper;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    private final IBatchRepository batchRepository;
    private final ObjectMapper mapper = new ObjectMapper();
    private final JWTClaims jwtClaims;

    public ProductService(IProductRepository productRepository, IBatchRepository batchRepository, JWTClaims jwtClaims) {
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.jwtClaims = jwtClaims;
    }

    @Override
    public List<ProductDto> getProductList(String authorizationHeader) {

        jwtClaims.validateHeader(authorizationHeader, Roles.BUYER.getRole());

        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
           throw ExceptionsFactory.notFoundException("Products list is empty");
        }
        return productList.stream().map(this::mapToDto).toList();
    }

    @Override
    public List<ProductDto> getProductListByCategory(String authorizationHeader, String category) {

            if (category == null){
                return getProductList(authorizationHeader);
            }

            jwtClaims.validateHeader(authorizationHeader, Roles.BUYER.getRole());

            String validatedCategory = Helper.validateCategoryFilter(category);

            List<Batch> batches = batchRepository.findAll();
            List<Product> productList = batches.stream()
                    .filter(batch -> validatedCategory.equalsIgnoreCase(batch.getOrder().getSection().getName()))
                    .map(Batch::getProduct)
                    .distinct()
                    .collect(Collectors.toList());

            if (productList.isEmpty()) {
                throw ExceptionsFactory.notFoundException("Products list is empty");
            }

            return productList.stream().map(this::mapToDto).toList();
        }



    private ProductDto mapToDto(Product product) {
        return mapper.convertValue(product, ProductDto.class);
    }
}
