package com.mercadolibre.pf_be_hisp_w26_t6_martinez.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.InboundOrderDto.InboundOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.SectionDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IBatchesRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IInboundOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IProductsRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IWarehousesRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.inboundOrder.InboundOrderServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.UserRoles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InboundOrderServiceImplTest {
    @Mock
    IBatchesRepository batchesRepository;
    @Mock
    IProductsRepository productsRepository;
    @Mock
    IInboundOrderRepository inboundOrderRepository;
    @Mock
    IWarehousesRepository warehousesRepository;

    @InjectMocks
    InboundOrderServiceImpl inboundOrderService;

    List<Warehouse> warehouses;
    List<Product> products;
    List<Batch> batches;
    List<Sector> sections;
    List<User> supervisores;
    Authentication authentication;

    @BeforeEach
    void setup(){
        User supervisor = User.builder().id(1L).name("Eric").username("Eric").hashedPassword("1234")
                .userRole(UserRoles.SUPERVISOR).build();
        User supervisor2 = User.builder().id(2L).name("Eric").username("Ale").hashedPassword("1235")
                .userRole(UserRoles.SUPERVISOR).build();

        supervisores = new ArrayList<>(List.of(supervisor, supervisor2));

        authentication = new UsernamePasswordAuthenticationToken(supervisor.getUsername(), "password");

        Product product = Product.builder().id(1L).name("Queso").storageType(StorageType.RF).unitPrice(3000.00)
                .build();
        Product product2 = Product.builder().id(2L).name("Yogurt").storageType(StorageType.RF).unitPrice(1300.00)
                .build();
        Product product3 = Product.builder().id(3L).name("Helado").storageType(StorageType.FF).unitPrice(1600.00)
                .build();
        Product product4 = Product.builder().id(4L).name("Paty").storageType(StorageType.FF).unitPrice(3500.00)
                .build();

        products = new ArrayList<>(List.of(product, product2, product3, product4));

        Batch batch = Batch.builder().id(1L).batchNumber(1234).currentTemperature(13.0).minimumTemperature(10.0)
                .product(product).quantity(20).build();
        Batch batch2 = Batch.builder().id(2L).batchNumber(1235).currentTemperature(13.0).minimumTemperature(10.0)
                .product(product2).quantity(40).build();
        Batch batch3 = Batch.builder().id(3L).batchNumber(1236).currentTemperature(13.0).minimumTemperature(10.0)
                .product(product3).quantity(30).build();

        batches = List.of(batch, batch2, batch3);

        Sector refrigeratedSector = Sector.builder().sectorCode(1L).storageType(StorageType.RF)
                .batches(new ArrayList<>(List.of(batch, batch2))).remainingCapacity(2000).build();

        Sector frozenSector = Sector.builder().sectorCode(2L).storageType(StorageType.FF)
                .batches(new ArrayList<>(List.of(batch3))).remainingCapacity(1000).build();

        sections = new ArrayList<>(List.of(refrigeratedSector, frozenSector));

        Warehouse warehouse = Warehouse.builder().warehouseCode(1)
                .sectors(List.of(refrigeratedSector, frozenSector))
                .supervisor(supervisor)
                .build();

        Warehouse warehouse2 = Warehouse.builder().warehouseCode(2).supervisor(supervisor2).build();

        warehouses = new ArrayList<>(List.of(warehouse, warehouse2));
    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse correctly")
    public void insertBatchInFulfillmentWarehouseTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();
        BatchDto batchDto = BatchDto.builder()
                .batchNumber(1237)
                .productId(4)
                .initialQuantity(20)
                .currentQuantity(20)
                .manufacturingDate("14-04-2024")
                .manufacturingTime("14-04-2024 00:00:00")
                .dueDate("14-05-2024 00:00:00")
                .currentTemperature(15.00)
                .minimumTemperature(11.00)
                .build();
        List<BatchDto> batchList = new ArrayList<>(List.of(batchDto));
        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .orderNumber(4)
                .orderDate("14-04-2024")
                .section(SectionDto.builder()
                        .sectionCode(2L)
                        .warehouseCode(1)
                        .build())
                .batchStock(batchList)
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        BatchInsertionResponseDto expectedDto = BatchInsertionResponseDto.builder()
                .batchDto(batchList)
                .build();

        mockUserAccess();

        when(this.warehousesRepository.findById(1)).thenReturn(Optional.of(warehouses.get(0)));
        when(this.productsRepository.findById(4L)).thenReturn(Optional.of(this.products.get(3)));
        when(this.batchesRepository.findByBatchNumber(1237)).thenReturn(null);
        when(this.inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(new InboundOrder());

        BatchInsertionResponseDto responseDto = inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto,
                false);

        Assertions.assertEquals(expectedDto, responseDto);

    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse throws exception when warehouse does not exist")
    public void insertBatchInFulfillmentWarehouseNotFoundWarehouseTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();

        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(2L)
                        .warehouseCode(2)
                        .build())
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        when(this.warehousesRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,
                () -> {inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto, false);}
        );
    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse throws exception when Supervisor does not have access to warehouse")
    public void insertBatchInFulfillmentWarehouseBadRequestExceptionTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();

        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(2L)
                        .warehouseCode(2)
                        .build())
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        mockUserAccess();

        when(this.warehousesRepository.findById(2)).thenReturn(Optional.of(warehouses.get(1)));

        Assertions.assertThrows(BadRequestException.class,
                () -> {inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto, false);}
        );
    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse throws exception when Product does not exist")
    public void insertBatchInFulfillmentWarehouseNotFoundSectorTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();

        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(3L)
                        .warehouseCode(1)
                        .build())
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        mockUserAccess();

        when(this.warehousesRepository.findById(any())).thenReturn(Optional.of(warehouses.get(0)));

        Assertions.assertThrows(NotFoundException.class,
                () -> {inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto, false);}
        );
    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse throws exception when type of product is wrong")
    public void insertBatchInFulfillmentWarehouseNotFoundProductTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();
        BatchDto batchDto = BatchDto.builder()
                .batchNumber(1237)
                .productId(5)
                .build();
        List<BatchDto> batchList = new ArrayList<>(List.of(batchDto));
        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(2L)
                        .warehouseCode(1)
                        .build())
                .batchStock(batchList)
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        mockUserAccess();

        when(this.warehousesRepository.findById(any())).thenReturn(Optional.of(warehouses.get(0)));
        when(this.productsRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,
                () -> {inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto, false);}
        );
    }

    @Test
    @DisplayName("Insert batch in fulfillment warehouse throws exception when type is wrong")
    public void insertBatchInFulfillmentWarehouseWrongTypeTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();
        BatchDto batchDto = BatchDto.builder()
                .batchNumber(1237)
                .productId(4)
                .build();
        List<BatchDto> batchList = new ArrayList<>(List.of(batchDto));
        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .orderNumber(4)
                .orderDate("14-04-2024")
                .section(SectionDto.builder()
                        .sectionCode(1L)
                        .warehouseCode(1)
                        .build())
                .batchStock(batchList)
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        mockUserAccess();

        when(this.warehousesRepository.findById(1)).thenReturn(Optional.of(warehouses.get(0)));
        when(this.productsRepository.findById(4L)).thenReturn(Optional.of(this.products.get(3)));

        Assertions.assertThrows(NotFoundException.class,
                () -> {inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto, false);});

    }


    @Test
    @DisplayName("Update batch in fulfillment warehouse correctly")
    public void updateBatchInFulfillmentWarehouseTest() {
        BatchInsertionRequestDto requestDto = new BatchInsertionRequestDto();
        BatchDto batchDto = BatchDto.builder()
                .batchNumber(1236)
                .productId(3)
                .initialQuantity(20)
                .currentQuantity(20)
                .manufacturingDate("14-04-2024")
                .manufacturingTime("14-04-2024 00:00:00")
                .dueDate("14-05-2024 00:00:00")
                .currentTemperature(15.00)
                .minimumTemperature(11.00)
                .build();
        List<BatchDto> batchList = new ArrayList<>(List.of(batchDto));
        InboundOrderRequestDto inboundOrderRequest = InboundOrderRequestDto.builder()
                .orderNumber(4)
                .orderDate("14-04-2024")
                .section(SectionDto.builder()
                        .sectionCode(2L)
                        .warehouseCode(1)
                        .build())
                .batchStock(batchList)
                .build();
        requestDto.setInboundOrderRequestDto(inboundOrderRequest);

        BatchInsertionResponseDto expectedDto = BatchInsertionResponseDto.builder()
                .batchDto(batchList)
                .build();

        mockUserAccess();

        when(this.warehousesRepository.findById(1)).thenReturn(Optional.of(warehouses.get(0)));
        when(this.productsRepository.findById(3L)).thenReturn(Optional.of(this.products.get(2)));
        when(this.batchesRepository.findByBatchNumber(1236)).thenReturn(batches.get(1));
        when(this.inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(new InboundOrder());

        BatchInsertionResponseDto responseDto = inboundOrderService.insertBatchInFulfillmentWarehouse(requestDto,
                true);

        Assertions.assertEquals(expectedDto, responseDto);
    }

    private void mockUserAccess() {
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

}
