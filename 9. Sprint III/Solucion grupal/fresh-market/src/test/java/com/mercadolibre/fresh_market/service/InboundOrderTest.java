package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.config.BadRequestException;
import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.dtos.SectionDTO;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.impl.InboundOrderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InboundOrderTest {

    @InjectMocks
    InboundOrderImpl inboundOrderService;

    @Mock
    IInboundOrderRepository inboundOrderRepository;

    @Mock
    IBatchRepository batchRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    ISectionRepository sectionRepository;

    @Mock
    IWarehouseRepository warehouseRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateInboundOrder_Success() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());

        User warehouseman = new User();
        warehouseman.setId(1L); // Set the warehouseman id to match the one in the UserDetails

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L); // Set the warehouse id to match the one in the DTO
        warehouse.setWarehouseman(warehouseman); // Set the warehouseman to the created user

        Section section = new Section();
        section.setWarehouse(warehouse); // Set the warehouse to the created warehouse

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);
        when(inboundOrderRepository.save(any(InboundOrder.class))).thenAnswer(i -> i.getArguments()[0]);

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act
        List<BatchDTO> result = inboundOrderService.createInboundOrder(inboundOrderDTO);

        // Assert
        assertNotNull(result);
        verify(inboundOrderRepository, times(2)).save(any(InboundOrder.class));
    }

    @Test
    public void testUpdateInboundOrder_Success() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());
        InboundOrder existingInboundOrder = new InboundOrder(1L, LocalDate.now(), 10, new ArrayList<>(), new User());

        User warehouseman = new User();
        warehouseman.setId(1L); // Set the warehouseman id to match the one in the UserDetails

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L); // Set the warehouse id to match the one in the DTO
        warehouse.setWarehouseman(warehouseman); // Set the warehouseman to the created user

        Section section = new Section();
        section.setWarehouse(warehouse); // Set the warehouse to the created warehouse

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);
        when(inboundOrderRepository.findById(existingInboundOrder.getId())).thenReturn(Optional.of(existingInboundOrder));
        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(existingInboundOrder);

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act
        List<BatchDTO> result = inboundOrderService.updateInboundOrder(1L, inboundOrderDTO);

        // Assert
        assertNotNull(result);
        verify(inboundOrderRepository, times(1)).save(any(InboundOrder.class));
    }

    @Test
    public void testCreateInboundOrder_Failure() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L); // Set the warehouse id to match the one in the DTO
        warehouse.setWarehouseman(new User()); // Set the warehouseman to null

        Section section = new Section();
        section.setWarehouse(warehouse); // Set the warehouse to the created warehouse

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Test
    public void testUpdateInboundOrder_Failure() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());
        InboundOrder existingInboundOrder = new InboundOrder(1L, LocalDate.now(), 10, new ArrayList<>(), new User());

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L); // Set the warehouse id to match the one in the DTO
        warehouse.setWarehouseman(new User()); // Set the warehouseman to null

        Section section = new Section();
        section.setWarehouse(warehouse); // Set the warehouse to the created warehouse

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);
        when(inboundOrderRepository.findById(existingInboundOrder.getId())).thenReturn(Optional.of(existingInboundOrder));

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.updateInboundOrder(1L, inboundOrderDTO));
    }

    @Test
    public void testCreateInboundOrder_WarehouseNotFound() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(null);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Test
    public void testCreateInboundOrder_UserCannotCreateInboundOrder() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());

        User warehouseman = new User();
        warehouseman.setId(2L);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setWarehouseman(warehouseman);

        Section section = new Section();
        section.setWarehouse(warehouse);

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Test
    public void testCreateInboundOrder_SectionWarehouseCodeNotMatch() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 2L), new ArrayList<>());

        User warehouseman = new User();
        warehouseman.setId(1L);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setWarehouseman(warehouseman);

        Section section = new Section();
        section.setWarehouse(warehouse);

        when(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())).thenReturn(warehouse);
        when(sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);

        // Simulate authentication
        UserDetails userDetails = new User(1L, Role.WAREHOUSEMAN, "Jane", "Doe", "username", "password", "address");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Test
    public void testAddBatchToBatchList() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());
        Product product = new Product();
        product.setId(1L);

        Section section = new Section();
        section.setId(1L);

        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setInitialQuantity(10);
        batchDTO.setCurrentQuantity(10);
        batchDTO.setDueDate(LocalDate.now());
        batchDTO.setManufacturingDate(LocalDate.now());
        batchDTO.setManufacturingTime(LocalDateTime.now());
        batchDTO.setBatchNumber(1);
        batchDTO.setCurrentTemperature(20.0);
        batchDTO.setMinimumTemperature(15.0);
        batchDTO.setProductId(1L);

        inboundOrderDTO.getBatchStock().add(batchDTO);

        when(productRepository.getOne(batchDTO.getProductId())).thenReturn(product);
        when(sectionRepository.getOne(inboundOrderDTO.getSectionDTO().getSectionCode())).thenReturn(section);

        // Act
        List<Batch> result = inboundOrderService.listBatchDTOtoListBatch(inboundOrderDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(batchDTO.getInitialQuantity(), result.get(0).getInitialQuantity());
        assertEquals(batchDTO.getCurrentQuantity(), result.get(0).getCurrentQuantity());
        assertEquals(batchDTO.getDueDate(), result.get(0).getDueDate());
        assertEquals(batchDTO.getManufacturingDate(), result.get(0).getManufacturingDate());
        assertEquals(batchDTO.getManufacturingTime(), result.get(0).getManufacturingTime());
        assertEquals(batchDTO.getBatchNumber(), result.get(0).getBatchNumber());
        assertEquals(batchDTO.getCurrentTemperature(), result.get(0).getCurrentTemperature());
        assertEquals(batchDTO.getMinimumTemperature(), result.get(0).getMinimumTemperature());
        assertEquals(batchDTO.getProductId(), result.get(0).getProduct().getId());
        assertEquals(inboundOrderDTO.getSectionDTO().getSectionCode(), result.get(0).getSection().getId());
    }

    @Test
    public void testCreateInboundOrder_ProductNotFound() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO(10, LocalDate.now(), new SectionDTO(1L, 1L), new ArrayList<>());

        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setProductId(1L); // Set a product id that does not exist
        inboundOrderDTO.getBatchStock().add(batchDTO);

        when(productRepository.getOne(batchDTO.getProductId())).thenReturn(null);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Test
    public void testListBatchToListBatchDTO() {
        // Arrange
        Batch batch = new Batch();
        batch.setBatchNumber(1);
        batch.setProduct(new Product(1L));
        batch.setCurrentTemperature(20.0);
        batch.setMinimumTemperature(15.0);
        batch.setInitialQuantity(10);
        batch.setCurrentQuantity(10);
        batch.setManufacturingDate(LocalDate.now());
        batch.setManufacturingTime(LocalDateTime.now());
        batch.setDueDate(LocalDate.now());

        // Act
        BatchDTO result = inboundOrderService.listBatchtoListBatchDTO(batch);

        // Assert
        assertNotNull(result);
        assertEquals(batch.getBatchNumber(), result.getBatchNumber());
        assertEquals(batch.getProduct().getId(), result.getProductId());
        assertEquals(batch.getCurrentTemperature(), result.getCurrentTemperature());
        assertEquals(batch.getMinimumTemperature(), result.getMinimumTemperature());
        assertEquals(batch.getInitialQuantity(), result.getInitialQuantity());
        assertEquals(batch.getCurrentQuantity(), result.getCurrentQuantity());
        assertEquals(batch.getManufacturingDate(), result.getManufacturingDate());
        assertEquals(batch.getManufacturingTime(), result.getManufacturingTime());
        assertEquals(batch.getDueDate(), result.getDueDate());
    }

    @Test
    public void testSetInboundOrderToBatches() {
        // Arrange
        InboundOrder inboundOrder = new InboundOrder(1L, LocalDate.now(), 10, new ArrayList<>(), new User());

        List<Batch> batchList = new ArrayList<>();
        Batch batch1 = new Batch();
        Batch batch2 = new Batch();
        batchList.add(batch1);
        batchList.add(batch2);

        InboundOrder inboundOrderCreated = inboundOrderRepository.save(inboundOrder);

        // Act
        for (Batch batch : batchList) {
            batch.setInboundOrder(inboundOrderCreated);
        }

        // Assert
        for (Batch batch : batchList) {
            assertEquals(inboundOrderCreated, batch.getInboundOrder());
        }
    }
}