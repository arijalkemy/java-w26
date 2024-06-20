package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.config.BadRequestException;
import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.IInboundOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InboundOrderImpl implements IInboundOrder {

    @Autowired
    IInboundOrderRepository inboundOrderRepository;

    @Autowired
    IBatchRepository batchRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ISectionRepository sectionRepository;

    @Autowired
    IWarehouseRepository warehouseRepository;


    @Override
    public List<BatchDTO> createInboundOrder(InboundOrderDTO inboundOrderDTO) {
        Warehouse warehouse = warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode());
        if(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())==null){
            throw new BadRequestException("The warehouse "+inboundOrderDTO.getSectionDTO().getWarehouseCode()+" dont exist");
        }
        Section section = sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode());
        if(section.getWarehouse().getId() != inboundOrderDTO.getSectionDTO().getWarehouseCode() ){
            throw new BadRequestException("The section "+inboundOrderDTO.getSectionDTO().getSectionCode()+" is not valid");
        }
        if(getUserId() != warehouse.getWarehouseman().getId()){
            throw new BadRequestException("The user cannot create inbound order in this warehouse");
        }
        InboundOrder inboundOrder = inboundOrderDTOtoInboundOrder(inboundOrderDTO);
        List<Batch> batchList = listBatchDTOtoListBatch(inboundOrderDTO);
        InboundOrder inboundOrderCreated = inboundOrderRepository.save(inboundOrder);
        for(Batch b: batchList){
            b.setInboundOrder(inboundOrderCreated);
        }
        batchRepository.saveAll(batchList);
        inboundOrderCreated.setBatches(batchList);
        inboundOrderRepository.save(inboundOrderCreated);
        return batchList.stream().map(this::listBatchtoListBatchDTO).collect(Collectors.toList());
    }

    @Override
    public List<BatchDTO> updateInboundOrder(Long id, InboundOrderDTO inboundOrderDTO) {
        Warehouse warehouse = warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode());
        if(warehouseRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getWarehouseCode())==null){
            throw new BadRequestException("The warehouse "+inboundOrderDTO.getSectionDTO().getWarehouseCode()+" dont exist");
        }
        Section section = sectionRepository.getReferenceById(inboundOrderDTO.getSectionDTO().getSectionCode());
        if(section == null || section.getWarehouse().getId() != inboundOrderDTO.getSectionDTO().getWarehouseCode() ){
            throw new BadRequestException("The section "+inboundOrderDTO.getSectionDTO().getSectionCode()+" is not valid");
        }
        if(getUserId() != warehouse.getWarehouseman().getId()){
            throw new BadRequestException("The user cannot create inbound order in this warehouse");
        }
        InboundOrder inboundOrder = inboundOrderDTOtoInboundOrder(inboundOrderDTO);
        inboundOrder.setId(id);
        List<Batch> batchList = listBatchDTOtoListBatch(inboundOrderDTO);
        for(Batch b: batchList){
            b.setInboundOrder(inboundOrder);
        }
        inboundOrder.setBatches(batchList);
        InboundOrder inboundOrderUpdate = inboundOrderRepository.save(inboundOrder);
        return inboundOrderUpdate.getBatches().stream().map(this::listBatchtoListBatchDTO).collect(Collectors.toList());
    }

    public InboundOrder inboundOrderDTOtoInboundOrder(InboundOrderDTO inboundOrderDTO){
        return InboundOrder.builder()
                .orderDate(inboundOrderDTO.getOrderDate())
                .orderNumber(inboundOrderDTO.getOrderNumber())
                .build();
    }

    public List<Batch> listBatchDTOtoListBatch(InboundOrderDTO inboundOrderDTO){
        List<Batch> batchList = new ArrayList<>();
        Section section = sectionRepository.getOne(inboundOrderDTO.getSectionDTO().getSectionCode());
        for (BatchDTO b: inboundOrderDTO.getBatchStock()){
            Product product = productRepository.getOne(b.getProductId());
            if (product == null){
                throw new BadRequestException("Product not found");
            }
            batchList.add(Batch.builder()
                            .initialQuantity(b.getInitialQuantity())
                            .currentQuantity(b.getCurrentQuantity())
                            .dueDate(b.getDueDate())
                            .manufacturingDate(b.getManufacturingDate())
                            .manufacturingTime(b.getManufacturingTime())
                            .batchNumber(b.getBatchNumber())
                            .currentTemperature(b.getCurrentTemperature())
                            .minimumTemperature(b.getMinimumTemperature())
                            .product(product)
                            .section(section)
                    .build());
        }
        return batchList;
    }

    public BatchDTO listBatchtoListBatchDTO(Batch b){
        return BatchDTO.builder()
                .batchNumber(b.getBatchNumber())
                .productId(b.getProduct().getId())
                .currentTemperature(b.getCurrentTemperature())
                .minimumTemperature(b.getMinimumTemperature())
                .initialQuantity(b.getInitialQuantity())
                .currentQuantity(b.getCurrentQuantity())
                .manufacturingDate(b.getManufacturingDate())
                .manufacturingTime(b.getManufacturingTime())
                .dueDate(b.getDueDate())
                .build();
    }

    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails instanceof User) {
                return ((User) userDetails).getId();
            }
        }
        return null;
    }

}
