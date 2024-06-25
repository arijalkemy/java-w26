package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.BatchDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.SectionDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class InboundOrderTest {

    @Mock
    IInboundOrderRepository inboundOrderRepository;

    @Mock
    IBatchRepository batchRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    IWarehouseRepository warehouseRepository;

    @Mock
    ISectionRepository sectionRepository;

    @InjectMocks
    FreshProductServiceImpl freshProductService;

    private User user;
    private List<User> managersList;

    private Warehouse warehouse;

    private SectionDTO sectionDTO;
    private Section section;

    private BatchDTO batchDTO;
    private List<BatchDTO> batchesDTO;

    private Batch batch;
    private List<Batch> batches;

    private Product product;

    private InboundOrderRequestDTO inboundOrderDTO;
    private InboundOrder inboundOrder;

    private Long orderNumber;
    private LocalDateTime timeNow;

    @BeforeEach
    void setup() {
        orderNumber = 1L;
        Long userId = 1L;
        Long warehouseId = 1L;
        Long sectionId = 1L;
        Long batchId = 1L;
        Long productId = 1L;

        timeNow = LocalDateTime.now();

        product = Product.builder()
                .id(productId)
                .description("banana")
                .price(100.00)
                .build();


        user = User.builder()
                .id(userId)
                .role(Role.MANAGER)
                .build();

        managersList = new ArrayList<>() {{
            add(user);
        }};

        warehouse = Warehouse.builder()
                .id(warehouseId)
                .managerList(managersList)
                .build();

        sectionDTO = SectionDTO.builder()
                .id(sectionId)
                .warehouseCode(warehouseId)
                .build();

        section = Section.builder()
                .id(sectionId)
                .warehouse(warehouse)
                .build();

        batchDTO = BatchDTO.builder()
                .id(batchId)
                .productId(productId)
                .currentTemperature(10.0)
                .minimumTemperature(5.0)
                .manufacturingDate(LocalDate.now())
                .manufacturingTime(timeNow)
                .dueDate(LocalDate.now().plusWeeks(1))
                .build();

        batchesDTO = new ArrayList<>() {{
            add(batchDTO);
        }};

        batch = Batch.builder()
                .id(batchId)
                .product(product)
                .currentTemperature(10.0)
                .minimumTemperature(5.0)
                .manufacturingDate(LocalDate.now())
                .manufacturingTime(timeNow)
                .dueDate(LocalDate.now().plusWeeks(1))
                .build();

        batches = new ArrayList<>() {{
            add(batch);
        }};

        inboundOrderDTO = InboundOrderRequestDTO.builder()
                .id(orderNumber)
                .orderDate(LocalDate.now())
                .section(sectionDTO)
                .batchList(batchesDTO)
                .build();

        inboundOrder = InboundOrder.builder()
                .id(orderNumber)
                .orderDate(LocalDate.now())
                .section(section)
                .batchList(batches)
                .build();

        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(sectionRepository.findById(sectionId)).thenReturn(Optional.of(section));
        when(productRepository.findById(batchId)).thenReturn(Optional.of(product));
    }

    /* -- Testing creating inboundOrder service -- */

    @Test
    @DisplayName("testing freshProduct service for creating inboundOrders")
    void addInboundOrderService() throws Exception {
        //Arrange
        setCapacityAndProductQuantity(200, 100);
        ProductType productType = ProductType.builder()
                .id(1L)
                .description(ProductTypeEnum.FRESCO)
                .build();

        setSectionAndProductType(productType);
        List<BatchDTO> expected = new ArrayList<>() {{
            add(
                    BatchDTO.builder()
                            .id(batch.getId())
                            .productId(batch.getProduct().getId())
                            .currentTemperature(batch.getCurrentTemperature())
                            .minimumTemperature(batch.getMinimumTemperature())
                            .initialQuantity(batch.getInitialQuantity())
                            .currentQuantity(batch.getCurrentQuantity())
                            .manufacturingDate(batch.getManufacturingDate())
                            .manufacturingTime(batch.getManufacturingTime())
                            .dueDate(batch.getDueDate())
                            .build()
            );
        }};
        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.empty());

        //Act
        List<BatchDTO> result = freshProductService.addInboundOrder(inboundOrderDTO, user);

        //Assertions
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("testing freshProduct service for creating inboundOrders")
    void addInboundOrderServiceBatchDoesntExist() throws Exception {
        //Arrange
        setCapacityAndProductQuantity(200, 100);
        ProductType productType = ProductType.builder()
                .id(1L)
                .description(ProductTypeEnum.FRESCO)
                .build();

        Long fakePropductId = 1000L;

        List<BatchDTO> fakeBatches = new ArrayList<>() {{
            add(
                    BatchDTO.builder()
                            .id(batch.getId())
                            .productId(fakePropductId)
                            .currentTemperature(batch.getCurrentTemperature())
                            .minimumTemperature(batch.getMinimumTemperature())
                            .initialQuantity(batch.getInitialQuantity())
                            .currentQuantity(batch.getCurrentQuantity())
                            .manufacturingDate(batch.getManufacturingDate())
                            .manufacturingTime(batch.getManufacturingTime())
                            .dueDate(batch.getDueDate())
                            .build()
            );
        }};

        inboundOrderDTO.setBatchList(fakeBatches);

        setSectionAndProductType(productType);

        when(productRepository.findById(fakePropductId)).thenReturn(Optional.empty());

        //Act and Assertions

        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.addInboundOrder(inboundOrderDTO, user);
        });

        assertEquals("The product with id " + fakePropductId + " doesn't exist.\n", exception.getMessage());
    }

    @Test
    @DisplayName("testing throw error user is not owner of warehouse")
    void addInboundOrderUserIsNotOwner() throws Exception {
        User fakeUser = User.builder()
                .id(1000L)
                .role(Role.MANAGER)
                .build();


        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.addInboundOrder(inboundOrderDTO, fakeUser);
        });

        assertEquals("The user is not owner of this warehouse", exception.getMessage());
    }

    @Test
    @DisplayName("testing throw error trying to create an inboundOrder that already exist")
    void addInboundOrderServiceAlreadyExist() throws Exception {
        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.of(inboundOrder));

        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.addInboundOrder(inboundOrderDTO, user);
        });

        assertEquals("The inboundOrder already exist", exception.getMessage());
    }

    @Test
    @DisplayName("testing freshProduct service for creating inboundOrders insufficient stock")
    void addInboundOrderServiceNotEnoughStock() throws Exception {
        //Arrange
        setCapacityAndProductQuantity(100, 200);
        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.empty());

        // Act and Assert
        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.addInboundOrder(inboundOrderDTO, user);
        });

        // Assert the exception message
        assertEquals("This section has not sufficient stock", exception.getMessage());
    }


    @Test
    @DisplayName("testing freshProduct service for creating inboundOrders with diff types than the sucursal")
    void addInboundOrderServiceDifferentTypes() throws Exception {
        //Arrange
        setCapacityAndProductQuantity(200, 100);

        ProductType productType = ProductType.builder()
                .id(1L)
                .description(ProductTypeEnum.FRESCO)
                .build();

        ProductType diffProductType = ProductType.builder()
                .id(2L)
                .description(ProductTypeEnum.CONGELADO)
                .build();

        setSectionAndProductType(productType, diffProductType);

        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.addInboundOrder(inboundOrderDTO, user);
        });

        System.out.println("Exception message: " + exception.getMessage());

    }

    /* -- Testing updating inboundOrder service -- */

    @Test
    @DisplayName("testing freshProduct service for updating inboundOrders")
    void updateInboundOrderService() throws Exception {
        //Arrange
        setCapacityAndProductQuantity(200, 100);
        ProductType productType = ProductType.builder()
                .id(1L)
                .description(ProductTypeEnum.FRESCO)
                .build();
        setSectionAndProductType(productType);
        List<BatchDTO> expected = new ArrayList<>() {{
            add(
                    BatchDTO.builder()
                            .id(batch.getId())
                            .productId(batch.getProduct().getId())
                            .currentTemperature(batch.getCurrentTemperature())
                            .minimumTemperature(batch.getMinimumTemperature())
                            .initialQuantity(batch.getInitialQuantity())
                            .currentQuantity(batch.getCurrentQuantity())
                            .manufacturingDate(batch.getManufacturingDate())
                            .manufacturingTime(batch.getManufacturingTime())
                            .dueDate(batch.getDueDate())
                            .build()
            );
        }};

        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.of(inboundOrder));

        //Act
        List<BatchDTO> result = freshProductService.updateInboundOrder(inboundOrderDTO, user);

        //Assertions
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("testing throw error trying to updating an inboundOrder that doesn't exist")
    void updateInboundOrderServiceDoesntExist() throws Exception {
        when(inboundOrderRepository.findById(orderNumber)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            freshProductService.updateInboundOrder(inboundOrderDTO, user);
        });

        assertEquals("The inboundOrder doesn't exist", exception.getMessage());
    }

    private void setCapacityAndProductQuantity(int capacity, int productQuantity) {
        section.setCapacity(capacity);
        batchDTO.setInitialQuantity(productQuantity);
        batchDTO.setCurrentQuantity(productQuantity);
        batch.setInitialQuantity(productQuantity);
        batch.setCurrentQuantity(productQuantity);
    }

    private void setSectionAndProductType(ProductType sectionType, ProductType productType) {
        section.setProductType(sectionType);
        product.setProductType(productType);
    }

    private void setSectionAndProductType(ProductType sameType) {
        section.setProductType(sameType);
        product.setProductType(sameType);
    }
}
