package com.mercadolibre.project_java_w26_team13.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.project_java_w26_team13.dtos.*;
import com.mercadolibre.project_java_w26_team13.dtos.projections.BatchDueDateOrderProjection;
import com.mercadolibre.project_java_w26_team13.dtos.projections.BatchDueDateProjection;
import com.mercadolibre.project_java_w26_team13.repository.IBatchRepository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_java_w26_team13.dtos.*;
import com.mercadolibre.project_java_w26_team13.entity.Batch;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import com.mercadolibre.project_java_w26_team13.exceptions.ApiException;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import com.mercadolibre.project_java_w26_team13.util.Helper;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.util.ArrayList;


@Service
public class BatchService implements IBatchService {

    @Autowired
    IBatchRepository batchRepository;

    @Autowired
    JWTClaims jwtClaimsUtils;

    @Autowired
    IProductRepository productRepository;

    private final ObjectMapper mapper;

    BatchService() {
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public ProductStockDto getProductStockByWarehouse(long productId, String authorizationHeader){
        jwtClaimsUtils.validateHeader(authorizationHeader, Roles.REPRESENTANTE.getRole());

        List<Batch> batchList = batchRepository.findAllByProductId(productId);

        if(batchList == null || batchList.isEmpty()){
            throw ExceptionsFactory.notFoundException("Batch list for product with id " + productId + " not found.");
        }

        Map<Integer, Integer> map = batchList.stream().collect(Collectors.groupingBy(b -> b.getOrder().getSection().getWarehouse().getCode(),
                                    Collectors.summingInt(Batch::getCurrentQuantity)
        ));
        List<WarehouseProductDto> warehouseProductDtoList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            warehouseProductDtoList.add(new WarehouseProductDto(entry.getKey(), entry.getValue()));
        }
        return new ProductStockDto(productId, warehouseProductDtoList);
    }

    @Override
    public BatchDueDateResponseDTO getBatchesDueDateByCategory(Integer days,
                                                               String authorizationHeader,
                                                               String categoryFilter,
                                                               String orderFilter) {

        if (!jwtClaimsUtils.validateRole(authorizationHeader, Roles.REPRESENTANTE.getRole())) {
            throw ExceptionsFactory.unauthorizedException("Invalid user role");
        }

        if (categoryFilter == null || orderFilter == null) {
            BatchDueDateResponseDTO batchDueDateResponseDTO = getBatchesDueDateCategoryFilter(days,
                    categoryFilter, orderFilter);
            return batchDueDateResponseDTO;
        }

        String category = Helper.validateCategoryFilter(categoryFilter);
        BatchDueDateResponseDTO batchDueDateResponseDTO = getBatchesDueDateCategoryFilter(days,
                category, orderFilter);

        return batchDueDateResponseDTO;
    }

    private BatchDueDateResponseDTO getBatchesDueDateCategoryFilter(Integer days,
                                                                   String categoryFilter,
                                                                   String orderFilter) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        BatchDueDateResponseDTO batchDueDateResponseDTO = new BatchDueDateResponseDTO();

        List<Batch> listBatch = batchRepository.findAllByDueDateBetween(today, futureDate);
        List<BatchDueDateDTO> listBatchDTO;

        if (categoryFilter == null || categoryFilter.isEmpty() || orderFilter == null){
            listBatchDTO = listBatch.stream()
                    .map(batch -> new BatchDueDateDTO(batch.getBatchNumber(),
                            batch.getCurrentQuantity(), batch.getProduct().getId().intValue(),
                            batch.getOrder().getSection().getId().intValue(),
                            batch.getDueDate())).collect(Collectors.toList());

            batchDueDateResponseDTO.setListBatchs(listBatchDTO);
            return batchDueDateResponseDTO;
        }


