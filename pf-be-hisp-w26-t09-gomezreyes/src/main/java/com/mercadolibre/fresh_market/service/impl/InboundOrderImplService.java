package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.config.BadRequestException;
import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderReqDTO;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.IInboundOrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InboundOrderImplService implements IInboundOrderService {

    final
    IInboundOrderRepository inboundOrderRepository;

    final
    IBatchRepository batchRepository;

    final
    IProductRepository productRepository;

    final
    ISectionRepository sectionRepository;

    final
    IWarehouseRepository warehouseRepository;

    final AuthService authService;

    public InboundOrderImplService(IInboundOrderRepository inboundOrderRepository, IBatchRepository batchRepository, IProductRepository productRepository, ISectionRepository sectionRepository, IWarehouseRepository warehouseRepository, AuthService authService) {
        this.inboundOrderRepository = inboundOrderRepository;
        this.batchRepository = batchRepository;
        this.productRepository = productRepository;
        this.sectionRepository = sectionRepository;
        this.warehouseRepository = warehouseRepository;
        this.authService = authService;
    }


    @Override
    public List<BatchDTO> createInboundOrder(InboundOrderReqDTO inboundOrderReqDTO) {

        if (inboundOrderReqDTO == null || inboundOrderReqDTO.getInboundOrderDTO() == null)
            throw new BadRequestException("The inbound order is null");

        InboundOrderDTO inboundOrderDTO = inboundOrderReqDTO.getInboundOrderDTO();

        Warehouse warehouse = warehouseRepository
                .findById(inboundOrderDTO.getSectionDTO().getWarehouseCode()).orElseThrow(
                        () -> new BadRequestException("The warehouse " + inboundOrderDTO.getSectionDTO().getWarehouseCode() + " dont exist"));

        Section section = sectionRepository.findById(inboundOrderDTO.getSectionDTO().getSectionCode())
                .orElseThrow(() -> new BadRequestException("The section " + inboundOrderDTO.getSectionDTO().getSectionCode() + " dont exist"));

        if (section.getWarehouse().getId() != inboundOrderDTO.getSectionDTO().getWarehouseCode())
            throw new BadRequestException("The section " + inboundOrderDTO.getSectionDTO().getSectionCode() + " is not valid");

        if (getUserId() != warehouse.getWarehouseman().getId())
            throw new BadRequestException("The user cannot create inbound order in this warehouse");

        InboundOrder inboundOrder = inboundOrderDTOtoInboundOrder(inboundOrderDTO);
        List<Batch> batchList = listBatchDTOtoListBatch(inboundOrderDTO);
        inboundOrder.setWarehouseman(warehouse.getWarehouseman());
        InboundOrder inboundOrderCreated = inboundOrderRepository.save(inboundOrder);
        for (Batch b : batchList) {
            b.setInboundOrder(inboundOrderCreated);
        }
        batchRepository.saveAll(batchList);
        inboundOrderCreated.setBatches(batchList);

        inboundOrderRepository.save(inboundOrderCreated);
        return batchList.stream().map(this::listBatchtoListBatchDTO).collect(Collectors.toList());
    }

    @Override
    public List<BatchDTO> updateInboundOrder(Long id, InboundOrderReqDTO inboundOrderReqDTO) {

        if (inboundOrderReqDTO == null || inboundOrderReqDTO.getInboundOrderDTO() == null)
            throw new BadRequestException("The inbound order is null");

        InboundOrderDTO inboundOrderDTO = inboundOrderReqDTO.getInboundOrderDTO();

        Warehouse warehouse = warehouseRepository.findById(inboundOrderDTO.getSectionDTO().getWarehouseCode()).get();
        if (warehouse == null)
            throw new BadRequestException("The warehouse " + inboundOrderDTO.getSectionDTO().getWarehouseCode() + " dont exist");

        Section section = sectionRepository.findById(inboundOrderDTO.getSectionDTO().getSectionCode()).get();
        if (section == null || section.getWarehouse().getId() != inboundOrderDTO.getSectionDTO().getWarehouseCode())
            throw new BadRequestException("The section " + inboundOrderDTO.getSectionDTO().getSectionCode() + " is not valid");

        if (getUserId() != warehouse.getWarehouseman().getId())
            throw new BadRequestException("The user cannot create inbound order in this warehouse");

        InboundOrder inboundOrder = inboundOrderDTOtoInboundOrder(inboundOrderDTO);
        inboundOrder.setId(id);
        List<Batch> batchList = listBatchDTOtoListBatch(inboundOrderDTO);
        batchList.forEach(batch -> batch.setInboundOrder(inboundOrder));
        inboundOrder.setBatches(batchList);
        inboundOrder.setWarehouseman(warehouse.getWarehouseman());
        InboundOrder inboundOrderUpdate = inboundOrderRepository.save(inboundOrder);
        return inboundOrderUpdate.getBatches().stream().map(this::listBatchtoListBatchDTO).toList();
    }

    public InboundOrder inboundOrderDTOtoInboundOrder(InboundOrderDTO inboundOrderDTO) {
        return InboundOrder.builder()
                .orderDate(inboundOrderDTO.getOrderDate())
                .orderNumber(inboundOrderDTO.getOrderNumber())
                .build();
    }

    public List<Batch> listBatchDTOtoListBatch(InboundOrderDTO inboundOrderDTO) {
        List<Batch> batchList = new ArrayList<>();
        Section section = sectionRepository.getOne(inboundOrderDTO.getSectionDTO().getSectionCode());
        for (BatchDTO b : inboundOrderDTO.getBatchStock()) {
            Product product = productRepository.getOne(b.getProductId());
            if (product == null) {
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

    public BatchDTO listBatchtoListBatchDTO(Batch b) {
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
