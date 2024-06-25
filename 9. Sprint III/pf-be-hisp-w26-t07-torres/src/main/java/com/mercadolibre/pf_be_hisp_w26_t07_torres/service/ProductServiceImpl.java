package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums.OperationEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums.StatusCodeEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.ProductSeller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.StockQuantityMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.WarehouseMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.CategoryUtils;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.ProductUtil;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.SuccessMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private AuthDataUtil auth;
    @Autowired
    private IBatchRepository batchRepository;
    @Autowired
    private IProductSellerRepository productSellerRepository;
    @Autowired
    private IWarehouseRepository warehouseRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    @Autowired
    private IStorageTypeRepository storageTypeRepository;

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
        if (!productSellerRepository.existsById(idProduct)) {
            throw new NotFoundException(MessageError.PRODUCT_NOT_FOUND.getMessage(idProduct));
        }

        List<IBatchSectionProductProjection> projections = batchRepository
                .findProductBySectionWarehouse(idProduct, representativeId);

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

        LocalDate acceptableDueDate = LocalDate.now().plusWeeks(3);
        for (IBatchSectionProductProjection projection : projections) {
            LocalDate dueDate = projection.getDueDate();
            if (dueDate.isBefore(acceptableDueDate)) {
                throw new BadRequestException("Product is expired or close to expiration");
            }
        }
        return ProductMapper.mapLocationForProductDTO(projections, order);
    }

    @Override
    public ProductCreateResponseDto createProductSeller(Long idSeller, ListProductRequestDto productRequestDto) {
        Seller seller = sellerRepository.findById(idSeller).orElseThrow(
                () -> new NotFoundException(MessageError.SELLER_NOT_FOUND.getMessage())
        );

        List<ProductRequestDto> products = productRequestDto.getProducts();
        if (products.isEmpty()) {
            throw new BadRequestException(MessageError.EMPTY_LIST_ERROR.getMessage("products"));
        }
        for (ProductRequestDto productDto : products) {
            StorageType storageType = storageTypeRepository
                    .findStorageTypeByNameEqualsIgnoreCase(productDto.getStorageType())
                    .orElseThrow(() -> new BadRequestException(MessageError.STORAGE_TYPE_NOT_FOUND.getMessage()));

            Product product = Product.builder()
                    .description(productDto.getDescription())
                    .storageType(storageType)
                    .build();
            ProductSeller productToSave = ProductSeller.builder()
                    .seller(seller)
                    .product(product)
                    .price(BigDecimal.valueOf(productDto.getPrice()))
                    .build();
            productSellerRepository.save(productToSave);
        }
        return ProductCreateResponseDto
                .builder()
                .code(StatusCodeEnum.SUCCESSFUL.getId())
                .message(SuccessMessageEnum.PRODUCTS_CREATED.getMessage("products"))
                .operation(OperationEnum.CREATE.getId())
                .build();
    }

    @Override
    public ProductCreateResponseDto updateProductSeller(
            Long idSeller, Long productSellerId, ProductRequestDto productRequestDto
    ) {
        if (!sellerRepository.existsById(idSeller)) {
            throw new NotFoundException(MessageError.SELLER_NOT_FOUND.getMessage());
        }

        ProductSeller productSeller = productSellerRepository.findById(productSellerId)
                .orElseThrow(
                        () -> new NotFoundException(MessageError.PRODUCT_NOT_FOUND.getMessage())
                );

         productSellerRepository.save(productSeller);

        return ProductCreateResponseDto
                .builder()
                .code(StatusCodeEnum.SUCCESSFUL.getId())
                .message(SuccessMessageEnum.PRODUCTS_UPDATED.getMessage("products"))
                .operation(OperationEnum.UPDATE.getId())
                .build();
    }
}
