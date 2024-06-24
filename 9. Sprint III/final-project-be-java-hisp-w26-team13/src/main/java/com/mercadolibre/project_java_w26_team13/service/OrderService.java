package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.request.BatchStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.OrderRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.SectionDto;
import com.mercadolibre.project_java_w26_team13.dtos.response.BatcheStockDTO;
import com.mercadolibre.project_java_w26_team13.entity.*;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.*;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final ModelMapper modelMapper;
    IOrderRepository iOrderRepository;
    private final IBatchRepository batchRepository;
    private final IProductRepository productRepository;
    private final ISectionRepository sectionRepository;
    private final IWarehouseRepository warehouseRepository;
    JWTClaims jwtClaimsUtils;


    public OrderService(ModelMapper modelMapper,
                        IOrderRepository iOrderRepository,
                        IBatchRepository batchRepository,
                        IProductRepository productRepository,
                        ISectionRepository sectionRepository,
                        IWarehouseRepository warehouseRepository,
                        JWTClaims jwtClaimsUtils) {
        this.modelMapper = modelMapper;
        this.iOrderRepository = iOrderRepository;
        this.batchRepository = batchRepository;
        this.productRepository = productRepository;
        this.sectionRepository = sectionRepository;
        this.warehouseRepository = warehouseRepository;
        this.jwtClaimsUtils = jwtClaimsUtils;
    }

    @Override
    public List<BatchStockDto> registerBatch(OrderRequestDto orderRequestDto, String authorizationHeader) {

        if (!jwtClaimsUtils.validateRole(authorizationHeader, Roles.REPRESENTANTE.getRole())) {
            throw ExceptionsFactory.unauthorizedException("Invalid user role");
        }

        //Verifica que la orden no exista
        Order orderExist = iOrderRepository.findByOrderNumber(orderRequestDto.getOrderNumber());
        if (orderExist != null) {
            throw ExceptionsFactory.badRequestException("Order with ID " + orderRequestDto.getOrderNumber() + " already exists in the database");
        }

        SectionDto orderSection = orderRequestDto.getSection();
        Long inboundSectionCode = orderSection.getSectionCode();

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(orderSection.getWarehouseCode());
        if (warehouseOptional.isEmpty()) {
            throw ExceptionsFactory.notFoundException("Warehouse with ID " + orderSection.getWarehouseCode() + " does not exist in the database");
        }
        Warehouse warehouseOrder = warehouseOptional.get();
        // Verfifica si ese warehouse tiene secciones
        if(!sectionRepository.existsByWarehouseId(warehouseOrder.getId())) {
        throw ExceptionsFactory.notFoundException("Warehouse with ID " + orderSection.getWarehouseCode() + " does not have any section");
        }

        // Verificar que el sector es válido
        Optional<Section> sectionOptional = sectionRepository.findById(inboundSectionCode);
        if (sectionOptional.isEmpty()) {
            throw ExceptionsFactory.notFoundException("Section with ID " + inboundSectionCode + " does not exist in the database");
        }
        Section sectionOrder = sectionOptional.get();

        for (BatchStockDto batch : orderRequestDto.getBatch()) {
            Long productId = batch.getProductId();
            //el producto de un Sellers está registrado
            Optional<Product> productOptional = productRepository.findById(productId);
            if (productOptional.isEmpty()) {
                throw ExceptionsFactory.notFoundException("Product with ID " + productId + " does not exist in the database");
            }

        }

        Order order = new Order();
        order.setOrderNumber(orderRequestDto.getOrderNumber());
        order.setOrderDate(orderRequestDto.getOrderDate());
        //lote es asignado a un sector
        order.setSection(sectionOrder);

        iOrderRepository.save(order);

        for (BatchStockDto batchDto : orderRequestDto.getBatch()) {
            Batch batch = new Batch();
            batch.setBatchNumber(batchDto.getBatchNumber().toString());

            batch.setProduct(productRepository.findById(batchDto.getProductId()).orElse(null));

            batch.setCurrentTemperature(batchDto.getCurrentTemperature());
            batch.setMinimumTemperature(batchDto.getMinimumTemperature());

            batch.setInitialQuantity(batchDto.getInitialQuantity());
            batch.setCurrentQuantity(batchDto.getCurrentQuantity());

            batch.setManufacturingDate(batchDto.getManufacturingDate());
            batch.setManufacturingTime(batchDto.getManufacturingTime());
            batch.setDueDate(batchDto.getDueDate());

            Order orderRelation = iOrderRepository.findInboundOrderByOrderNumber(order.getOrderNumber());
            batch.setOrder(orderRelation);

            batchRepository.save(batch);
        }

        List<BatchStockDto> responseDto = orderRequestDto.getBatch();

        return responseDto;
    }

    @Override
    public BatcheStockDTO updateInboundOrder(OrderRequestDto orderRequestDto, String authorizationHeader) {

        if (!jwtClaimsUtils.validateRole(authorizationHeader, Roles.REPRESENTANTE.getRole())) {
            throw ExceptionsFactory.unauthorizedException("Invalid user role");
        }

        //Verfificar que la orden exista
        Order order = iOrderRepository.findByOrderNumber(orderRequestDto.getOrderNumber());
        if (order == null) {
            throw ExceptionsFactory.notFoundException("Order with ID " + orderRequestDto.getOrderNumber() + " does not exist in the database");
        }
        order.setOrderNumber(orderRequestDto.getOrderNumber());
        order.setOrderDate(orderRequestDto.getOrderDate());

        SectionDto orderSection = orderRequestDto.getSection();
        Long inboundSectionCode = orderSection.getSectionCode();

        //Y que el warehouse es válido
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(orderSection.getWarehouseCode());
        if (warehouseOptional.isEmpty()) {
        throw ExceptionsFactory.notFoundException("Warehouse with ID " + orderSection.getWarehouseCode() + " does not exist in the database");
        }
        Warehouse warehouseOrder = warehouseOptional.get();
        //Verfifica si ese warehouse tiene secciones
        if(!sectionRepository.existsByWarehouseId(warehouseOrder.getId())) {
            throw  ExceptionsFactory.notFoundException("Warehouse with ID " + orderSection.getWarehouseCode() + " does not have any section");
        }

        // Verificar que el sector es válido
        Optional<Section> sectionOptional = sectionRepository.findById(inboundSectionCode);
        if (sectionOptional.isEmpty()) {
            throw ExceptionsFactory.notFoundException("Section with ID " + inboundSectionCode + " does not exist in the database");
        }
        Section sectionOrder = sectionOptional.get();

        for (BatchStockDto batch : orderRequestDto.getBatch()) {
            Long productId = batch.getProductId();
            //el producto de un Sellers está registrado
            Optional<Product> productOptional = productRepository.findById(productId);
            if (productOptional.isEmpty()) {
                throw ExceptionsFactory.notFoundException("Product with ID " + productId + " does not exist in the database");
            }
        }

        //lote es asignado a un sector
        order.setSection(sectionOrder);

        iOrderRepository.save(order);

        for (BatchStockDto batchDto : orderRequestDto.getBatch()) {
            Batch batch = new Batch();
            batch.setBatchNumber(batchDto.getBatchNumber().toString());

            batch.setProduct(productRepository.findById(batchDto.getProductId()).orElse(null));

            batch.setCurrentTemperature(batchDto.getCurrentTemperature());
            batch.setMinimumTemperature(batchDto.getMinimumTemperature());

            batch.setInitialQuantity(batchDto.getInitialQuantity());
            batch.setCurrentQuantity(batchDto.getCurrentQuantity());

            batch.setManufacturingDate(batchDto.getManufacturingDate());
            batch.setManufacturingTime(batchDto.getManufacturingTime());
            batch.setDueDate(batchDto.getDueDate());

            batch.setOrder(order);

            batchRepository.save(batch);
        }

        Order orderUpdated = iOrderRepository.findByOrderNumber(orderRequestDto.getOrderNumber());
        List<BatchStockDto> responseDto = new ArrayList<>();

        //mapear cada elemento de la lista
        orderUpdated.getBatchs().stream().forEach(batchStockDto -> {
            BatchStockDto batchStockDto1 = modelMapper.map(batchStockDto, BatchStockDto.class);
            responseDto.add(batchStockDto1);
        });
        BatcheStockDTO response = new BatcheStockDTO(responseDto);

        return response;
    }
}
