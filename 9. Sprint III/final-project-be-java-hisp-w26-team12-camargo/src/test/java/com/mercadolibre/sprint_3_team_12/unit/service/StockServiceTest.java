package com.mercadolibre.sprint_3_team_12.unit.service;

import com.mercadolibre.sprint_3_team_12.dto.response.NotificationDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
import com.mercadolibre.sprint_3_team_12.service.StockService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private StockService stockService;

    @Test
    @DisplayName("Set minimum stock level for a product - happy path")
    void testSetMinimumStockLevel_HappyPath() {
        // Arrange
        Long productId = 1L;
        Integer minStockLevel = 10;
        Product product = new Product(productId, "Product", 100.0, null, null, null, 0, 0);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        // Act
        stockService.setMinimumStockLevel(productId, minStockLevel);

        // Assert
        assertEquals(minStockLevel, product.getMinimumStock());
    }

    @Test
    @DisplayName("Set minimum stock level for a product - product not found")
    void testSetMinimumStockLevel_ProductNotFound() {
        // Arrange
        Long productId = 1L;
        Integer minStockLevel = 10;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () ->
                stockService.setMinimumStockLevel(productId, minStockLevel));

        assertEquals("The product with the given ID was not found.", exception.getMessage());
    }

    @Test
    @DisplayName("Get low stock notifications - happy path")
    void testGetLowStockNotifications_HappyPath() {
        // Arrange
        Product product1 = new Product(1L, "Product 1", 43.5, Category.FF, null, null, 5, 10);
        Product product2 = new Product(2L, "Product 2", 23.5, Category.FF, null, null, 3, 8);

        List<Product> lowStockProducts = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(lowStockProducts);

        List<NotificationDTO> expectedNotifications = Arrays.asList(
                new NotificationDTO(product1.getId(), product1.getName(), product1.getCurrentStock(), product1.getMinimumStock(), "Stock is below minimum level."),
                new NotificationDTO(product2.getId(), product2.getName(), product2.getCurrentStock(), product2.getMinimumStock(), "Stock is below minimum level.")
        );

        // Act
        List<NotificationDTO> actualNotifications = stockService.getLowStockNotifications();

        // Assert
        assertEquals(expectedNotifications, actualNotifications);
    }
}
