package com.mercadolibre.project_be_java_hisp_w26_t7.util;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductPurchaseOrderRequestDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.WarehouseResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.*;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.StockQuantityMapper;
import com.mercadolibre.project_be_java_hisp_w26_t7.mapper.WarehouseMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDataGenerator {

    public static Buyer getBuyerWithCustomId(Long id) {
        return Buyer.builder()
                .id(id)
                .nit("BUYER_NIT")
                .name("BUYER_NAME")
                .lastName("BUYER_LASTNAME")
                .build();
    }

    public static Status getStatusWithName(String statusName) {
        return Status
                .builder()
                .id(1L)
                .description(statusName)
                .build();
    }

    public static ProductPurchaseOrderRequestDto getProductOrderWithId(Integer productId) {
        return new ProductPurchaseOrderRequestDto(productId, 8);
    }

    public static ProductPurchaseOrderRequestDto getOrderProductsWithIdAndQuantity(Integer productId, Integer quantity) {
        return new ProductPurchaseOrderRequestDto(productId, quantity);
    }

    public static Product getProductWithId(Long productId) {
        StorageType testStorageType = StorageType
                .builder()
                .id(1L)
                .name("TEST_STORAGE_TYPE")
                .build();

        return Product
                .builder()
                .id(productId)
                .description("TEST_PRODUCT")
                .storageType(testStorageType)
                .build();
    }

    public static ProductSeller getProductSellerWithIdAndPrice(Long id, Double price) {
        Product testProduct = getProductWithId(1L);

        Seller testSeller = Seller
                .builder()
                .id(1L)
                .description("TEST_SELLER_DESCRIPTION")
                .name("TEST_SELLER_NAME")
                .build();

        return ProductSeller.builder()
                .id(id)
                .product(testProduct)
                .seller(testSeller)
                .price(BigDecimal.valueOf(price))
                .build();
    }

    public static Batch getBatchWithProps(
            Long batchId, ProductSeller product, Boolean hasStock, Boolean expired
    ) {
        LocalDate dueDate = LocalDate.now().plusWeeks(4);
        if (expired) dueDate = LocalDate.now().plusDays(1);

        int stock = 0;
        if (hasStock) stock = 22;

        LocalDate manDate = LocalDate.now().minusMonths(1);
        LocalDateTime manDateTime = LocalDateTime.of(manDate, LocalTime.of(14, 0, 0));

        Representative testRepresentative = Representative
                .builder()
                .id(1L)
                .name("TEST_REPRESENTATIVE")
                .build();

        return Batch.builder()
                .id(batchId)
                .batchNumber(12345L)
                .dueDate(dueDate)
                .initialQuantity(40)
                .currentQuantity(stock)
                .minimumTemperature(BigDecimal.valueOf(10))
                .currentTemperature(BigDecimal.valueOf(10))
                .manufacturingDate(manDate)
                .manufacturingTime(manDateTime)
                .productSeller(product)
                .representative(testRepresentative)
                .build();
    }

    public static Order getOrderWithProps(
            Long orderId,
            Long initialBuyerId,
            Double orderTotal,
            Boolean buyerMatches
    ) {
        Long buyerId = initialBuyerId;
        if (!buyerMatches) {
            buyerId = ~initialBuyerId;
        }
        Buyer buyer = getBuyerWithCustomId(buyerId);

        Status status = getStatusWithName("carrito");

        return Order.builder()
                .id(orderId)
                .date(LocalDate.now())
                .total(BigDecimal.valueOf(orderTotal))
                .buyer(buyer)
                .status(status)
                .build();
    }

    public static <T> Optional<T> getOptionalObject(T object) {
        return Optional.ofNullable(object);
    }

    public static List<IWarehouseBatchProduct> getIWarehouseBatchProduct() {
        List<IWarehouseBatchProduct> warehouseBatchProducts = new ArrayList<>();

        warehouseBatchProducts.add(new IWarehouseBatchProduct() {
            @Override
            public Integer getWarehouseId() {
                return 1;
            }

            @Override
            public String getWarehouseName() {
                return "Bogotá Warehouse";
            }

            @Override
            public Integer getBatchCurrentQuantity() {
                return 110;
            }
        });
        return warehouseBatchProducts;
    }

    public static ProductSeller getProductSeller() {
        ProductSeller.ProductSellerBuilder builder = ProductSeller.builder();
        builder.id(1L);
        builder.price(BigDecimal.valueOf(10.99));
        ProductSeller productSeller =
                builder
                        .build();
        return productSeller;
    }

    public static StockQuantityResponseDto getStockQuantityResponseDto() {

        List<WarehouseResponseDTO> warehouseResponseDTOS = getIWarehouseBatchProduct()
                .stream()
                .map(WarehouseMapper::mapToWarehouseResponseDTO)
                .toList();

        StockQuantityResponseDto stockQuantityResponseDto =
                StockQuantityMapper.mapToStockQuantityResponseDto(
                        1,
                        warehouseResponseDTOS);

        return stockQuantityResponseDto;
    }

}
