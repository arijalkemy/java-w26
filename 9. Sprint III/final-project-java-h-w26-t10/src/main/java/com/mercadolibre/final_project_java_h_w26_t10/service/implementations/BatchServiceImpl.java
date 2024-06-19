package com.mercadolibre.final_project_java_h_w26_t10.service.implementations;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchesCloseToExpireDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.UploadBatchRequestDto;
import com.mercadolibre.final_project_java_h_w26_t10.entity.*;
import com.mercadolibre.final_project_java_h_w26_t10.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_h_w26_t10.repository.*;
import com.mercadolibre.final_project_java_h_w26_t10.service.IBatchService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BatchServiceImpl implements IBatchService {

    @Autowired
    IBatchRepository batchRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private ISectorRepository sectorRepository;

    @Autowired
    private IInboundOrderRepository inboundOrderRepository;

    @Override
    @Transactional
    public List<BatchesCloseToExpireDto> getBatchesExpiringInDays(Integer days) {
        LocalDate actualDate = LocalDate.now();
        LocalDate limitDate = actualDate.plusDays(days);
        List<Batch> batchesExpiringInDays = batchRepository.findByDueDateBetween(actualDate, limitDate);
        if (batchesExpiringInDays.isEmpty()) {
            throw new NotFoundException("No hay lotes que expiren en los proximos " + days + " dias");
        }
        return mapBatchesToDto(batchesExpiringInDays);
    }

    @Override
    @Transactional
    public List<BatchesCloseToExpireDto> findBatchesByDueDateAndCategory(Integer days, String category, String order) {
        if(order == null && category == null){
            return getBatchesExpiringInDays(days);
        }
        LocalDate actualDate = LocalDate.now();
        LocalDate limitDate = actualDate.plusDays(days);
        List<Batch> batchesExpiringInDaysOrdered;

        switch (order.toUpperCase()) {
            case "DESC":
                batchesExpiringInDaysOrdered = batchRepository.findBatchesByDueDateAndCategoryDesc(actualDate, limitDate, category);
                break;
            default:
                batchesExpiringInDaysOrdered = batchRepository.findBatchesByDueDateAndCategoryAsc(actualDate, limitDate, category);
        }


        return mapBatchesToDto(batchesExpiringInDaysOrdered);
    }

    private List<BatchesCloseToExpireDto> mapBatchesToDto(List<Batch> batches) {
        return batches.stream()
                .map(b -> new BatchesCloseToExpireDto(
                        b.getBatchNumber(),
                        b.getProduct().getId(),
                        b.getCurrentQuantity(),
                        b.getDueDate()))
                .toList();
    }

    private void setDataToBatch(Batch myBatch, BatchDto b, InboundOrder newInboundOrder, Optional<Sector> posibleSector) {
        myBatch.setBatchNumber(b.getBatchNumber());
        myBatch.setCurrentQuantity(b.getCurrentQuantity());
        myBatch.setInitialQuantity(b.getInitialQuantity());
        myBatch.setCurrentTemperature(b.getCurrentTemperature());
        myBatch.setDueDate(b.getDueDate());
        myBatch.setInbound(newInboundOrder);
        myBatch.setManufacturingDate(b.getManufacturingDate());
        myBatch.setManufacturingTime(b.getManufacturingTime());
        myBatch.setMinimumTemperature(b.getMinimumTemperature());

        Integer idProduct =  b.getProduct_id();
        Optional<Product> realProduct = productRepository.findById(idProduct);
        myBatch.setProduct(realProduct.get());
        myBatch.setSector(posibleSector.get());

        batchRepository.save(myBatch);
    }

    /**
     * Method to update the batch in the stcok
     * @param uploadBatchRequestDto Request required to update the stock
     * @return We return the stock updated
     */
    @Override
    public BatchResponseDto updateBatchInStock(UploadBatchRequestDto uploadBatchRequestDto) {
        Integer sectionCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getSectionCode();
        Optional<Sector> posibleSector = sectorRepository.findById(sectionCode);


        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            // Veryfing evry batch in the request, just to stay sure
            Batch myBatch = batchRepository.findBatchByBatchNumber(b.getBatchNumber());

            if (myBatch == null){
                throw new NotFoundException("Error no existe el batch con id: " + b.getBatchNumber());
            }

            setDataToBatch(myBatch, b, myBatch.getInbound(), posibleSector);

        }

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(uploadBatchRequestDto.getInboundOrderDto().getBatchDto());
        return responseDto;
    }

    /**
     * Method to upload the batch into the stock
     * @param uploadBatchRequestDto request to have the specific information to load the data and make validations
     * @return We return a BatchResponseDto with the specific data to show the information to the user
     */
    @Override
    public BatchResponseDto uploadBatchIntoStock(UploadBatchRequestDto uploadBatchRequestDto) {
        //Validating if the sector exist
        Integer sectionCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getSectionCode();
        Optional<Sector> posibleSector = sectorRepository.findById(sectionCode);
        if (!posibleSector.isPresent()){
            throw new NotFoundException("Error no hay sector con ese id");
        }

        // Validating if the product exist
        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            Integer idProduct =  b.getProduct_id();
            Optional<Product> posibleProduct = productRepository.findById(idProduct);

            if (!posibleProduct.isPresent()) {
                throw new NotFoundException("Error no existe el producto con id: " + idProduct);
            }

            //Validating if the sector is the correct to the product

            if (!Objects.equals(posibleProduct.get().getCategory().getId(), posibleSector.get().getCategory().getId())) {
                throw new NotFoundException("Error, el sector y el producto deben pertenecer a la misma categoria");
            }
        }

        //validating if the warehouse exist
        Integer warehouseCode = uploadBatchRequestDto.getInboundOrderDto().getSectionDto().getWarehouseCode();
        Optional<Warehouse> posibleWarehouse = warehouseRepository.findById(warehouseCode);
        if (!posibleWarehouse.isPresent()) {
            throw new NotFoundException("Error no existe el warehouse");
        }

        // Creating the new inbound order
        InboundOrder newInboundOrder = new InboundOrder();
        newInboundOrder.setOrderNumber(uploadBatchRequestDto.getInboundOrderDto().getOrderNumber());
        newInboundOrder.setWarehouse(posibleWarehouse.get());
        inboundOrderRepository.save(newInboundOrder);

        // Creatin the batch of the product

        for (BatchDto b : uploadBatchRequestDto.getInboundOrderDto().getBatchDto()) {
            Batch theNewBatch = new Batch();

            setDataToBatch(theNewBatch, b, newInboundOrder, posibleSector);

        }

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(uploadBatchRequestDto.getInboundOrderDto().getBatchDto());
        return responseDto;
    }
}
