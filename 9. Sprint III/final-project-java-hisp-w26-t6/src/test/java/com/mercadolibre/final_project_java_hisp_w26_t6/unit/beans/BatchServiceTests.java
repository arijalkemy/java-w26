package com.mercadolibre.final_project_java_hisp_w26_t6.unit.beans;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchStockListResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.BadRequestException;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IBatchesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.services.batch.BatchServiceImpl;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.DateSortType;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTests {

    @Mock
    IBatchesRepository batchesRepository;

    @InjectMocks
    BatchServiceImpl batchService;
    
    Product productFrozen;
    Product productFresh;
    Product productRefrigerated;
    Batch batchFrozen;
    Batch batchFresh;
    Batch batchRefrigerated;

    @BeforeEach
    void setup(){

        productFrozen = Product.builder().id(1L).name("Icecream").storageType(StorageType.FF).unitPrice(1000.00)
                .build();

        productFresh = Product.builder().id(2L).name("Fish").storageType(StorageType.FS).unitPrice(2000.00)
                .build();

        productRefrigerated = Product.builder().id(3L).name("Meat").storageType(StorageType.RF).unitPrice(3000.00)
                .build();

        batchFrozen = Batch.builder().batchNumber(1025).product(productFrozen).quantity(40).id(1L)
                .dueDate(LocalDateTime.now().plusDays(5))
                .build();

        batchFresh = Batch.builder().batchNumber(124).product(productFresh).quantity(400).id(2L)
                .dueDate(LocalDateTime.now().plusDays(2))
                .build();

        batchRefrigerated = Batch.builder().batchNumber(300).product(productRefrigerated).quantity(400).id(3L)
                .dueDate(LocalDateTime.now().plusDays(3))
                .build();
    }

    @Test
    @DisplayName("Get all batches with due date in X days NO CATEGORY NO ORDER - Good case")
    public void getBatchesDueDateNoCategoryNoOrderOK(){
        //Arrange
        int dueDateDays = 4;

        // Act
        Mockito.when(batchesRepository
                        .findAllByDueDateBetweenOrderByDueDate(LocalDate.now().atStartOfDay(),
                                LocalDate.now().atStartOfDay().plusDays(dueDateDays)))
                .thenReturn(List.of(batchFresh, batchRefrigerated));

        BatchStockListResponseDto response = batchService
                .getBatchesInDueDate(dueDateDays, null, null);


        // Assert
        Assertions.assertEquals(2, response.getBatchStock().size());
    }

    @Test
    @DisplayName("Get all batches with due date in X days FILTER CATEGORY RF - Good case")
    public void getBatchesDueDateFilterCategoryRFNoOrderOK(){
        Assertions.assertEquals(StorageType.RF,
                getBatchesDueDateFilterCategoryAndOrder(StorageType.RF.name(), null)
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days FILTER CATEGORY FF - Good case")
    public void getBatchesDueDateFilterCategoryFFNoOrderOK(){
        Assertions.assertEquals(StorageType.FF,
                getBatchesDueDateFilterCategoryAndOrder(StorageType.FF.name(), null)
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days FILTER CATEGORY FS - Good case")
    public void getBatchesDueDateFilterCategoryFSNoOrderOK(){
        Assertions.assertEquals(StorageType.FS,
                getBatchesDueDateFilterCategoryAndOrder(StorageType.FS.name(), null)
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days FILTER WRONG CATEGORY NO ORDER - Bad case")
    public void getBatchesDueDateFilterWRONGCategoryNoOrder(){
        // Act & Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> getBatchesDueDateFilterCategoryAndOrder("asdasd", null));
    }

    @Test
    @DisplayName("Get all batches with due date in X days NO CATEGORY ORDER ASC - Good case")
    public void getBatchesDueDateNOCategoryOrderAscOK(){
        // Act & Assert
        Assertions.assertEquals(StorageType.FS,
                getBatchesDueDateFilterCategoryAndOrder(null, DateSortType.date_asc.name())
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days NO CATEGORY ORDER DESC - Good case")
    public void getBatchesDueDateNOCategoryOrderDescOK(){
        // Act & Assert
        Assertions.assertEquals(StorageType.FF,
                getBatchesDueDateFilterCategoryAndOrder(null, DateSortType.date_desc.name())
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days NO CATEGORY Null ORDER Equal Asc - Good case")
    public void getBatchesDueDateNOCategoryOrderNullEqualAscOK(){
        // Act & Assert
        Assertions.assertEquals(StorageType.FS,
                getBatchesDueDateFilterCategoryAndOrder(null, DateSortType.date_asc.name())
                        .getBatchStock().get(0).getProductType());
    }

    @Test
    @DisplayName("Get all batches with due date in X days NO CATEGORY WRONG ORDER - Bad case")
    public void getBatchesDueDateNOCategoryWRONGOrder(){
        // Act & Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> getBatchesDueDateFilterCategoryAndOrder(null, "asdasd"));
    }

    private BatchStockListResponseDto getBatchesDueDateFilterCategoryAndOrder(String category, String order){
        //Arrange
        int dueDateDays = 6;

        // Act
        Mockito.when(batchesRepository
                        .findAllByDueDateBetweenOrderByDueDate(LocalDate.now().atStartOfDay(),
                                LocalDate.now().atStartOfDay().plusDays(dueDateDays)))
                .thenReturn(List.of(batchFresh, batchFrozen, batchRefrigerated));

        return batchService
                .getBatchesInDueDate(dueDateDays, category, order);
    }
}
