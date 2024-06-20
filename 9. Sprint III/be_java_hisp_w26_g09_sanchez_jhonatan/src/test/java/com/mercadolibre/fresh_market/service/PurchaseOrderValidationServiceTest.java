package com.mercadolibre.fresh_market.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.fresh_market.dtos.product.ProductDTO;
import com.mercadolibre.fresh_market.exceptions.EntitiesNotFoundException;
import com.mercadolibre.fresh_market.exceptions.InconsistentStockException;
import com.mercadolibre.fresh_market.model.Batch;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.service.impl.PurchaseOrderValidationService;
@ExtendWith(MockitoExtension.class)
public class PurchaseOrderValidationServiceTest {
    
    @Mock
    private IProductRepository productRepositoryMock;

    @Mock
    private IBatchRepository batchRepositoryMock;
    
    @InjectMocks
    private PurchaseOrderValidationService systemUnderTest;

    @Test
    @DisplayName("Test to verify validation of existente products when all products exists")
    void validateExistenceProductsWhenAllExistsReturnProducts()
    {
        //Arrange
        List<ProductDTO> input = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO(1L, 2);
        input.add(productDTO);
        Integer itemsExpexted = Integer.valueOf(1);
        
        //Act
        when(productRepositoryMock.findById(productDTO.getProductId())).thenReturn(Optional.of(new Product()));
        List<Product> result = systemUnderTest.validateExistenceProducts(input);
        
        //Assert
        assertEquals(itemsExpexted, result.size());
    }


    @Test
    @DisplayName("Test to verify validation of existente products when one product not exists")
    void validateExistenceProductsWhenOneNotExistThrowException()
    {
        //Arrange
        List<ProductDTO> input = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO(1L, 2);
        input.add(productDTO);
        
        String messageExpected = "The products with the next list of IDs not exists!";

        //Act

        when(productRepositoryMock.findById(productDTO.getProductId())).thenReturn(Optional.empty());

        EntitiesNotFoundException exceptionResult = assertThrows(EntitiesNotFoundException.class, () -> {
            systemUnderTest.validateExistenceProducts(input);
        });
        List<Map<String, Long>> detailResult = (List<Map<String, Long>>) exceptionResult.getDetail();

        //Assert
        assertEquals(messageExpected, exceptionResult.getDescription()); 
        assertEquals(1, detailResult.size());
    }

    @Test
    @DisplayName("Test to verifiy that validateStock is right when exist one inconsistence by not stock enought")
    void validateStockWhenNotBatchExistsThrowException() {

        //Arrange
        String messageExpected = "There are not enought stock for the next products: ";
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1L);
        
        products.add(product);
        List<ProductDTO> producsToValidate = new ArrayList<>();
        producsToValidate.add(ProductDTO.builder().productId(1L).quantity(10).build());
        
        List<Batch> batchs = new ArrayList<>();
        //Act 
        when(batchRepositoryMock.findByProduct(product)).thenReturn(batchs);
        InconsistentStockException exceptionResult = assertThrows(InconsistentStockException.class, ()-> {
            this.systemUnderTest.validateStock(products, producsToValidate);
        });

        assertEquals(messageExpected, exceptionResult.getDescription());
    }

    @Test
    @DisplayName("Test to verifiy that validateStock is right when exist one inconsistence by not stock enought")
    void validateStockWhenNotEnoughtThrowException() {

        //Arrange
        String messageExpected = "There are not enought stock for the next products: ";
        
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1L);
        product.setPrice(100D);
        products.add(product);

        List<ProductDTO> producsToValidate = new ArrayList<>();
        producsToValidate.add(ProductDTO.builder().productId(1L).quantity(99).build());
        
        List<Batch> batchs = new ArrayList<>();
        Batch batch = new Batch();
        batch.setCurrentQuantity(1000);
        batch.setDueDate(LocalDate.now().minusWeeks(4));
        batchs.add(batch);
        
        //Act 
        when(batchRepositoryMock.findByProduct(product)).thenReturn(batchs);
        InconsistentStockException exceptionResult = assertThrows(InconsistentStockException.class, ()-> {
            this.systemUnderTest.validateStock(products, producsToValidate);
        });

        assertEquals(messageExpected, exceptionResult.getDescription());
    }


    @Test
    @DisplayName("Test to verifiy that validateStock is right when exist one inconsistence by not stock enought")
    void validateStockWhenIsValidReturnDouble() {

        //Arrange
        Double totalPriceExpected = Double.valueOf(9900);
        
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1L);
        product.setPrice(100D);
        products.add(product);

        List<ProductDTO> producsToValidate = new ArrayList<>();
        producsToValidate.add(ProductDTO.builder().productId(1L).quantity(99).build());
        
        List<Batch> batchs = new ArrayList<>();
        Batch batch = new Batch();
        batch.setCurrentQuantity(1000);
        batch.setDueDate(LocalDate.now().minusWeeks(1));
        batchs.add(batch);
        
        //Act 
        when(batchRepositoryMock.findByProduct(product)).thenReturn(batchs);
        Double totalPriceResult = this.systemUnderTest.validateStock(products, producsToValidate);

        assertEquals(totalPriceExpected, totalPriceResult);
    }

}
