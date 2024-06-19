package com.mercadolibre.final_project_java_h_w26_t10.service.implementations;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchListProductDTO;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchStockDTO;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.SectorDTO;
import com.mercadolibre.final_project_java_h_w26_t10.entity.*;
import com.mercadolibre.final_project_java_h_w26_t10.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_h_w26_t10.service.IProductService;
import com.mercadolibre.final_project_java_h_w26_t10.service.ISearchService;
import com.mercadolibre.final_project_java_h_w26_t10.service.ISectorService;
import com.mercadolibre.final_project_java_h_w26_t10.service.IWarehouseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class SearchServiceImp implements ISearchService {

    private static final Integer WAREHOUSE_DEFAULT = 1;
    private static final String ORDER_BATCH = "L";
    private static final String ORDER_CURRENT_QUANTITY = "C";
    private static final String ORDER_DUE_DATE = "F";

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ISectorService sectorService;


    /**
     * Searches in the batches of a warehouse sector by default, containing the product and the order requested.
     * @param id
     * @param order
     * @return
     */
    @Override
    @Transactional
    public BatchListProductDTO searchProduct(Integer id, String order) {
        Product product = productService.findById(id);
        Warehouse warehouse = warehouseService.findById(WAREHOUSE_DEFAULT);
        Sector sector = sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(), warehouse);
        Set<Batch> batchList = searchProductBatchList(product.getId(), sector.getBatches());
        batchList = orderProductBatchList(batchList, order);
        return createResponseDTO(warehouse.getId(),sector.getId(),product.getId(),batchList);
    }

    /**
     * Search the batches for those containing the product using the parameter productId in batchList
     * @param productId
     * @param batchList
     * @return HashSet<Batch>
     */
    private HashSet<Batch> searchProductBatchList(Integer productId, Set<Batch> batchList) {
        LocalDate dateMinDue = LocalDate.now();
        dateMinDue.plusWeeks(3);
        HashSet<Batch> batches = new HashSet<>(
                batchList.stream().filter(
                        batch -> batch.getProduct().getId().equals(productId)
                                && batch.getDueDate().isAfter(dateMinDue)).toList());
        if (batches.isEmpty()) {
            throw new NotFoundException("Not found batch");
        }else{
            return batches;
        }
    }


    /**
     * Orders a batch set with the order parameter
     * @param batchList
     * @param order
     * @return
     */
    private Set<Batch> orderProductBatchList(Set<Batch> batchList, String order){
        if(order == null || order.equals(ORDER_BATCH)){
            return orderByBatchNumber(batchList);
        }else if(order.equals(ORDER_CURRENT_QUANTITY)){
            return orderByQuantity(batchList);
        } else if (order.equals(ORDER_DUE_DATE)) {
            return orderByDueDate(batchList);
        }else{
            throw new NotFoundException("Not Found order");
        }
    }

    /**
     * Implements order descent by batch due date
     * @param batchList
     * @return
     */
    private LinkedHashSet<Batch> orderByDueDate(Set<Batch> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getDueDate).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }

    /**
     * Implements order descent by current quantity of products on batch
     * @param batchList
     * @return
     */
    private LinkedHashSet<Batch> orderByQuantity(Set<Batch> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getCurrentQuantity).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }

    /**
     * Implements order descent by batch number
     * @param batchList
     * @return
     */
    private LinkedHashSet<Batch> orderByBatchNumber(Set<Batch> batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getBatchNumber).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }


    /**
     * Convert a batch set to List BacthStockDTO
     * @param batchList
     * @return
     */
    private List<BatchStockDTO> convertListBatchToStockDTO(Set<Batch> batchList) {
        return batchList.stream().map(this::convertBatchStockDTO).toList();
    }

    /**
     * Convert a batch to BacthStockDTO
     * @param batch
     * @return
     */
    private BatchStockDTO convertBatchStockDTO(Batch batch){
        return new BatchStockDTO(batch.getBatchNumber(), batch.getCurrentQuantity(), batch.getDueDate());
    }

    /**
     * Generate response dto for controller
     * @param warehouseId
     * @param sectorId
     * @param productId
     * @param batchList
     * @return
     */
    private BatchListProductDTO createResponseDTO(Integer warehouseId, Integer sectorId,
                                                  Integer productId, Set<Batch> batchList){
        BatchListProductDTO batchListProductDTO = new BatchListProductDTO();
        batchListProductDTO.setSection(new SectorDTO(sectorId, warehouseId));
        batchListProductDTO.setProduct_id(productId);
        batchListProductDTO.setBatch_stock(convertListBatchToStockDTO(batchList));

        return batchListProductDTO;
    }


}
