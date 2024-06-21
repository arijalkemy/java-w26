package com.mercadolibre.project_be_java_hisp_w26_team5.service;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchInfoDueDateDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchStockDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.impl.BatchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class BatchServiceImplTest {

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private BatchServiceImpl batchService;

    private Product product;
    private UserEntity user;
    private Warehouse warehouse;
    private Sector sector;
    private Batch batch;
    private List<Batch> listBatch;

    @BeforeEach
    public void setUp() {

        product = Product
                .builder()
                .id(1)
                .name("Product Name")
                .description("Product Description")
                .type(TypeProduct.FF)
                .seller(mock(UserEntity.class))
                .build();

        user = UserEntity
                .builder()
                .id(1)
                .build();

        warehouse = Warehouse
                .builder()
                .id(1)
                .manager(user)
                .build();

        sector = Sector
                .builder()
                .id(1)
                .warehouse(warehouse)
                .build();


        batch = Batch
                .builder()
                .id(1)
                .product(product)
                .sector(sector)
                .batchNumber("1")
                .currentQuantity(10)
                .dueDate(LocalDate
                        .now()
                        .plusWeeks(2))
                .build();

        listBatch = List.of(batch);
    }

    @DisplayName("El tamaño del stock de lotes coincide cuando existen lotes para el tipo de producto dado dentro del rango de fechas")
    @Test
    public void testGetBatchStockByProductId() {
        // Arrange
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "FF";
        String order = "date_desc";

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDateDesc(
                any(Integer.class),
                any(LocalDate.class),
                any(LocalDate.class),
                any(TypeProduct.class))).thenReturn(listBatch);

        // Act
        BatchStockDTO result = batchService.getBatchStockByProductId(cantDays,
                managerId,
                category,
                order);

        // Assert
        //Verifica que el tamaño de la lista de lotes devuelta por el método coincide con el tamaño de la lista simulada.
        assertEquals(listBatch.size(),
                result
                        .getBatchStock()
                        .size());
    }

    @DisplayName("getBatchStockByProductId debe devolver correctamente los BatchStockDTO cuando los lotes existen")
    @Test
    public void shouldReturnCorrectlyBuiltBatchStockDTOWhenBatchesExist() {
        // Arrange
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "FF";
        String order = "date_desc";
        List<Batch> batches = List.of(batch);
        BatchStockDTO expectedBatchStockDTO = BatchStockDTO
                .builder()
                .batchStock(batchService.batchesToBatchInfoDueDateDto(batches))
                .build();

        when(batchService.getBatches(category,
                order,
                managerId,
                LocalDate
                        .now()
                        .plusDays(cantDays),
                LocalDate.now())).thenReturn(batches);

        // Act
        BatchStockDTO result = batchService.getBatchStockByProductId(cantDays,
                managerId,
                category,
                order);

        // Assert
        assertEquals(expectedBatchStockDTO, result);
    }

    @DisplayName("getBatchStockByProductId debe lanzar una excepcion NotFoundException cuando no existan los lotes")
    @Test
    public void shouldThrowNotFoundExceptionWhenNoBatchesExist() {
        // Arrange
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "FF";
        String order = "date_desc";

        when(batchService.getBatches(category,
                order,
                managerId,
                LocalDate
                        .now()
                        .plusDays(cantDays),
                LocalDate.now())).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class,
                () -> batchService.getBatchStockByProductId(cantDays, managerId, category, order));
    }


    @DisplayName("El stock de lotes se devuelve cuando existen lotes dentro del rango de fechas dado.")
    @Test
    public void shouldReturnBatchStockWhenBatchesExistWithinGivenDateRange() {
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "FF";
        String order = "date_desc";

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDateDesc(
                any(Integer.class),
                any(LocalDate.class),
                any(LocalDate.class),
                any(TypeProduct.class))).thenReturn(listBatch);

        BatchStockDTO result = batchService.getBatchStockByProductId(cantDays,
                managerId,
                category,
                order);

        assertEquals(listBatch.size(),
                result
                        .getBatchStock()
                        .size());
    }

    @DisplayName("Se lanza una excepción cuando no existen lotes dentro del rango de fechas dado.")
    @Test
    public void shouldThrowExceptionWhenNoBatchesExistWithinGivenDateRange() {
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "FF";
        String order = "date_desc";

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDateDesc(
                any(Integer.class),
                any(LocalDate.class),
                any(LocalDate.class),
                any(TypeProduct.class))).thenReturn(Collections.emptyList());

        assertThrows(NotFoundException.class,
                () -> batchService.getBatchStockByProductId(cantDays, managerId, category, order));
    }

    @DisplayName("El stock de lotes se devuelve cuando existen lotes y el tipo de producto es nulo")
    @Test
    public void shouldReturnBatchStockWhenBatchesExistAndProductTypeIsNull() {
        Integer cantDays = 10;
        Integer managerId = 1;
        String category = "All";
        String order = "date_desc";

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateDesc(
                managerId,
                LocalDate
                        .now()
                        .plusDays(cantDays),
                LocalDate.now())).thenReturn(listBatch);

        BatchStockDTO result = batchService.getBatchStockByProductId(cantDays,
                managerId,
                category,
                order);

        assertEquals(listBatch.size(),
                result
                        .getBatchStock()
                        .size());
    }

    @DisplayName("Debe devolver lotes ordenados por fecha descendente cuando el orden es 'date_desc'")
    @Test
    public void shouldReturnBatchesOrderedByDescendingDateWhenOrderIsDateDesc() {
        Integer managerId = 1;
        LocalDate maxExpirationDate = LocalDate
                .now()
                .plusDays(10);
        LocalDate minExpirationDate = LocalDate.now();
        String order = "date_desc";

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateDesc(
                managerId,
                maxExpirationDate,
                minExpirationDate)).thenReturn(listBatch);

        List<Batch> result = batchService.getBatchesByOrder(order,
                managerId,
                maxExpirationDate,
                minExpirationDate);

        assertEquals(listBatch, result);
    }

    @DisplayName("Debe devolver lotes ordenados  de forma ascendente cuando el orden de la fecha no sea 'date_desc'")
    @Test
    public void shouldReturnBatchesOrderedByAscendingDateWhenOrderIsNotDateDesc() {
        Integer managerId = 1;
        LocalDate maxExpirationDate = LocalDate
                .now()
                .plusDays(10);
        LocalDate minExpirationDate = LocalDate.now();
        String order = "date_asc";
        TypeProduct typeProductEnum = TypeProduct.FF;

        when(batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDate(
                managerId,
                maxExpirationDate,
                minExpirationDate,
                typeProductEnum)).thenReturn(listBatch);

        List<Batch> result = batchService.getBatchesByTypeAndOrder(typeProductEnum,
                order,
                managerId,
                maxExpirationDate,
                minExpirationDate);

        assertEquals(listBatch, result);
    }

    @DisplayName("createBatchStockDTO devuelve correctamente los BatchStockDTO")
    @Test
    public void shouldReturnCorrectlyBuiltBatchStockDTO() {
        // Arrange
        List<Batch> batches = List.of(batch);
        List<BatchInfoDueDateDTO> batchInfoDueDateDTOs = batchService.batchesToBatchInfoDueDateDto(
                batches);

        // Act
        BatchStockDTO result = batchService.createBatchStockDTO(batches);

        // Assert
        assertEquals(batchInfoDueDateDTOs.size(),
                result
                        .getBatchStock()
                        .size());
        assertEquals(batchInfoDueDateDTOs, result.getBatchStock());
    }

    @DisplayName("batchesToBatchInfoDueDateDto debe devolver correctamente convertidos los BatchInfoDueDateDTOs")
    @Test
    public void shouldReturnCorrectlyConvertedBatchInfoDueDateDTOs() {
        // Arrange
        List<Batch> batches = List.of(batch);

        // Act
        List<BatchInfoDueDateDTO> result = batchService.batchesToBatchInfoDueDateDto(batches);

        // Assert
        assertEquals(batches.size(), result.size());
        for (int i = 0; i < batches.size(); i++) {
            Batch batch = batches.get(i);
            BatchInfoDueDateDTO dto = result.get(i);
            assertEquals(Integer.parseInt(batch.getBatchNumber()), dto.getBatchNumber());
            assertEquals(batch
                    .getProduct()
                    .getId(), dto.getProductId());
            assertEquals(batch
                    .getProduct()
                    .getId(), dto.getProductTypeId());
            assertEquals(batch.getDueDate(), dto.getDueDate());
            assertEquals(batch.getCurrentQuantity(), dto.getCurrentQuantity());
        }
    }
}