        listBatchDTO = listBatch.stream()
                .filter(x -> x.getOrder().getSection().getName()
                        .equalsIgnoreCase(categoryFilter))
                .map(batch -> new BatchDueDateDTO(batch.getBatchNumber(),
                        batch.getCurrentQuantity(), batch.getProduct().getId().intValue(),
                        batch.getOrder().getSection().getId().intValue(),
                        batch.getDueDate())).collect(Collectors.toList());

        if (orderFilter.equalsIgnoreCase("date_asc")) {
            listBatchDTO.sort(Comparator.comparing(BatchDueDateDTO::getDueDate));
        } else if (orderFilter.equalsIgnoreCase("date_desc")) {
            listBatchDTO.sort(Comparator.comparing(BatchDueDateDTO::getDueDate).reversed());
        }

        batchDueDateResponseDTO.setListBatchs(listBatchDTO);
        return batchDueDateResponseDTO;
    }

    @Override
    public BatchesByProductDTO searchBatchesByProduct(Long productId, String order, String authorizationHeader) throws ApiException {
        jwtClaimsUtils.validateHeader(authorizationHeader,  Roles.REPRESENTANTE.getRole());
        BatchesByProductDTO batchesByProductDTO = batchesByProductOrdered(searchBatchesByProduct(productId), order == null ? "" : order);
        return batchesByProductDTO;
    }

    private BatchesByProductDTO searchBatchesByProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw ExceptionsFactory.notFoundException(
                    "Batch list for product with id " + productId + " not found.");
        }
        List<Batch> batchesContainingProduct = batchRepository.findByProduct(product);

        BatchesByProductDTO batchesByProductDTOS = new BatchesByProductDTO();
        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        SectionDTO sectionDTO = new SectionDTO();
        for (Batch batch : batchesContainingProduct) {
            LocalDate minimumValidDueDate = LocalDate.now().plusWeeks(3);
            if (batch.getDueDate().isAfter(minimumValidDueDate)) {
                batchStock.add(
                        new MinimumBatchDTO(batch.getBatchNumber(), batch.getCurrentQuantity(),
                                batch.getDueDate()));
            }
        }

        if (batchStock.isEmpty()) {
            throw ExceptionsFactory.notFoundException(
                    "Batch list for product with id " + productId + " not found.");
        }

        sectionDTO.setId(batchesContainingProduct.get(0).getOrder().getSection().getId());
        sectionDTO.setWarehouse_id(
                batchesContainingProduct.get(0).getOrder().getSection().getWarehouse().getId());

        batchesByProductDTOS.setSection(sectionDTO);
        batchesByProductDTOS.setBatchStock(batchStock);
        batchesByProductDTOS.setProductId(productId);
        return batchesByProductDTOS;
    }

    private BatchesByProductDTO batchesByProductOrdered(BatchesByProductDTO batchesByProductDTO, String order) {
        BatchesByProductDTO batchesByProductDTOOrdered = new BatchesByProductDTO();
        batchesByProductDTOOrdered.setProductId(batchesByProductDTO.getProductId());
        batchesByProductDTOOrdered.setSection(batchesByProductDTO.getSection());
        switch (order) {
            case "":
                batchesByProductDTOOrdered.setBatchStock(batchesByProductDTO.getBatchStock());
                break;
            case "L":
                batchesByProductDTOOrdered.setBatchStock(batchesByProductDTO.getBatchStock().stream().sorted(Comparator.comparing(MinimumBatchDTO::getBatchNumber)).toList());
                break;
            case "C":
                batchesByProductDTOOrdered.setBatchStock(batchesByProductDTO.getBatchStock().stream().sorted(Comparator.comparing(MinimumBatchDTO::getCurrentQuantity)).toList());
                break;
            case "F":
                batchesByProductDTOOrdered.setBatchStock(batchesByProductDTO.getBatchStock().stream().sorted(Comparator.comparing(MinimumBatchDTO::getDueDate)).toList());
                break;
            default:
                throw ExceptionsFactory.invalidOrderParameter("Invalid order parameter.");
        }
        return batchesByProductDTO;
    }
}
