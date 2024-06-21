package com.mercadolibre.project_be_java_hisp_w26_team5.service.impl;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ProductFilterRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.*;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Batch;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Sector;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Warehouse;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IProductRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IProductService;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IProductServiceInternal;
import com.mercadolibre.project_be_java_hisp_w26_team5.util.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.project_be_java_hisp_w26_team5.mapper.ProductMapper.toProductDetailResponseDtoList;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService, IProductServiceInternal {

    private final IProductRepository repository;
    private final IBatchRepository batchRepository;
    private final ProductSpecification spec;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDetailResponseDto> getProducts() {
        List<Product> products = repository.findAll();
        List<ProductDetailResponseDto> response = toProductDetailResponseDtoList(products);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDetailResponseDto> getProductsByFilter(ProductFilterRequestDTO request) {
        Specification<Product> productSpec = spec.getAllBySpec(request);
        List<Product> products = repository.findAll(productSpec);
        List<ProductDetailResponseDto> response = toProductDetailResponseDtoList(products);
        return response;
    }

    @Override
    public ProductLocationByIdDTO getProductLocationById(
            Integer productId, Integer managerId, String order
    ) {
        validateProductExists(productId);
        List<Batch> batches = getBatchesByOrder(
                order,
                productId
        );
        validateBatchesExist(
                batches,
                productId
        );
        validateSellerWarehouse(
                managerId,
                batches
        );
        return createProductLocationByIdDTO(batches);
    }

    @Override
    public ProductStockResponseDTO getTotalStockOfWarehouses(int idProduct) {
        validateProductExists(idProduct);

        List<Batch> batchesOfProduct = batchRepository.findAllByProductId(idProduct);
        validateBatchesExist(
                batchesOfProduct,
                idProduct
        );

        List<StockInWarehouseResponseDTO> stockInWarehouse = getStockInWarehouse(batchesOfProduct);

        return ProductStockResponseDTO
                .builder()
                .productId(idProduct)
                .warehouses(stockInWarehouse)
                .build();
    }

    private List<StockInWarehouseResponseDTO> getStockInWarehouse(List<Batch> batchesOfProduct) {
        List<Warehouse> warehouses = batchesOfProduct
                .stream()
                .map(Batch::getSector)
                .map(Sector::getWarehouse)
                .distinct()
                .toList();

        return warehouses
                .stream()
                .map(w -> StockInWarehouseResponseDTO
                        .builder()
                        .warehouseCode(w.getId())
                        .totalQuantity(getQuantityOfBatchesByWarehouse(
                                batchesOfProduct,
                                w
                        ))
                        .build())
                .toList();
    }

    private int getQuantityOfBatchesByWarehouse(List<Batch> batchesOfProduct, Warehouse warehouse) {
        return batchesOfProduct
                .stream()
                .filter(b -> b
                        .getSector()
                        .getWarehouse()
                        .equals(warehouse))
                .mapToInt(Batch::getCurrentQuantity)
                .sum();
    }

    private void validateProductExists(Integer productId) {
        if (!repository.existsById(productId)) {
            throw new NotFoundException(
                    "Producto",
                    "id: " + productId
            );
        }
    }

    private void validateBatchesExist(
            List<Batch> batches, Integer productId
    ) {
        if (batches.isEmpty()) {
            throw new NotFoundException("No existe ningun lote que contenga el producto con id: " + productId);
        }
    }

    private void validateSellerWarehouse(
            Integer managerId, List<Batch> batches
    ) {
        Warehouse warehouse = batches
                .get(0)
                .getSector()
                .getWarehouse();

        if (!managerId.equals(warehouse
                .getManager()
                .getId()))
        {
            throw new NotFoundException("No se ha encontrado ningun lote del producto asociado al warehouse del " +
                    "manager.");
        }
    }

    private List<Batch> getBatchesByOrder(
            String order, Integer productId
    ) {
        int WEEKSEXPIRATION = 3;
        LocalDate expirationDate = LocalDate
                .now()
                .plusWeeks(WEEKSEXPIRATION);

        return switch (order) {
            case "C" -> batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByCurrentQuantity(
                    productId,
                    expirationDate
            );
            case "F" -> batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByDueDate(
                    productId,
                    expirationDate
            );
            default -> batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                    productId,
                    expirationDate
            );
        };
    }

    private ProductLocationByIdDTO createProductLocationByIdDTO(List<Batch> batches) {
        Batch fistBatch = batches.get(0);
        Product product = fistBatch.getProduct();
        Sector sector = fistBatch.getSector();
        Warehouse warehouse = sector.getWarehouse();

        List<BatchStockProductByBatchDTO> batchDTOS = createListBatchStockProductByBatchDTO(batches);

        return ProductLocationByIdDTO
                .builder()
                .section(SectionProductByBatchDTO
                        .builder()
                        .sectionCode(product.getId())
                        .warehouseCode(warehouse.getId())
                        .build())
                .productId(product.getId())
                .batchStock(batchDTOS)
                .build();
    }

    private List<BatchStockProductByBatchDTO> createListBatchStockProductByBatchDTO(List<Batch> batches) {
        return batches
                .stream()
                .map(this::batchToBatchStockProductByBatchDTO)
                .toList();
    }

    private BatchStockProductByBatchDTO batchToBatchStockProductByBatchDTO(Batch batch) {
        return BatchStockProductByBatchDTO
                .builder()
                .batchNumber(Integer.parseInt(batch.getBatchNumber()))
                .currentQuantity(batch.getCurrentQuantity())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDetailResponseDto> getProductsByCategory(List<String> category) {
        List<Product> products = new ArrayList<>();
        category.forEach((cat) -> products.addAll(repository.findByType(TypeProduct.valueOf(cat))));
        List<ProductDetailResponseDto> response = toProductDetailResponseDtoList(products);
        return response;
    }



    @Override
    public Product findProductById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Product: " + id));
    }
}
