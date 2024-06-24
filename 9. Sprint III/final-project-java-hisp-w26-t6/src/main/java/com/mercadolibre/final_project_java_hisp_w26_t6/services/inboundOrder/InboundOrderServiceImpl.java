package com.mercadolibre.final_project_java_hisp_w26_t6.services.inboundOrder;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchInsertionRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchInsertionResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.SectionDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Sector;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Warehouse;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.BadRequestException;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.BatchMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.InboundOrderMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IBatchesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IInboundOrderRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IProductsRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IWarehousesRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InboundOrderServiceImpl implements IInboundOrderService {

    private final IBatchesRepository batchesRepository;
    private final IWarehousesRepository warehouseRepository;
    private final IProductsRepository productsRepository;
    private final IInboundOrderRepository orderRepository;

    public InboundOrderServiceImpl(IBatchesRepository batchesRepository, IWarehousesRepository warehouseRepository,
                                   IProductsRepository productsRepository, IInboundOrderRepository orderRepository) {
        this.batchesRepository = batchesRepository;
        this.warehouseRepository = warehouseRepository;
        this.productsRepository = productsRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public BatchInsertionResponseDto insertBatchInFulfillmentWarehouse(BatchInsertionRequestDto requestDto,
                                                                       boolean update) {

        SectionDto sectionDto = requestDto.getInboundOrderRequestDto().getSection();

        Warehouse warehouse = warehouseRepository.findById(sectionDto.getWarehouseCode()).orElseThrow(
                () -> new NotFoundException("Warehouse doesn't exist")
        );

        verifyAccessWarehouse(warehouse);

        Sector sector = verifySector(warehouse, requestDto);

        List<BatchDto> batchesDtos = requestDto.getInboundOrderRequestDto().getBatchStock();
        for (BatchDto batchDto : batchesDtos) {
            Integer productId = batchDto.getProductId();
            Product product = productsRepository.findById(Long.valueOf(productId)).orElseThrow(
                    () -> new NotFoundException("Product doesn't exist")
            );

            boolean existBatch = sector.getBatches()
                    .stream()
                    .anyMatch(b -> b.getBatchNumber().equals(batchDto.getBatchNumber()));
            if(update && !existBatch) {
                throw new NotFoundException("Batch doesn't exist");
            }

            if(!product.getStorageType().equals(sector.getStorageType())) {
                throw new NotFoundException("Wrong storage type. Sector storage type: " + sector.getSectorCode()
                        + " Product storage type: " + product.getStorageType());
            }
        }

        List<Batch> batches = saveBatches(batchesDtos);

        sector.setRemainingCapacity(sector.getRemainingCapacity() -
                requestDto.getInboundOrderRequestDto().getBatchStock().size());
        sector.getBatches().addAll(batches);

        saveInboundOrder(Long.valueOf(requestDto.getInboundOrderRequestDto().getOrderNumber()),
                requestDto.getInboundOrderRequestDto().getOrderDate(),
                batches);

        return BatchMapper.batchInsertionRequestDtoToBatchInsertionResponseDto(requestDto);
    }


    private void verifyAccessWarehouse(Warehouse warehouse) {
        var userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!warehouse.getSupervisor().getUsername().equals(userDetails)) {
            throw new BadRequestException("Supervisor don't have access to the warehouse");
        }
    }

    private Sector verifySector(Warehouse warehouse, BatchInsertionRequestDto requestDto) {
        return warehouse.getSectors().stream()
                .filter(s -> s.getSectorCode().equals(requestDto
                        .getInboundOrderRequestDto()
                        .getSection()
                        .getSectionCode()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Sector doesn't exist"));
    }

    private List<Batch> saveBatches(List<BatchDto> batchesDto) {
        List<Batch> batches = new ArrayList<>();
        for (BatchDto batchDto : batchesDto) {
            Batch existingBatch = batchesRepository.findByBatchNumber(batchDto.getBatchNumber());
            if(existingBatch == null) {
                batches.add(BatchMapper.batchDtoToBatch(batchDto));
            } else {
                Batch updatedBatch = BatchMapper.updateBatchDtoToBatch(existingBatch, batchDto);
                batches.add(updatedBatch);
            }
        }
        return batches;
    }

    private void saveInboundOrder(Long orderNumber, String orderDate, List<Batch> batches) {
        orderRepository.save(InboundOrderMapper.createInboundOrder(orderNumber, orderDate, batches));
    }
}
