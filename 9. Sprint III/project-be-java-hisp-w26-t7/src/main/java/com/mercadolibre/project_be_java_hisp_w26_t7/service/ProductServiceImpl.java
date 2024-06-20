package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.beans.AuthDataUtil;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.LocationForProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.WarehouseResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Product;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.ProductSeller;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.BadRequestException;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.ProductMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.StockQuantityMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.WarehouseMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IProductRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IProductSellerRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IWarehouseRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IProductService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.CategoryUtils;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.ProductUtil;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private AuthDataUtil auth;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBatchRepository batchRepository;
    @Autowired
    private IProductSellerRepository productSellerRepository;
    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getProducts(String category) {


        if (category != null) {
            if (!CategoryUtils.categoryExists(category)) throw new NotFoundException(
                    MessageError.INVALID_CATEGORY.getMessage());

            List<IProductResponseProjection> products = productSellerRepository.findAllByCategory(CategoryUtils.getCategory(category)
                    .toString());

            if (products.isEmpty()) throw new NotFoundException(
                    MessageError.PRODUCTS_CATEGORY_NOT_FOUND.getMessage());

            return ProductMapper.mapList(products);
        }

        List<IProductResponseProjection> products = productSellerRepository.findAllJoinProduct();

        if (products.isEmpty()) throw new NotFoundException(MessageError.PRODUCTS_NOT_FOUND.getMessage());

        return ProductMapper.mapList(products);
    }

    /**
     * Obtiene una lista de almacenes con información de id del Warehouse, la contienen el producto y el id del producto.
     * Si no se encuentran lotes del producto especificado en ningún almacén, se devuelve un código de estado "404 Not Found".
     *
     * @param idProduct El identificador del producto del cual se desea obtener la lista de lotes.
     * @return Un StockQuantityResponseDto que contiene la lista de almacenes con detalles de los lotes encontrados
     * @throws NotFoundException Si no se encuentra el producto o no hay lotes disponibles para el producto.
     */

    @Override
    @Transactional(readOnly = true)
    public StockQuantityResponseDto findStockQuantityForEachWarehouse(Long idProduct) {

        ProductSeller productSeller = productSellerRepository.findById(idProduct).orElse(null);
        if (productSeller == null)
            throw new NotFoundException(MessageError.PRODUCTS_NOT_FOUND.getMessage());

        List<IWarehouseBatchProduct> listFoodContainers = warehouseRepository
                .CalculationCuantityTheProductWarehouse(idProduct);

        if (listFoodContainers.isEmpty())
            throw new NotFoundException(MessageError.PRODUCTS_STOCK.getMessage());

        List<WarehouseResponseDTO> warehouseResponseDTOS = listFoodContainers
                .stream()
                .map(WarehouseMapper::mapToWarehouseResponseDTO)
                .toList();

        return StockQuantityMapper.mapToStockQuantityResponseDto(
                idProduct.intValue(),
                warehouseResponseDTOS);
    }

    @Override
    @Transactional(readOnly = true)
    public LocationForProductDTO checkLocationForProduct(Long idProduct, String order) {

        Long representativeId = auth.getIdSession();

        if (!ProductUtil.orderValidation(order)) {
            throw new BadRequestException(MessageError.INVALID_SORTING.getMessage());
        }
        Product product = productRepository.findById(idProduct).orElseThrow(() ->
                new NotFoundException(MessageError.PRODUCT_NOT_FOUND.getMessage(idProduct)));

        List<IBatchSectionProductProjection> projections = batchRepository.findProductBySectionWarehouse(idProduct, representativeId);

        if (projections.isEmpty()) {
            throw new NotFoundException("The product was not found in any of the batches");
        }

        Set<Integer> batchNumbers = new HashSet<>();
        for (IBatchSectionProductProjection projection : projections) {
            if (!batchNumbers.add(projection.getBatchNumber())) {
                throw new BadRequestException("Product appears in the same batch multiple times");
            }
        }

        if (batchNumbers.size() < 2) {
            throw new BadRequestException("Product must appear in at least two different batches");
        }

        LocalDate currentDate = LocalDate.now();
        for (IBatchSectionProductProjection projection : projections) {
            LocalDate dueDate = projection.getDueDate();
            if (dueDate.isBefore(currentDate) || dueDate.minusWeeks(3).isBefore(currentDate)) {
                throw new BadRequestException("Product is expired or close to expiration");
            }
        }
        return ProductMapper.mapLocationForProductDTO(projections, order);
    }
}
