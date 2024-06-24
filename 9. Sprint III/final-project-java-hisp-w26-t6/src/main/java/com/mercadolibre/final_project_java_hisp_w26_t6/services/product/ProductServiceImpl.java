package com.mercadolibre.final_project_java_hisp_w26_t6.services.product;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchStockDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Sector;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Warehouse;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.BatchMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.ProductMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.SectorMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.WarehouseMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IBatchesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IProductsRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IWarehousesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.BatchSortType;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.EnumChecker;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductsRepository productsRepository;

    @Autowired
    IBatchesRepository batchesRepository;

    @Autowired
    IWarehousesRepository warehousesRepository;

    @Transactional(readOnly = true)
    @Override
    public ProductsResponseDto getAllProductsByCategory(String category) {
        List<ProductDto> products;
        if (category == null || category.isEmpty()) {
            products = productsRepository.findAll().stream()
                    .map(ProductMapper::mapProductToDto).toList();

        } else {
            EnumChecker.isValidEnum(StorageType.class, category, "Invalid storage type: " + category);
            products = productsRepository.findAllByStorageType(StorageType.valueOf(category.toUpperCase()))
                    .stream()
                    .map(ProductMapper::mapProductToDto).toList();

        }
        if (products.isEmpty()) {
            throw new NotFoundException("No products found");
        }
        return ProductMapper.mapProductDtoListToResponseDto(products);
    }

    @Transactional(readOnly = true)
    @Override
    public ListProductsBatchDto listBatchsByProductId(Long productId, String username, String order) {
        Product product = this.findProductOrThrowError(productId);
        Warehouse warehouse = this.getWarehouseBySupervisorUsername(username);
        Sector sector = warehouse.getSectors()
                .stream().filter(s -> s.getStorageType().equals(product.getStorageType())).findAny()
                .orElseThrow(() -> new NotFoundException("No sector found for the warehouse"));

        List<Batch> batchList = sector.getBatches()
                .stream().filter(b -> b.getDueDate().isAfter(LocalDateTime.now().plusWeeks(3L))).toList();
        List<BatchStockDto> batchDTOList = batchList.stream().map(BatchMapper::batchToBatchStockDTO).toList();
        List<BatchStockDto> orderedBatchDTOList = this.orderBatchStockDTO(batchDTOList, order);

        return BatchMapper.mapListProductsToListBatchDto(SectorMapper.toDto(sector, warehouse), productId,
                orderedBatchDTOList);
    }

    @Override
    @Transactional
    public ProductByWarehouseDto getTotalStockByProduct(Long id) {

        Product product = findProductOrThrowError(id);

        List<Warehouse> warehouses = warehousesRepository.findAll();

        if (warehouses.isEmpty()) {
            throw new NotFoundException("No warehouses were found");
        }

        List<WarehouseQuantityDto> warehouseStocks = new ArrayList<>();

        for (Warehouse warehouse : warehouses) {
            int totalQuantity = countStockOfProductForWarehouse(warehouse, product);

            if (totalQuantity > 0) {
                warehouseStocks.add(WarehouseMapper.buildWarehouseQuantityDto(warehouse, totalQuantity));
            }
        }

        if (warehouseStocks.isEmpty()) {
            throw new NotFoundException("No stock available for the product in any warehouse");
        }

        return ProductMapper.createProductByWarehouseDto(product.getId(), warehouseStocks);

    }

    private int countStockOfProductForWarehouse(Warehouse warehouse, Product product) {
        return warehouse.getSectors().stream()
                .filter(s -> s.getStorageType().equals(product.getStorageType()))
                .flatMap(s -> s.getBatches().stream())
                .filter(b -> b.getProduct().getId().equals(product.getId()))
                .mapToInt(Batch::getQuantity)
                .sum();
    }

    private Product findProductOrThrowError(Long id) {
        return productsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with id: " + id + " not found"
        ));
    }

    private Warehouse getWarehouseBySupervisorUsername(String username) {
        Warehouse response = this.warehousesRepository.findBySupervisorUsername(username);
        if (response == null) {
            throw new NotFoundException("Warehouse with supervisor: " + username + " does not exist.");
        }
        return response;
    }

    private List<BatchStockDto> orderBatchStockDTO(List<BatchStockDto> batchDTOList, String order) {
        if (order == null) {
            return batchDTOList;
        }
        EnumChecker.isValidEnum(BatchSortType.class, order, "Invalid batch sort type: " + order);
        BatchSortType orderEnum = BatchSortType.valueOf(BatchSortType.class, order);
        Comparator<BatchStockDto> comparator = switch (orderEnum) {
            case C -> Comparator.comparing(BatchStockDto::getCurrentQuantity);
            case L -> Comparator.comparing(BatchStockDto::getBatchNumber);
            case F -> Comparator.comparing(BatchStockDto::getDue_date);
        };
        return batchDTOList.stream().sorted(comparator).toList();
    }
}
