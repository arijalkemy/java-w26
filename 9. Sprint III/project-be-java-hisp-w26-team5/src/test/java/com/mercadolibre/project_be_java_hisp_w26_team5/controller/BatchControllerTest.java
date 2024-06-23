package com.mercadolibre.project_be_java_hisp_w26_team5.controller;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchInfoDueDateDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.BatchStockDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IBatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BatchControllerTest {

    @Mock
    private IBatchService batchService;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private BatchController batchController;

    private Product product;
    private UserEntity user;
    private Warehouse warehouse;
    private Sector sector;
    private Batch batch;
    private List<Batch> listBatch;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        product = Product.builder()
                .id(1)
                .name("Product Name")
                .description("Product Description")
                .type(TypeProduct.FF)
                .seller(mock(UserEntity.class))
                .build();

        user = UserEntity.builder()
                .id(1)
                .build();

        warehouse = Warehouse.builder()
                .id(1)
                .manager(user)
                .build();

        sector = Sector.builder()
                .id(1)
                .warehouse(warehouse)
                .build();


        batch = Batch.builder()
                .id(1)
                .product(product)
                .sector(sector)
                .batchNumber("1")
                .currentQuantity(10)
                .dueDate(LocalDate.now().plusWeeks(2))
                .build();

        listBatch = List.of(batch);
    }

    @Test
    @DisplayName("Obtengo la información de los lotes por fecha de vencimiento.")
    public void batchInfoDueDateIsReturnedWhenUserIsManager() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        BatchStockDTO expectedBatchStockDTO = createBatchStockDTO(listBatch);
        String category = "FF";
        String order = "date_asc";
        when(authentication.getPrincipal()).thenReturn(userEntity);
        when(batchService.getBatchStockByProductId(5, 1, category, order)).thenReturn(expectedBatchStockDTO);

        ResponseEntity<?> response = batchController.getBatchInfoDueDate(5, "FF", order);

        assertEquals(ResponseEntity.ok(expectedBatchStockDTO), response);
    }

    private BatchStockDTO createBatchStockDTO(List<Batch> batches) {
        return BatchStockDTO.builder()
                .batchStock(batchesToBatchInfoDueDateDto(batches))
                .build();
    }

    private List<BatchInfoDueDateDTO> batchesToBatchInfoDueDateDto(List<Batch> batches) {
        return batches.stream()
                .map(batch -> BatchInfoDueDateDTO.builder()
                        .batchNumber(Integer.parseInt(batch.getBatchNumber()))
                        .productId(batch.getProduct().getId())
                        .productTypeId(batch.getProduct().getId())
                        .dueDate(batch.getDueDate())
                        .currentQuantity(batch.getCurrentQuantity())
                        .build())
                .toList();
    }
}
