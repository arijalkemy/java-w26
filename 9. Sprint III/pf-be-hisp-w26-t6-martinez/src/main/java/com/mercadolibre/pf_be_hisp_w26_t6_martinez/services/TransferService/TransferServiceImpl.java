package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.TransferService;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchTransferDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.ConflictException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.EnumChecker;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.OutboundStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TransferServiceImpl implements ITransferService {

    @Autowired
    IOutboundOrderRepository outboundOrderRepository;

    @Autowired
    IInboundOrderRepository inboundOrderRepository;

    @Autowired
    IBatchesRepository batchesRepository;

    @Autowired
    IWarehousesRepository warehouseRepository;

    @Autowired
    ITransferHistoryRepository batchTransferHistoryRepository;

    @Autowired
    ISectorRepository sectorRepository;


    @Transactional
    @Override
    public void initiateTransfer(OutboundOrderDto outboundOrderDto) {

        Optional<OutboundOrder> existingOrder = outboundOrderRepository.findById(outboundOrderDto.getOrderNumber());
        if (existingOrder.isPresent()){
            throw new ConflictException(
                    "The Outbound order with ID: " + outboundOrderDto.getOrderNumber() + "already exists");
        }

        Warehouse fromWarehouse = warehouseRepository.findById(outboundOrderDto.getWarehouseOrigin()).orElseThrow(
                () -> new NotFoundException("origin warehouse does not exist")
        );

        Warehouse toWarehouse = warehouseRepository.findById(outboundOrderDto.getWarehouseDestination()).orElseThrow(
                () -> new NotFoundException("Destination warehouse does not exist")
        ); // Verificar que el destino exista

        Set<Integer> batchNumbersFromDto = outboundOrderDto.getBatches().stream()
                .map(BatchTransferDto::getBatchNumber)
                .collect(Collectors.toSet());

        List<Batch> batches = fromWarehouse.getSectors().stream()
                .flatMap(sector -> sector.getBatches().stream())
                .filter(batch -> batchNumbersFromDto.contains(batch.getBatchNumber()))
                .toList();

        Set<Integer> batchNumbersFound = batches.stream()
                .map(Batch::getBatchNumber)
                .collect(Collectors.toSet());

        if (!batchNumbersFound.containsAll(batchNumbersFromDto)) {
            throw new BadRequestException("Some batch do not exist in the origin warehouse");
        }

         OutboundOrder outboundOrder = OutboundOrder.builder()
                 .orderNumber(outboundOrderDto.getOrderNumber())
                 .orderDate(LocalDate.now())
                 .status(OutboundStatus.INITIATED)
                 .batches(batches)
                 .updatedAt(LocalDateTime.now())
                 .build();

        outboundOrderRepository.save(outboundOrder);

        for (Batch batch : batches) {
            TransferHistory transferHistory = TransferHistory.builder()
                    .batch(batch)
                    .orderNumber(outboundOrder)
                    .fromWarehouse(fromWarehouse)
                    .toWarehouse(toWarehouse)
                    .transferDate(LocalDateTime.now())
                    .build();
            batchTransferHistoryRepository.save(transferHistory);
        }
    }

    @Transactional
    @Override
    public void updateTransferStatus(Long orderNumber, String newStatus) {

        // Check correct status
        EnumChecker.isValidEnum(OutboundStatus.class, newStatus, "Invalid outbound Status");

        OutboundOrder outboundOrder = getOutboundOrder(orderNumber);

        LocalDateTime currentTimestamp = LocalDateTime.now();

        switch (OutboundStatus.valueOf(newStatus)){
            case IN_PROGRESS -> setTransferInProgress(outboundOrder, currentTimestamp);
            case COMPLETED -> setTransferToComplete(outboundOrder, currentTimestamp);
            case INITIATED -> throw new ConflictException("Order already initiated");
        }
    }

    private OutboundOrder getOutboundOrder(Long orderNumber) {
        return outboundOrderRepository.findById(orderNumber).orElseThrow(
                () -> new NotFoundException("The outbound order with ID: " + orderNumber + " was not found")
        );
    }

    private void setTransferInProgress(OutboundOrder outboundOrder, LocalDateTime currentTimestamp){
        outboundOrder.setStatus(OutboundStatus.IN_PROGRESS);
        outboundOrder.setUpdatedAt(currentTimestamp);

        outboundOrderRepository.save(outboundOrder);
    }

    private void setTransferToComplete(OutboundOrder outboundOrder, LocalDateTime currentTimestamp) {
        outboundOrder.setStatus(OutboundStatus.COMPLETED);
        outboundOrder.setUpdatedAt(currentTimestamp);
        outboundOrderRepository.save(outboundOrder);


        List<TransferHistory> transfers = batchTransferHistoryRepository.findAllByOrderNumber(outboundOrder);


        for (TransferHistory transfer : transfers) {
            Batch batch = transfer.getBatch();
            Warehouse fromWarehouse = transfer.getFromWarehouse();
            Sector sector = fromWarehouse.getSectors().stream()
                    .filter(s -> s.getBatches().contains(batch))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Batch not found in any sector of the fromWarehouse"));

            // Desasigno el batch del sector del warehouse originario
            sector.getBatches().remove(batch);
            sector.setRemainingCapacity(sector.getRemainingCapacity() + 1);
            sectorRepository.save(sector);

            // Reasigno el batch al sector del toWarehouse
            Warehouse toWarehouse = transfer.getToWarehouse();
            Sector destinationSector = toWarehouse.getSectors().stream()
                    .filter(s -> s.getStorageType() == batch.getProduct().getStorageType())
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("No matching sector found in destination warehouse"));

            destinationSector.getBatches().add(batch);
            destinationSector.setRemainingCapacity(destinationSector.getRemainingCapacity() - 1);
            sectorRepository.save(destinationSector);

            transfer.setCompletedDate(currentTimestamp);
            batchTransferHistoryRepository.save(transfer);
        }

        Long inboundOrderNumber = generateUniqueInboundOrderNumber();
        InboundOrder inboundOrder = InboundOrder.builder()
                .orderNumber(inboundOrderNumber)
                .orderDate(LocalDate.now())
                .batches(transfers.stream().map(TransferHistory::getBatch).toList())
                .build();
        inboundOrderRepository.save(inboundOrder);

    }

    private Long generateUniqueInboundOrderNumber() {
        Optional<InboundOrder> lastInboundOrder = inboundOrderRepository.findTopByOrderByOrderNumberDesc();
        return lastInboundOrder.map(inboundOrder -> inboundOrder.getOrderNumber() + 1).orElse(1L);
    }
}
