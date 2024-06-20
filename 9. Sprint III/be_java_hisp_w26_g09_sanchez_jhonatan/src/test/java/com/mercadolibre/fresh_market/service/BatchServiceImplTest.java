package com.mercadolibre.fresh_market.service;


import com.mercadolibre.fresh_market.config.exception.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.dtos.BatchLocationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ExpiringProductResponseDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseDTO;

import com.mercadolibre.fresh_market.exceptions.UnauthorizedAccessException;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import com.mercadolibre.fresh_market.service.impl.BatchServiceImpl;
import com.mercadolibre.fresh_market.service.impl.WarehouseServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BatchServiceImplTest {

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private WarehouseServiceImpl warehouseService;

    @Mock
    private AuthService authService;

    @InjectMocks
    private BatchServiceImpl batchService;

    // Variables comunes
    private LocalDate startDate;
    private Product product;
    private Section section;
    private Batch batch1;
    private Batch batch2;
    private User warehouseman;
    private Warehouse warehouse;

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.openMocks(this);

        // Inicializar variables comunes
        startDate = LocalDate.now();

        product = new Product();
        product.setId(1L);

        section = new Section();
        section.setId(1L);
        section.setCategory(Category.FF);

        batch1 = new Batch();
        batch1.setId(1L);
        batch1.setProduct(product);
        batch1.setSection(section);
        batch1.setDueDate(startDate.plusWeeks(4));

        batch2 = new Batch();
        batch2.setId(2L);
        batch2.setProduct(product);
        batch2.setSection(section);
        batch2.setDueDate(startDate);

        warehouseman = new User();
        warehouseman.setFirstName("Warehouseman");
        warehouseman.setEmail("warehouseman@test.com");
        warehouseman.setPassword("password");
        warehouseman.setRole(Role.WAREHOUSEMAN);

        warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setAddress("Street 123");
        warehouse.setWarehouseman(warehouseman);
        warehouse.setCountry("Argentina");

        section.setWarehouse(warehouse);
    }

    @Test
    @DisplayName("Get batches expiring soon")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchesExpiringSoon() {

        // Arrange
        Integer countDays = 10;
        LocalDate endDate = startDate.plusDays(countDays);
        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(warehouse.getId()));
        when(batchRepository.findBatchesExpiringSoon(1L, startDate, endDate)).thenReturn(batches);

        // Act
        ExpiringProductResponseDTO result = batchService.getBatchesExpiringSoon(countDays);

        // Assert
        assertEquals(batches.size(), result.getBatchStock().size());
    }

    @Test
    @DisplayName("Get batches by product id")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductId() {

        // Arrange
        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(warehouse.getId()));
        when(batchRepository.findByProductId(1L)).thenReturn(batches);

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductId(1L);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getBatchStock());
        assertEquals(1, result.getBatchStock().size());
        assertEquals(batch2.getBatchNumber(), result.getBatchStock().get(0).getBatchNumber());
    }

    @Test
    @DisplayName("Get batches by product id when no batches are available")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductIdWhenNoBatchesAvailable() {

        // Arrange
        List<Batch> emptyBatchList = Collections.emptyList();

        when(batchRepository.findByProductId(1L)).thenReturn(emptyBatchList);

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> {
            batchService.getBatchByProductId(1L);
        });
    }

    @Test
    @DisplayName("Get batch by product id when warehouse manager is not authorized")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductIdWhenWarehouseManagerNotAuthorized() {

        // Arrange
        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenThrow(new UnauthorizedAccessException("No associated warehouses found"));
        when(batchRepository.findByProductId(1L)).thenReturn(batches);

        // Act & Assert
        assertThrows(UnauthorizedAccessException.class, () -> {
            batchService.getBatchByProductId(1L);
        });
    }

    @Test
    @DisplayName("Get batch by product id when warehouse id does not match")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductIdWhenWarehouseIdDoesNotMatch() {

        // Arrange
        List<Batch> batches = Arrays.asList(batch1, batch2);
        section.setWarehouse(new Warehouse(2L, "Street 456", "Argentina", null));
        batch1.setSection(section);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(warehouse.getId()));
        when(batchRepository.findByProductId(1L)).thenReturn(batches);

        // Act & Assert
        Exception exception = assertThrows(UnauthorizedAccessException.class, () -> {
            batchService.getBatchByProductId(1L);
        });

        String expectedMessage = "You don't have permissions to access this warehouse";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Get batch by product id when batch due date is null")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductIdWhenBatchDueDateIsNull() {

        // Arrange
        batch1.setDueDate(null);
        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(warehouse.getId()));
        when(batchRepository.findByProductId(1L)).thenReturn(batches);

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductId(1L);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getBatchStock());
        assertEquals(1, result.getBatchStock().size());
        assertEquals(batch1.getBatchNumber(), result.getBatchStock().get(0).getBatchNumber());
    }

    @Test
    @DisplayName("Get batch by product id when valid batches list is empty")
    @WithMockUser(roles = "WAREHOUSEMAN")
    public void testGetBatchByProductIdWhenValidBatchesListIsEmpty() {

        // Arrange
        batch1.setDueDate(LocalDate.now().plusWeeks(2));
        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(warehouse.getId()));
        when(batchRepository.findByProductId(1L)).thenReturn(batches);

        // Act & Assert
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            batchService.getBatchByProductId(1L);
        });

        String expectedMessage = "Product is not available";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Get batch by product id ordered by batch number")
    public void testGetBatchByProductIdOrderedByBatchNumber() {
        // Arrange
        Batch batch1 = new Batch();
        batch1.setBatchNumber(2);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setBatchNumber(1);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByProductId(1L)).thenReturn(batches);
        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(1L));

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductIdOrdered(1L, "L");

        // Assert
        assertEquals(1, result.getBatchStock().get(0).getBatchNumber());
        assertEquals(2, result.getBatchStock().get(1).getBatchNumber());
    }

    @Test
    @DisplayName("Get batch by product id ordered by current quantity")
    public void testGetBatchByProductIdOrderedByCurrentQuantity() {
        // Arrange
        Batch batch1 = new Batch();
        batch1.setCurrentQuantity(200);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setCurrentQuantity(100);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByProductId(1L)).thenReturn(batches);
        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(1L));

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductIdOrdered(1L, "C");

        // Assert
        assertEquals(100, result.getBatchStock().get(0).getCurrentQuantity());
        assertEquals(200, result.getBatchStock().get(1).getCurrentQuantity());
    }

    @Test
    @DisplayName("Get batch by product id ordered by due date")
    public void testGetBatchByProductIdOrderedByDueDate() {
        // Arrange
        Batch batch1 = new Batch();
        batch1.setDueDate(LocalDate.of(2024, 7, 16)); // Set the due date to 2024-07-16
        batch1.setSection(section); // Set the section for batch1

        Batch batch2 = new Batch();
        batch2.setDueDate(LocalDate.of(2024, 7, 9)); // Set the due date to 2024-07-09
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByProductId(1L)).thenReturn(batches); // Add this line
        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(1L));

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductIdOrdered(1L, "F");

        // Assert
        assertEquals(batch1.getDueDate(), result.getBatchStock().get(0).getDueDate());
    }

    @Test
    @DisplayName("Get batch by product id with invalid order parameter")
    public void testGetBatchByProductIdWithInvalidOrder() {
        // Arrange
        Batch batch1 = new Batch();
        batch1.setBatchNumber(2);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setBatchNumber(1);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByProductId(1L)).thenReturn(batches);
        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(1L));

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            batchService.getBatchByProductIdOrdered(1L, "INVALID");
        });

        String expectedMessage = "Invalid order parameter";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Get batch by product id ordered by batch number")
    public void testGetBatchByProductIdOrdered() {
        // Arrange
        Batch batch1 = new Batch();
        batch1.setBatchNumber(2);
        batch1.setSection(section);

        Batch batch2 = new Batch();
        batch2.setBatchNumber(1);
        batch2.setSection(section);

        List<Batch> batches = Arrays.asList(batch1, batch2);

        when(batchRepository.findByProductId(1L)).thenReturn(batches);
        when(warehouseService.getWarehouseByWarehousemanId(0L)).thenReturn(new WarehouseDTO(1L));

        // Act
        BatchLocationResponseDTO result = batchService.getBatchByProductIdOrdered(1L, "L");

        // Assert
        assertEquals(1, result.getBatchStock().get(0).getBatchNumber());
        assertEquals(2, result.getBatchStock().get(1).getBatchNumber());
    }
}
