package com.mercadolibre.fresh_market.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.config.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.dtos.*;
import com.mercadolibre.fresh_market.exceptions.ApiException;
import com.mercadolibre.fresh_market.exceptions.UnauthorizedAccessException;
import com.mercadolibre.fresh_market.model.Batch;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements IBatchService {

    @Autowired
    IBatchRepository batchRepository;

    private final AuthService authService;

    @Autowired
    WarehouseServiceImpl warehouseServiceImpl;

    public BatchServiceImpl(AuthService authService, WarehouseServiceImpl warehouseServiceImpl,
                            ObjectMapper objectMapper) {
        this.authService = authService;
        this.warehouseServiceImpl = warehouseServiceImpl;
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ROLE_WAREHOUSEMAN')")
    public ExpiringProductResponseDTO getBatchesExpiringSoon(Integer countDays) {

        List<Batch> batches = getBatchesExpiring(getWarehouseId(), countDays);
        if (batches == null || batches.isEmpty()) {
            return new ExpiringProductResponseDTO();
        }

        List<ExpiringProductDTO> expiringProducts = batches.stream().map(batch ->
                ExpiringProductDTO.builder()
                        .batchNumber(batch.getBatchNumber())
                        .productId(batch.getProduct().getId())
                        .productTypeId(batch.getSection().getCategory().getId())
                        .dueDate(batch.getDueDate())
                        .currentQuantity(batch.getCurrentQuantity())
                        .build()
        ).toList();
        return new ExpiringProductResponseDTO(expiringProducts);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_WAREHOUSEMAN')")
    public ExpiringProductResponseDTO getBatchesExpiringSoonByCategoryAndOrder(Integer countDays,
                                                                               String category, String order) {
        if (!"date_asc".equals(order) && !"date_desc".equals(order)) {
            throw new ApiException("Invalid order parameter", "The order parameter must be 'date_asc' or 'date_desc'",
                    HttpStatus.BAD_REQUEST.value());

        }
        List<Batch> batches = getBatchesExpiring(getWarehouseId(), countDays)
                .stream()
                .filter(batch -> batch.getSection().getCategory().toString().equals(category))
                .sorted("date_asc".equals(order) ? Comparator.comparing(Batch::getDueDate) : Comparator.comparing(Batch::getDueDate).reversed())
                .toList();

        if (batches == null || batches.isEmpty()) {
            return new ExpiringProductResponseDTO();
        }

        List<ExpiringProductDTO> expiringProducts = batches.stream().map(batch ->
                ExpiringProductDTO.builder()
                        .batchNumber(batch.getBatchNumber())
                        .productId(batch.getProduct().getId())
                        .productTypeId(batch.getSection().getCategory().getId())
                        .dueDate(batch.getDueDate())
                        .currentQuantity(batch.getCurrentQuantity())
                        .build()
        ).toList();


        return new ExpiringProductResponseDTO(expiringProducts);
    }

    private List<Batch> getBatchesExpiring(Long warehouseId, Integer countDays) {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(countDays);
        return batchRepository.findBatchesExpiringSoon(warehouseId, startDate, endDate);
    }

    private Long getWarehouseId() {
        Long id = authService.getUserId();
        WarehouseDTO warehouse = warehouseServiceImpl.getWarehouseByWarehousemanId(id);
        return warehouse.getId();
    }

    @PreAuthorize("hasRole('ROLE_WAREHOUSEMAN')")
    public BatchLocationResponseDTO getBatchByProductId(Long idProduct) {

        List<Batch> batchList = batchRepository.findByProductId(idProduct);
        BatchLocationResponseDTO batchLocationResponseDTO = new BatchLocationResponseDTO();

        if (!batchList.isEmpty()) {

            Batch firstBatch = batchList.get(0);

            Long warehouseId;
            try {
                warehouseId = getWarehouseId();
            } catch (NullPointerException e) {
                throw new UnauthorizedAccessException("No associated warehouses found");
            }


            if (!Objects.equals(firstBatch.getSection().getWarehouse().getId(), warehouseId)) {
                throw new UnauthorizedAccessException("You don't have permissions to access this warehouse");
            }

            LocalDate currentDate = LocalDate.now();

            List<Batch> validBatches = batchList.stream()
                    .filter(batch -> batch.getDueDate() == null || currentDate.isBefore(batch.getDueDate().minusWeeks(3)))
                    .toList();

            if (validBatches.isEmpty()) {
                throw new ProductNotFoundException("Product is not available");
            }

            SectionResponseDTO sectionResponseDTO = new SectionResponseDTO();
            sectionResponseDTO.setSectionCode(firstBatch.getSection().getId());
            sectionResponseDTO.setWarehouseCode(firstBatch.getSection().getWarehouse().getId());

            batchLocationResponseDTO.setSection(sectionResponseDTO);

            batchLocationResponseDTO.setProductId(idProduct);

            List<BatchResponseDTO> batchResponseDTOList = validBatches.stream()
                    .map(batch -> {
                        BatchResponseDTO batchResponseDTO = new BatchResponseDTO();
                        batchResponseDTO.setBatchNumber(batch.getBatchNumber());
                        batchResponseDTO.setCurrentQuantity(batch.getCurrentQuantity());
                        batchResponseDTO.setDueDate(batch.getDueDate());
                        return batchResponseDTO;
                    })
                    .collect(Collectors.toList());

            batchLocationResponseDTO.setBatchStock(batchResponseDTOList);
        } else {
            throw new ProductNotFoundException("Product is not available");
        }

        return batchLocationResponseDTO;
    }

    @PreAuthorize("hasRole('ROLE_WAREHOUSEMAN')")
    public BatchLocationResponseDTO getBatchByProductIdOrdered(Long idProduct, String order) {
        BatchLocationResponseDTO batchLocationResponseDTO = getBatchByProductId(idProduct);

        switch (order) {
            case "L":
                batchLocationResponseDTO.getBatchStock().sort(Comparator.comparing(BatchResponseDTO::getBatchNumber));
                break;
            case "C":
                batchLocationResponseDTO.getBatchStock().sort(Comparator.comparing(BatchResponseDTO::getCurrentQuantity));
                break;
            case "F":
                batchLocationResponseDTO.getBatchStock().sort(Comparator.comparing(BatchResponseDTO::getDueDate));
                break;
            default:
                throw new IllegalArgumentException("Invalid order parameter");
        }

        return batchLocationResponseDTO;
    }
}
