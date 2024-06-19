package com.mercadolibre.sprint_3_team_12_malacara.service;

import com.mercadolibre.sprint_3_team_12_malacara.dto.response.BatchDueDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseBatchDueDTO;
import com.mercadolibre.sprint_3_team_12_malacara.entity.User;
import com.mercadolibre.sprint_3_team_12_malacara.entity.Warehouse;
import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;
import com.mercadolibre.sprint_3_team_12_malacara.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IBatchStockRepository;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IUserRepository;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IWarehouseRepository;
import com.mercadolibre.sprint_3_team_12_malacara.dto.SectionDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseBatchDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.WarehouseDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint_3_team_12_malacara.entity.Product;
import com.mercadolibre.sprint_3_team_12_malacara.projections.BatchStockProjection;
import com.mercadolibre.sprint_3_team_12_malacara.projections.SectionProjection;
import com.mercadolibre.sprint_3_team_12_malacara.projections.WarehouseProjection;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IProductRepository;
import com.mercadolibre.sprint_3_team_12_malacara.repository.ISectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class BatchService implements IBatchService {
    @Autowired
    IWarehouseRepository warehouseRepository;
  
    @Autowired
    IBatchStockRepository batchStockRepository;

    @Autowired
    ISectionRepository sectionRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IUserRepository userRepository;

    /*ADDING Structure POST MERGE

    private User getUserFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userRepository.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new ApiException(
                        "User not found",
                        "User with username " + currentPrincipalName + " not found",
                        HttpStatus.NOT_FOUND.value()));
    }

    private void ValidateAccessWarehouse(Long warehouseId, User userAutenticated) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new ApiException(
                        "Warehouse not found",
                        "Warehouse with id " + warehouseId + " not found or user does not have access",
                        HttpStatus.NOT_FOUND.value()));
        if (warehouse.getPeople()
                .stream().filter(user -> user.getId().equals(userAutenticated.getId())).findFirst().isEmpty())
            throw new ApiException("Forbidden", "The user haven't access to the warehouse ", 403);
    }

     */

    @Override
    public ResponseBatchDueDTO getDueBatchesByDays(Integer days) {
        Long warehouseId = 1L; //In this sprint only works with the warehouse 1. In a future can change.
        /* Implementation needed post SecurityUpdate
        User userAutenticated = getUserFromAuthentication();
        ValidateAccessWarehouse(warehouseId,userAutenticated);
        */
        LocalDate today = LocalDate.now(); //Get actual date
        //Request to repository or Data, obtained like Dto
        List<BatchDueDTO> list = batchStockRepository
                .findProductsBetweenDate(warehouseId, Date.valueOf(today), Date.valueOf(today.plusDays(days)));
        if (list.isEmpty()) {
            throw new ApiException("Not Found", "Product to expire in the indicates days not exist in this Warehouse", HttpStatus.NOT_FOUND.value());
        }
        return new ResponseBatchDueDTO(list);
    }

    /**
     * Retrieves the warehouse stock information for a given product ordered by type
     * @param id - The ID of the product to find the stock information
     * @param order - The order of BatchStock list.
     * @throws com.mercadolibre.sprint_3_team_12_malacara.exceptions.ApiException - If an exception occurs while retrieving the
     * warehouse information
     */
    @Override
    public WarehouseStockDTO getWarehouseStockByProductIDOrdered(Long id, String order) {
        WarehouseStockDTO warehouseStock = getWarehouseStockByProductID(id);

        if (order != null) {
            List<ResponseBatchDTO> sortedResponseBatch = warehouseStock.getBatchDTOList().stream()
                    .sorted(getComparatorForOrder(order))
                    .collect(Collectors.toList());

            warehouseStock.setBatchDTOList(sortedResponseBatch);
        }

        return warehouseStock;
    }

    /**
     * Inner function to retrieve a comparator for the ResponseBatchDTO based on a String order
     * @param order
     * @return
     */
    private Comparator<ResponseBatchDTO> getComparatorForOrder(String order) {
        switch (order) {
            case "L":
                return Comparator.comparing(ResponseBatchDTO::getIdBatch);
            case "C":
                return Comparator.comparing(ResponseBatchDTO::getCurrentQuantity);
            case "F":
                return Comparator.comparing(ResponseBatchDTO::getDueDate);
            default:
                throw new ApiException("Not Supported"
                        ,"The type of order you provide is not supported or is not identified"
                        , HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value());
        }
    }

    /**
     * Retrieves single warehouse stock information for a given product ID. US = 08
     *
     * @author Mau
     * @param id The ID of the product for which the warehouse stock information is requested.
     * @return A WarehouseStockDTO containing the warehouse section and batch stock information for the specified product.
     * @throws RuntimeException If an exception occurs while retrieving the warehouse stock information.
     */
    @Override
    public WarehouseStockDTO getWarehouseStockByProductID(Long id){

        //Authentication and extracting user data

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new ApiException(
                        "User not found",
                        "User with username " + userName + " not found",
                        org.springframework.http.HttpStatus.NOT_FOUND.value()));

        //Extracting corresponding warehouse for user
        Warehouse userWareHouse = userRepository.findWarehousesByUserId(user.getId()).get(0);

        //Product existence and validation
        Product product = productRepository.findById(id).orElseThrow(() -> new ApiException("NotFound", "Product not found", HttpStatus.NOT_FOUND.value()));

        // Obtaining section info
        SectionProjection sectionProjection = sectionRepository.findSectionByProductIdAndWarehouseId(id, userWareHouse.getId()).orElseThrow(() -> new ApiException("NotFound", "Product not found", HttpStatus.NOT_FOUND.value()));
        SectionDTO sectionDTO = sectionProjectionToSectionDTO(sectionProjection, userWareHouse.getId().intValue());

        //Getting batchProjection and managing exceptions
        List<ResponseBatchDTO> batchStockDtoList = batchStockRepository.findByProductIDAndWareHouseID(id, userWareHouse.getId()).stream()
                .map(this::batchProjectionToBatchDto)
                .toList();

        if(batchStockDtoList.isEmpty()){
            throw new ApiException("NotFounddException", "Batch not found in database", HttpStatus.NOT_FOUND.value());
        }

        // Merging data
        return  WarehouseStockDTO.builder().sectionDTO(sectionDTO).batchDTOList(batchStockDtoList).idProduct(product.getId().intValue()).build();
    }

    /**
     * Retrieves all warehouse stock information for a given product ID. US-10
     *
     * @author Mau
     * @param id The ID of the product for which the warehouse stock information is requested.
     * @return A WarehouseStockDTO containing the warehouse section and batch stock information for the specified product.
     * @throws ApiException If an exception occurs while retrieving the warehouse stock information.
     */
    @Override
    public AllWarehousesDTO getAllWarehousesByProductID(Long id){

        //Product existence and validation
        Product product = productRepository.findById(id).orElseThrow(() -> new ApiException("NotFound", "Product not found", HttpStatus.NOT_FOUND.value()));

        //warehouse validation
        List<WarehouseDTO> warehouseDTOList = batchStockRepository.findWarehouseStockByProductId(product.getId()).stream().map(this::warehouseProjectionToWarehouseDTO).toList();
        if (warehouseDTOList.isEmpty()){
            throw new ApiException("NotFounddException", "Warehouse list not having any product", HttpStatus.NOT_FOUND.value());
        }

        return new AllWarehousesDTO(id.intValue(), warehouseDTOList);
    }

    private ResponseBatchDTO batchProjectionToBatchDto(BatchStockProjection batchProjection){
        return new ResponseBatchDTO(
                batchProjection.id().intValue(),
                batchProjection.currentQuantity(),
                batchProjection.dueDate()
        );
    }

    private SectionDTO sectionProjectionToSectionDTO(SectionProjection sectionProjection, int id){
        return new SectionDTO(
                sectionProjection.getId().intValue()
                ,id
        );
    }

    private WarehouseDTO warehouseProjectionToWarehouseDTO(WarehouseProjection warehouseProjection){
        return new WarehouseDTO(
                warehouseProjection.id().intValue()
                ,warehouseProjection.totalQuantity().intValue()
        );
    }

    /**
     * Get product batches nearing expiration, filtered by category and order.
     * @param days Number of days until expiration.
     * @param category Category of the products.
     * @param order Order of the results (ascending or descending).
     * @return ResponseBatchDueDTO containing the list of product batches.
     */
    @Override
    public ResponseBatchDueDTO getDueBatchesByDaysAndCategory(Integer days, Category category, String order) {
        LocalDate today = LocalDate.now(); // Get Actual Date
        List<BatchDueDTO> list = batchStockRepository.findProductsBetweenDateAndCategory(
                1L, Date.valueOf(today), Date.valueOf(today.plusDays(days)), category, order);
        if (list.isEmpty()) {
            throw new ApiException("Not Found", "No se encontraron productos con las características solicitadas", 404);
        }
        return new ResponseBatchDueDTO(list);
    }

}
