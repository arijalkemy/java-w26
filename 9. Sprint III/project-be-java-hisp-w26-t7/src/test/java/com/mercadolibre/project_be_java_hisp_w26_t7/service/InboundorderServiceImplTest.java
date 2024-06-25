package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.beans.AuthDataUtil;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.order.OrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.InboundorderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.stock.StockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.*;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.BachMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.StockMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.*;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.MessageError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class InboundorderServiceImplTest {

    @Mock
    private AuthDataUtil authDataUtil;

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private ISectionRepository sectionRepository;

    @Mock
    private IRepresentativeRepository representativeRepository;

    @Mock
    private IProductSellerRepository productSellerRepository;

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private InboundorderServiceImpl inboundorderService;

    private InboundorderRequestDTO request;

    @BeforeEach
    void setUp() {
        request = InboundorderRequestDTO.builder()
                .inboundOrder(
                        OrderRequestDTO.builder()
                                .orderNumber(1)
                                .batchStock(List.of(DataUtils.getRequestBatch()))
                                .orderDate(LocalDate.now())
                                .section(DataUtils.getRequestSection())
                                .build()
                )
                .build();
    }


    @Test
    @DisplayName("Save Inboundorder successful")
    void saveInboundorderTest() {
        // Arrange
        ProductSeller product = DataUtils.getProductSeller();
        Warehouse warehouse = DataUtils.getWarehouse();
        Representative representative = DataUtils.getRepresentative();
        Section currentSection = DataUtils.getSection();

        Long sectionId = currentSection.getCode();
        Long warehouseId = warehouse.getId();
        Long representativeId = representative.getId();
        Long productId = product.getId();
        List<StockResponseDTO> listExpected = new ArrayList<>();
        BatchStockResponseDTO expected = new BatchStockResponseDTO();
        // Act
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(currentSection));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));
        when(productSellerRepository.findById(productId)).thenReturn(Optional.of(product));
        request.getInboundOrder().getBatchStock().forEach(batchStock -> {
            Batch batch = BachMapper.requestDtoToEntity(batchStock);
            batch.setProductSeller(product);
            listExpected.add(StockMapper.entityToStockResponse(batch));
        });
        expected.setBatchStock(listExpected);

        BatchStockResponseDTO actual = inboundorderService.saveInboundorder(request);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Product seller not found exception")
    void saveInboundorderProductSellerNotFoundTest() {
        // Arrange
        ProductSeller product = DataUtils.getProductSeller();
        Warehouse warehouse = DataUtils.getWarehouse();
        Representative representative = DataUtils.getRepresentative();
        Section currentSection = DataUtils.getSection();

        Long sectionId = currentSection.getCode();
        Long warehouseId = warehouse.getId();
        Long representativeId = representative.getId();
        Long productId = product.getId();
        String exMessage = MessageError.PRODUCT_ID_NOT_FOUND.getMessage(productId);

        // Act
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(currentSection));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));
        when(productSellerRepository.findById(productId)).thenReturn(Optional.empty());

        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));

        assertEquals(exMessage, actual.getMessage());
    }

    @Test
    @DisplayName("Representative logon not found exception")
    public void saveInboundorderRepresentativeNotFoundTest() {
        Long representativeId = 1L;

        String exMessage = MessageError.REPRESENTATIVE_ID_NOT_FOUND.getMessage(representativeId);
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.empty());

        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));

        assertEquals(exMessage, actual.getMessage());
    }

    @Test
    @DisplayName("Section not found exception")
    public void saveInboundorderTestSectionNotFoundException() {
        //Arrange
        Long representativeId = 1L;
        Long sectionId = 1L;
        Representative representative = DataUtils.getRepresentative();

        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.empty());
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.SECTION_NOT_FOUND.getMessage(), actual.getMessage());
    }

    @Test
    @DisplayName("Warehouse not found exception")
    public void saveInboundorderTestWarehouseNotFoundException() {
        //Arrange
        Section section = DataUtils.getSection();
        Long representativeId = 1L;
        Long sectionId = section.getCode();
        Long warehouseId = 1L;
        Representative representative = DataUtils.getRepresentative();

        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(section));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.empty());
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.WAREHOUSE_NOT_FOUND.getMessage(warehouseId), actual.getMessage());
    }

    @Test
    @DisplayName("Section not associated warehouse exception")
    public void saveInboundorderTestSectionNotAssociatedWithWareHouse() {
        Warehouse warehouse = DataUtils.getWarehouse();
        Section sectionActual = DataUtils.getSectionCp();
        request.getInboundOrder().setSection(DataUtils.getRequestSectionCp());
        Long representativeId = 1L;
        Long warehouseId = warehouse.getId();
        Long sectionId = sectionActual.getCode();
        Representative representative = DataUtils.getRepresentative();

        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(sectionActual));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.SECTION_NOT_ASSOCIATED_WITH_WAREHOUSE.getMessage(sectionId), actual.getMessage());
    }

    @Test
    @DisplayName("Representative logon no associated with warehouse exception")
    public void saveInboundorderTestSectionRepresentativeNotAssociatedWithWareHouse() {
        // Arrange
        Warehouse warehouse = DataUtils.getWarehouse();
        Section sectionActual = DataUtils.getSection();
        Long representativeId = 1L;
        Long warehouseId = warehouse.getId();
        Long sectionId = sectionActual.getCode();
        Representative representativeActual = DataUtils.getRepresentativeAdditional();

        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(sectionActual));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.ofNullable(representativeActual));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.REPRESENTATIVE_NOT_ASSOCIATED_WITH_WAREHOUSE.getMessage(), actual.getMessage());
    }

    @Test
    @DisplayName("Batch size exceeded exception")
    public void saveInboundorderTestBatchSizeExceededException() {
        // Arrange
        Warehouse warehouse = DataUtils.getWarehouseCp();
        Section sectionActual = DataUtils.getSectionCp();
        Long representativeId = 1L;
        Long warehouseId = warehouse.getId();
        Long sectionId = sectionActual.getCode();
        Representative representativeActual = DataUtils.getRepresentative();
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(sectionActual));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representativeActual));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.BATCH_SIZE_EXCCED.getMessage(), actual.getMessage());
    }

    @Test
    @DisplayName("Product seller not associated with section exception")
    public void saveInboundorderTestProductSellerNotAssociatedToSection() {
        // Arrange
        Warehouse warehouse = DataUtils.getWarehouse();
        Section sectionActual = DataUtils.getSection();
        ProductSeller productSellerActual = DataUtils.getProductSellerCp();

        Long representativeId = 1L;
        Long warehouseId = warehouse.getId();
        Long sectionId = sectionActual.getCode();
        Long productSellerId = productSellerActual.getId();
        Representative representativeActual = DataUtils.getRepresentative();
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(sectionActual));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representativeActual));
        when(productSellerRepository.findById(productSellerId)).thenReturn(Optional.of(productSellerActual));

        //Act and Assert
        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.saveInboundorder(request));
        assertEquals(MessageError.SECTION_NOT_ASSOCIATED_WITH_PRODUCT
                .getMessage(productSellerActual.getProduct().getDescription()), actual.getMessage());
    }

    @Test
    @DisplayName("Update inboundorder successful")
    void updateInboundorder() {
        // Arrange
        ProductSeller product = DataUtils.getProductSeller();
        Warehouse warehouse = DataUtils.getWarehouse();
        Representative representative = DataUtils.getRepresentative();
        Section currentSection = DataUtils.getSection();
        Batch batch = DataUtils.getBatch();
        Long sectionId = currentSection.getCode();
        Long warehouseId = warehouse.getId();
        Long representativeId = representative.getId();
        Long productId = product.getId();
        List<StockResponseDTO> listExpected = new ArrayList<>();
        BatchStockResponseDTO expected = new BatchStockResponseDTO();
        // Act
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(currentSection));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));
        when(productSellerRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findBatchByBatchNumberAndProductSellerId(
                request.getInboundOrder().getBatchStock().get(0).getBatchNumber(),
                productId)).thenReturn(Optional.ofNullable(batch));

        request.getInboundOrder().getBatchStock().forEach(batchStock -> {
            Batch batchUpdated = BachMapper.requestDtoToEntity(batchStock);
            batchUpdated.setProductSeller(product);
            listExpected.add(StockMapper.entityToStockResponse(batchUpdated));
        });
        expected.setBatchStock(listExpected);

        BatchStockResponseDTO actual = inboundorderService.updateInboundorder(request);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void updateInboundorderNotFoundBatchException() {
        // Arrange
        ProductSeller product = DataUtils.getProductSeller();
        Warehouse warehouse = DataUtils.getWarehouse();
        Representative representative = DataUtils.getRepresentative();
        Section currentSection = DataUtils.getSection();
        Long sectionId = currentSection.getCode();
        Long warehouseId = warehouse.getId();
        Long representativeId = representative.getId();
        Long productId = product.getId();
        String exMessage = MessageError.BATCH_NOT_FOUND_NUMBER.getMessage(
                request.getInboundOrder().getBatchStock().get(0).getBatchNumber());

        // Act
        when(authDataUtil.getIdSession()).thenReturn(representativeId);
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(currentSection));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(representativeRepository.findById(representativeId)).thenReturn(Optional.of(representative));
        when(productSellerRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findBatchByBatchNumberAndProductSellerId(
                request.getInboundOrder().getBatchStock().get(0).getBatchNumber(),
                productId)).thenReturn(Optional.empty());

        NotFoundException actual = assertThrows(NotFoundException.class, () ->
                inboundorderService.updateInboundorder(request));

        // Assert
        assertEquals(exMessage, actual.getMessage());
    }

}
