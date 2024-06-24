package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service;

import com.google.common.collect.Streams;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IBatchServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IUserServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.util.BatchMapper;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.util.SectionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements IBatchService, IBatchServiceInternal {

    private final IBatchRepository batchRepository;
    private final IProductServiceInternal productServiceImpl;
    private final IUserServiceInternal userServiceInternal;


    @Override
    public Integer countBatchesBySection(Integer sectionId) {
        return batchRepository.countBatchesBySection(sectionId);
    }

    @Override
    public List<BatchStockDTO> addBatchesList(List<Batch> batchesList) {
        List<BatchStockDTO> batchesListResponse = new ArrayList<>();

        batchesList.stream().forEach(batch -> {
            if (batchRepository.findById(batch.getId()).isPresent()) {
                throw new ApiException("Bad Request", "Ya existe un lote con el id " + batch.getId(), 400);
            }
            Batch createdBatch = batchRepository.save(batch);
            batchesListResponse.add(BatchMapper.toBatchStockDTO(createdBatch));
        });
        return batchesListResponse;
    }

    @Override
    public List<BatchStockDTO> addOrUpdateBatchesList(List<Batch> batchesList) {
        List<BatchStockDTO> batchesListResponse = new ArrayList<>();

        batchesList.stream().forEach(batch -> {
            Batch createdBatch = batchRepository.save(batch);
            batchesListResponse.add(BatchMapper.toBatchStockDTO(createdBatch));
        });
        return batchesListResponse;
    }

    @Override
    public BatchStockResponseDTO getBatchesCloseToExpiration(Integer cantOfDays,
                                                             CategoryEnum category,
                                                             OrderTypeEnum orderType) {

        List<Batch> batches;

        if (category != null || orderType != null) {

            if (category == null || orderType == null) {
                throw new ApiException("Bad Request", "Se deben enviar ambos parametros de filtro.", 400);
            }

            Map<CategoryEnum, String> categoryType = new HashMap<>();
            categoryType.put(CategoryEnum.FF, "congelado");
            categoryType.put(CategoryEnum.FS, "fresco");
            categoryType.put(CategoryEnum.RF, "refrigerado");

            String categoryFilter = categoryType.get(category);

            List<Batch> batchList = new ArrayList<>();

            if (orderType == OrderTypeEnum.date_asc) {
                batches = batchRepository.findByDueDateBetweenOrderByDueDateAsc(LocalDate.now(),
                                LocalDate.now().plusDays(cantOfDays))
                        .stream().filter(batch -> batch.getProduct().getCategory().getName().equalsIgnoreCase(categoryFilter))
                        .toList();


            } else {
                batches = batchRepository.findByDueDateBetweenOrderByDueDateDesc(LocalDate.now(),
                                LocalDate.now().plusDays(cantOfDays))
                        .stream().filter(batch -> batch.getProduct().getCategory().getName().equalsIgnoreCase(categoryFilter))
                        .toList();
            }

        } else {

            batches = batchRepository.findByDueDateBetween(LocalDate.now(), LocalDate.now().plusDays(cantOfDays));
        }

        if (batches.isEmpty()) {
            throw new ApiException("Not Found", "No se encontraron lotes próximos a vencer", 404);
        }
        BatchStockResponseDTO response = new BatchStockResponseDTO();
        response.setBatch_stock(batches.stream()
                .map(BatchMapper::toBatchStockDTO).toList());
        return response;

    }
    public Double checkProductStock (List < ProductPurchaseDTO > productsDto) {
        List<Batch> listOfBatch = batchRepository
                .findByProductIdIn(productsDto
                        .stream()
                        .map(ProductPurchaseDTO::getProduct_id).toList());

        List<ProductStockAvailable> stock = convertToProductStockDTOList(listOfBatch);

        if(stock.size() != productsDto.size()){
            throw new ApiException("Not Found", "No se encontró uno o más productos", 404);
        }

        return Streams.zip(stock.stream(),productsDto.stream(), (productStock,product) -> {
            if(productStock.getQuantity() < product.getQuantity()){
                throw new ApiException("Invalid Argument",
                        "El producto" + product.getProduct_id() + " no tiene stock",
                        400);
            }
            return product.getQuantity() * productStock.getIndividualPrice();
        }).mapToDouble(Double::doubleValue).sum();

    }

    public List<ProductStockAvailable> convertToProductStockDTOList(List<Batch> batches) {
        return batches.stream()
                .collect(Collectors.groupingBy(Batch::getProduct, Collectors.summingInt(Batch::getCurrentQuantity)))
                .entrySet().stream()
                .map(entry -> new ProductStockAvailable(entry.getKey().getId(), entry.getValue(),entry.getKey().getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Batch getEntityById (Integer id){
        return batchRepository.findById(id).orElseThrow(() -> new ApiException("Not Found", "No se encontró el lote con el id " + id, 404));
    }

    @Override
    public Boolean DeleteBatchList (List < Batch > batches) {
        batches.stream().forEach(batch -> {
                    if (batchRepository.findById(batch.getId()).isEmpty()) {
                        throw new ApiException("Not Found", "No existe el batch con id" + batch.getId(), 400);
                    }
                    batchRepository.delete(batch);
                }
        );
        return true;
    }

    @Override
    public ProductLocationDTO getProductLocation (String managerEmail, Integer id, BatchOrderType batchOrderType){
        // fetch entities
        User user = userServiceInternal.searchByEmail(managerEmail);
        Warehouse warehouse = user.getWarehouse();
        Product product = productServiceImpl.findById(id);
        List<Batch> listBatchOfProducts = findNonExpiredByProductIdAndWarehouseId(product.getId(),
                warehouse.getId(), batchOrderType);
        Section section = listBatchOfProducts.get(0).getInboundOrder().getSection();

        // map to dtos
        List<BatchLocationDTO> batchStock = listBatchOfProducts.stream()
                .map(BatchMapper::toBatchLocationDTO)
                .toList();
        SectionDTO sectionDTO = SectionMapper.toSectionDTO(section);
        return new ProductLocationDTO(sectionDTO, product.getId(), batchStock);

    }


    @Override
    public List<Batch> findAllByProductId (Integer productId){
        List<Batch> batchListByProduct = batchRepository.findAllByProductId(productId);
        if (batchListByProduct.isEmpty()) {
            throw new ApiException("Not Found", "No existen lotes que contengan en ningun Warehouse el producto de id: " + productId, 404);
        }
        return batchListByProduct;
    }


    @Override
    public List<Batch> findNonExpiredByProductIdAndWarehouseId (Integer productId,
                                                                Integer warehouseId,
                                                                BatchOrderType batchOrderType){
        List<Batch> nonExpiredBatchList = findAllByProductIdAndWarehouseId(productId, warehouseId).stream()
                .filter((batch) -> !isBatchDueToExpire(batch, 3))
                .toList();
        if (nonExpiredBatchList.isEmpty()) {
            throw new ApiException("Not Found",
                    "No existen lotes no vencidos que contengan el producto de id: " + productId, 404);
        }
        if (batchOrderType != null) {
            return orderBatch(nonExpiredBatchList, batchOrderType);
        }
        return nonExpiredBatchList;
    }


    @Override
    public List<Batch> findAllByProductIdAndWarehouseId (Integer productId, Integer warehouseId){
        List<Batch> batchListByProduct = batchRepository.findAllByProductIdAndWarehouseId(productId, warehouseId);
        if (batchListByProduct.isEmpty()) {
            throw new ApiException("Not Found", "No existen lotes que contengan el producto de id: " + productId, 404);
        }
        return batchListByProduct;
    }


    @Override
    public List<Batch> findAllByProductIdAndQuantityGreatherThanCero (Integer productId){
        List<Batch> batchListByProduct = findAllByProductId(productId);
        List<Batch> batches = batchListByProduct.stream().filter(b -> b.getCurrentQuantity() > 0).toList();
        if (batches.isEmpty()) {
            throw new ApiException("Not Found", "No existen lotes con stock que contengan el producto de id: " + productId, 404);
        }
        return batches;
    }


    private boolean isBatchDueToExpire (Batch batch,int weeksPrior){
        LocalDate priorDate = batch.getDueDate().minusWeeks(weeksPrior);
        return LocalDate.now().isAfter(priorDate);
    }

    private List<Batch> orderBatch (List < Batch > batchList, BatchOrderType batchOrderType){
        if (batchOrderType.equals(BatchOrderType.L)) {
            return orderBatchListByBatchNumber(batchList);
        } else if (batchOrderType.equals(BatchOrderType.C)) {
            return orderBatchListByQuantity(batchList);
        } else {
            return orderBatchListByDueDate(batchList);
        }
    }

    private List<Batch> orderBatchListByQuantity (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getCurrentQuantity))
                .toList();

    }
    private List<Batch> orderBatchListByDueDate (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getDueDate))
                .toList();
    }
    private List<Batch> orderBatchListByBatchNumber (List < Batch > batchList) {
        return batchList.stream()
                .sorted(Comparator.comparing(Batch::getId))
                .toList();
    }

    @Override
    public Batch getEntityByIdOrNull (Integer id){
        return batchRepository.findById(id).orElse(null);
    }

}
