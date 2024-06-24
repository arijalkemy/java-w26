package com.mercadolibre.pf_be_hisp_w26_t6_martinez.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchTransferDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.ConflictException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.TransferService.TransferServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.OutboundStatus;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTests {

    @Mock
    private IOutboundOrderRepository outboundOrderRepository;

    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @Mock
    private IBatchesRepository batchesRepository;

    @Mock
    private IWarehousesRepository warehouseRepository;

    @Mock
    private ITransferHistoryRepository batchTransferHistoryRepository;

    @Mock
    private ISectorRepository sectorRepository;

    @InjectMocks
    private TransferServiceImpl transferService;

    private OutboundOrderDto outboundOrderDto;
    private OutboundOrder outboundOrder;
    private InboundOrder inboundOrder;
    private Batch batch;
    private Sector sector;
    private Warehouse fromWarehouse;
    private Warehouse toWarehouse;
    private TransferHistory transferHistory;

    @BeforeEach
    void setUp() {
        // Inicializamos un producto de prueba
        Product product = Product.builder()
                .id(1L)
                .name("Product 1")
                .storageType(StorageType.FF)
                .unitPrice(10.0)
                .build();

        // Inicializamos un lote de prueba con el producto
        batch = Batch.builder()
                .id(1L)
                .batchNumber(1)
                .product(product)
                .build();

        // Inicializamos un sector con el lote
        sector = Sector.builder()
                .sectorCode(1L)
                .batches(new ArrayList<>(new ArrayList<>(List.of(batch))))
                .remainingCapacity(10)
                .storageType(StorageType.FF)
                .build();

        // Inicializamos el almacén de origen con el sector
        fromWarehouse = Warehouse.builder()
                .warehouseCode(1)
                .sectors(new ArrayList<>(new ArrayList<>(List.of(sector))))
                .build();

        // Inicializamos el almacén de destino con el sector
        toWarehouse = Warehouse.builder()
                .warehouseCode(2)
                .sectors(new ArrayList<>(new ArrayList<>(List.of(sector))))
                .build();

        // Inicializamos una orden de salida con el lote
        outboundOrder = OutboundOrder.builder()
                .orderNumber(1L)
                .orderDate(LocalDate.now())
                .status(OutboundStatus.INITIATED)
                .batches(new ArrayList<>(List.of(batch)))
                .updatedAt(LocalDateTime.now())
                .build();

        // Inicializamos una orden de entrada con el lote
        inboundOrder = InboundOrder.builder()
                .orderNumber(1L)
                .orderDate(LocalDate.now())
                .batches(new ArrayList<>(List.of(batch)))
                .build();

        // Inicializamos el historial de transferencia
        transferHistory = TransferHistory.builder()
                .batch(batch)
                .orderNumber(outboundOrder)
                .fromWarehouse(fromWarehouse)
                .toWarehouse(toWarehouse)
                .transferDate(LocalDateTime.now())
                .build();

        // Inicializamos el DTO de la orden de salida
        outboundOrderDto = OutboundOrderDto.builder()
                .orderNumber(1L)
                .warehouseOrigin(1)
                .warehouseDestination(2)
                .batches(new ArrayList<>(List.of(new BatchTransferDto(1))))
                .build();
    }

    @Test
    @DisplayName("Initiate transfer - successful case")
    void testInitiateTransferSuccessful() {
        Mockito.lenient().when(outboundOrderRepository.findById(1L)).thenReturn(Optional.empty());
        Mockito.lenient().when(warehouseRepository.findById(1)).thenReturn(Optional.of(fromWarehouse));
        Mockito.lenient().when(warehouseRepository.findById(2)).thenReturn(Optional.of(toWarehouse));
        Mockito.lenient().when(batchesRepository.findAllById(any())).thenReturn(new ArrayList<>(List.of(batch)));

        transferService.initiateTransfer(outboundOrderDto);

        verify(outboundOrderRepository, times(1)).save(any(OutboundOrder.class));
        verify(batchTransferHistoryRepository, times(1)).save(any(TransferHistory.class));
    }

    @Test
    @DisplayName("Initiate transfer - outbound order already exists")
    void testInitiateTransferOutboundOrderExists() {
        when(outboundOrderRepository.findById(1L)).thenReturn(Optional.of(outboundOrder));

        ConflictException exception = assertThrows(ConflictException.class, () -> {
            transferService.initiateTransfer(outboundOrderDto);
        });

        assertEquals("The Outbound order with ID: 1already exists", exception.getMessage());
    }

    @Test
    @DisplayName("Initiate transfer - origin warehouse not found")
    void testInitiateTransferOriginWarehouseNotFound() {
        when(outboundOrderRepository.findById(1L)).thenReturn(Optional.empty());
        when(warehouseRepository.findById(1)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            transferService.initiateTransfer(outboundOrderDto);
        });

        assertEquals("origin warehouse does not exist", exception.getMessage());
    }

    @Test
    @DisplayName("Initiate transfer - destination warehouse not found")
    void testInitiateTransferDestinationWarehouseNotFound() {
        when(outboundOrderRepository.findById(1L)).thenReturn(Optional.empty());
        when(warehouseRepository.findById(1)).thenReturn(Optional.of(fromWarehouse));
        when(warehouseRepository.findById(2)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            transferService.initiateTransfer(outboundOrderDto);
        });

        assertEquals("Destination warehouse does not exist", exception.getMessage());
    }

    @Test
    @DisplayName("Update transfer status - successful case to IN_PROGRESS")
    void testUpdateTransferStatusToInProgress() {
        when(outboundOrderRepository.findById(1L)).thenReturn(Optional.of(outboundOrder));

        transferService.updateTransferStatus(1L, "IN_PROGRESS");

        verify(outboundOrderRepository, times(1)).save(any(OutboundOrder.class));
        assertEquals(OutboundStatus.IN_PROGRESS, outboundOrder.getStatus());
    }

    @Test
    @DisplayName("Update transfer status - successful case to COMPLETED")
    void testUpdateTransferStatusToCompleted() {
        when(outboundOrderRepository.findById(1L)).thenReturn(Optional.of(outboundOrder));

        when(batchTransferHistoryRepository.findAllByOrderNumber(outboundOrder)).thenReturn(
                new ArrayList<>(List.of(transferHistory)));

        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(inboundOrder);

        transferService.updateTransferStatus(1L, "COMPLETED");

        verify(outboundOrderRepository, times(1)).save(any(OutboundOrder.class));
        verify(batchTransferHistoryRepository, times(1)).findAllByOrderNumber(outboundOrder);
        verify(inboundOrderRepository, times(1)).save(any(InboundOrder.class));
        assertEquals(OutboundStatus.COMPLETED, outboundOrder.getStatus());
    }

    @Test
    @DisplayName("Update transfer status - invalid status")
    void testUpdateTransferStatusInvalidStatus() {
        lenient().when(outboundOrderRepository.findById(1L)).thenReturn(Optional.of(outboundOrder));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            transferService.updateTransferStatus(1L, "INVALID_STATUS");
        });

        assertEquals("Invalid outbound Status", exception.getMessage());
    }
}
