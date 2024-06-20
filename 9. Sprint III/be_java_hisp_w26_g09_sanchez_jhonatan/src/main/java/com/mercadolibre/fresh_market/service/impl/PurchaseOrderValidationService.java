package com.mercadolibre.fresh_market.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mercadolibre.fresh_market.service.IPurchaseOrderValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.fresh_market.dtos.product.ProductDTO;
import com.mercadolibre.fresh_market.exceptions.EntitiesNotFoundException;
import com.mercadolibre.fresh_market.exceptions.InconsistentStockException;
import com.mercadolibre.fresh_market.model.Batch;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IProductRepository;

@Service
public class PurchaseOrderValidationService implements IPurchaseOrderValidationService {


    @Autowired
    private IBatchRepository batchRepository;
    
    @Autowired
    private IProductRepository productRepository;
    
    @Override
    public List<Product> validateExistenceProducts(List<ProductDTO> listProductsToValidate) {
        List<ProductDTO> productsToValidate = listProductsToValidate; 
        List<Map<String, Long>> nonExistingProducts = new ArrayList<>();
        
        List<Product> products = new ArrayList<>(); 
        for (ProductDTO productDTO : productsToValidate) {
            Optional<Product> optionalProduct = this.productRepository.findById(productDTO.getProductId());

            if (optionalProduct.isEmpty()) {
                nonExistingProducts.add(Map.of("id", productDTO.getProductId()));
            }

            if (nonExistingProducts.isEmpty()) {
                products.add(optionalProduct.get());
            }
        }
        
        if (!nonExistingProducts.isEmpty()) {
            throw new EntitiesNotFoundException("The products with the next list of IDs not exists!", nonExistingProducts);
        }

        return products;
    }

    public Double validateStock(List<Product> products, List<ProductDTO> productsToValidate) {
       
       List<Object> nonStockProducts = new ArrayList<>();

        Double totalPrice = Double.valueOf(0);
        
        for (int i = 0; i < productsToValidate.size(); i++) {
            Product product = products.get(i);
            ProductDTO productToValidate = productsToValidate.get(i);

            List<Batch> batchs = batchRepository.findByProduct(product);
            if (batchs.isEmpty()) {
                //nonExistingProducts
                nonStockProducts.add(Map.of("id",  product.getId(), "description", "There are not batch of this product"));
            } else {

                Integer actualStock = Integer.valueOf(0);
                for (Batch batch : batchs) {
                    LocalDate today = LocalDate.now();
                    LocalDate threeWeeksAgo = today.minusWeeks(3);
                    LocalDate dueDate = batch.getDueDate();
                    
                    if (dueDate.isAfter(threeWeeksAgo)) {
                        actualStock = actualStock + batch.getCurrentQuantity();
                    }

                }

                if (productToValidate.getQuantity() < actualStock) {                    
                    totalPrice = totalPrice + (product.getPrice()*productToValidate.getQuantity());
                } else {
                    nonStockProducts.add(Map.of("id",  product.getId(), 
                                                   "description", "There are not stock enought of this product",
                                                   "actual", actualStock,
                                                   "required", productToValidate.getQuantity()));
                }
            }
        
        }

        if (!nonStockProducts.isEmpty()) {
            throw new InconsistentStockException("There are not enought stock for the next products: ", nonStockProducts);
        }
       
        return totalPrice; 
    }
}
