package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.unit;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.BatchRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.AlreadyExistsException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.WrongSectorException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper.BatchMapper;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Sector;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl.BatchServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchServiceTest {
    @Mock
    IBatchRepository batchRepository;
    @Mock
    ISectorRepository sectorRepository;
    @Mock
    IProductRepository productRepository;
    @Mock
    IWarehouseRepository warehouseRepository;
    @InjectMocks
    BatchServiceImpl batchService;

    @Test
    @DisplayName("Se intenta crear una orden de stock para el lote '20241201-123' " +
            "y como el numero de lote ya existe, se lanza una excepcion AlreadyExistsException.")
    public void createInboundOrderBatchAlreadyExists(){
        // Arrange
        String alreadyUsedBatchCode = "20241201-123";
        Batch batch = Batch.builder().batchNumber(alreadyUsedBatchCode).build();
        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .batchStock(BatchRequestDTO.builder()
                        .batchNumber(alreadyUsedBatchCode)
                        .build())
                .build();
        when(batchRepository.findByBatchNumber(alreadyUsedBatchCode))
                .thenReturn(Optional.of(batch));

        // Act and assert
        assertThrows(
                AlreadyExistsException.class,
                () -> batchService.createInboundOrder(inboundOrderRequestDTO)
        );
    }

    @Test
    @DisplayName("Se intenta crear una orden de stock para el lote '20241201-001' " +
            "del sector Congelados (FF) de un warehouse existente asociado y se guarda correctamente.")
    public void createInboundOrderSuccessfully() {
        // Arrange
        Product mockProduct = Product.builder()
                .id(1)
                .type(TypeProduct.valueOf("FF"))
                .build();
        Warehouse mockWarehouse = Warehouse.builder()
                .id(1)
                .build();
        Sector mockSector = Sector.builder()
                .id(1)
                .type(TypeProduct.valueOf("FF"))
                .warehouse(mockWarehouse)
                .build();
        when(productRepository.findById(1)).thenReturn(Optional.ofNullable(mockProduct));
        when(sectorRepository.findById(1)).thenReturn(Optional.ofNullable(mockSector));
        when(warehouseRepository.findById(1)).thenReturn(Optional.ofNullable(mockWarehouse));

        Batch expectedBatch = Batch.builder()
                .batchNumber("20241201-001")
                .product(mockProduct)
                .sector(mockSector)
                .build();

        BatchResponseDTO expectedResponse = BatchMapper.BatchToBatchResponseDTO(
                expectedBatch
        );

        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .section(SectionRequestDTO.builder()
                        .sectorId(1)
                        .warehouseCode(1)
                        .build())
                .batchStock(BatchMapper.BatchToBatchRequestDTO(expectedBatch))
                .build();

        // Act
        BatchResponseDTO actualResponse = batchService.createInboundOrder(inboundOrderRequestDTO);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Se intenta crear una orden de stock para el lote '20241201-001' del tipo Congelados (FF) " +
            "en el sector frescos (FR)  y se se lanza mensaje de error WrongSectorException.")
    public void createInboundOrderWrongSectorProduct() {
        // Arrange
        Product mockProduct = Product.builder()
                .id(1)
                .type(TypeProduct.valueOf("FF"))
                .build();
        Warehouse mockWarehouse = Warehouse.builder()
                .id(1)
                .build();
        Sector mockSector = Sector.builder()
                .id(1)
                .type(TypeProduct.valueOf("RF"))
                .warehouse(mockWarehouse)
                .build();
        when(productRepository.findById(1)).thenReturn(Optional.ofNullable(mockProduct));
        when(sectorRepository.findById(1)).thenReturn(Optional.ofNullable(mockSector));
        when(warehouseRepository.findById(1)).thenReturn(Optional.ofNullable(mockWarehouse));

        Batch expectedBatch = Batch.builder()
                .batchNumber("20241201-001")
                .product(mockProduct)
                .sector(mockSector)
                .build();

        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .section(SectionRequestDTO.builder()
                        .sectorId(1)
                        .warehouseCode(1)
                        .build())
                .batchStock(BatchMapper.BatchToBatchRequestDTO(expectedBatch))
                .build();

        // Act and Assert
        assertThrows(
                WrongSectorException.class,
                () -> batchService.createInboundOrder(inboundOrderRequestDTO)
        );
    }

    @Test
    @DisplayName("Se intenta crear una orden de stock para el lote '20241201-001' del tipo Frescos (FR) " +
            "en el sector Frescos (FR) de un warehouse no asociado a este y " +
            "se se lanza mensaje de error WrongSectorException.")
    public void createInboundOrderWrongSectorWarehouse() {
        // Arrange
        Product mockProduct = Product.builder()
                .id(1)
                .type(TypeProduct.valueOf("FF"))
                .build();
        Warehouse mockWarehouse = Warehouse.builder()
                .id(1)
                .build();
        Warehouse wrongMockWarehouse = Warehouse.builder()
                .id(2)
                .build();
        Sector mockSector = Sector.builder()
                .id(1)
                .type(TypeProduct.valueOf("RF"))
                .warehouse(mockWarehouse)
                .build();
        when(productRepository.findById(1)).thenReturn(Optional.ofNullable(mockProduct));
        when(sectorRepository.findById(1)).thenReturn(Optional.ofNullable(mockSector));
        when(warehouseRepository.findById(2)).thenReturn(Optional.ofNullable(wrongMockWarehouse));

        Batch expectedBatch = Batch.builder()
                .batchNumber("20241201-001")
                .product(mockProduct)
                .sector(mockSector)
                .build();

        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .section(SectionRequestDTO.builder()
                        .sectorId(1)
                        .warehouseCode(2)
                        .build())
                .batchStock(BatchMapper.BatchToBatchRequestDTO(expectedBatch))
                .build();

        // Act and Assert
        assertThrows(
                WrongSectorException.class,
                () -> batchService.createInboundOrder(inboundOrderRequestDTO)
        );
    }

    @Test
    @DisplayName("Se intenta actualizar el lote con numero '20241201-000' " +
            "y como no existe, se lanza una excepcion de NotFoundException")
    public void updateInboundOrderBatchNotFound() {
        // Arrange
        String unusedBatchCode = "20241201-000";
        Optional<Batch> emptyOptionalBatch = Optional.empty();
        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .batchStock(
                        BatchRequestDTO.builder()
                                .batchNumber(unusedBatchCode)
                                .build()
                ).build();
        when(batchRepository.findByBatchNumber(unusedBatchCode))
                .thenReturn(emptyOptionalBatch);

        // Act and Assert
        assertThrows(
                NotFoundException.class,
                () -> batchService.updateInboundOrder(inboundOrderRequestDTO)
        );
    }
}
