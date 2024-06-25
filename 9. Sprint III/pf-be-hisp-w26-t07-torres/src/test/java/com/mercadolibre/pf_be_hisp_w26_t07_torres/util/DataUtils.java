package com.mercadolibre.pf_be_hisp_w26_t07_torres.util;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BSResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.order.OrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.order.OrderStatusRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.InboundorderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.LocationForProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.ProductPurchaseOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.PurchaseOrderDetailsRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchLowStock;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchTemperatures;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.stock.StockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.SectionResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUtils {

    public static List<IProductResponseProjection> getProductsResponseProjection() {
        List<IProductResponseProjection> products = new ArrayList<>();

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getDescription() {
                return "Lechuga";
            }

            @Override
            public Double getPrice() {
                return 10.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Fresco";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 2L;
            }

            @Override
            public String getDescription() {
                return "Yogur";
            }

            @Override
            public Double getPrice() {
                return 15.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Refrigerado";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 3L;
            }

            @Override
            public String getDescription() {
                return "Helado";
            }

            @Override
            public Double getPrice() {
                return 20.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Congelado";
            }
        });

        return products;
    }

    public static Order getOrderById1() {
        Buyer buyer = Buyer.builder()
                .id(1L)
                .nit("900000001")
                .name("Edwin")
                .lastName("Villaraga")
                .build();
        Status status = Status.builder()
                .id(1L)
                .description("carrito")
                .build();
        return Order.builder()
                .id(1L)
                .date(LocalDate.of(2024, 6, 11))
                .total(BigDecimal.valueOf(694.65))
                .buyer(buyer)
                .status(status)
                .build();
    }

    public static List<ProductResponseDTO> getProductsResponseDTO() {
        List<ProductResponseDTO> products = new ArrayList<>();
        products.add(ProductResponseDTO.builder().id(1L).description("Lechuga").price(BigDecimal.valueOf(10.99))
                .sellerName("AgroAlimentos S.A.").category("Fresco").build());
        products.add(ProductResponseDTO.builder().id(2L).description("Yogur").price(BigDecimal.valueOf(15.99))
                .sellerName("AgroAlimentos S.A.").category("Refrigerado").build());
        products.add(ProductResponseDTO.builder().id(3L).description("Helado").price(BigDecimal.valueOf(20.99))
                .sellerName("AgroAlimentos S.A.").category("Congelado").build());
        return products;
    }

    public static List<ProductResponseDTO> getProductsFreshDTO() {
        List<ProductResponseDTO> products = new ArrayList<>();
        products.add(ProductResponseDTO.builder().id(1L).description("Lechuga").price(BigDecimal.valueOf(10.99))
                .sellerName("AgroAlimentos S.A.").category("Fresco").build());
        products.add(ProductResponseDTO.builder().id(2L).description("Tomate").price(BigDecimal.valueOf(15.99))
                .sellerName("AgroAlimentos S.A.").category("Fresco").build());
        products.add(ProductResponseDTO.builder().id(3L).description("Zanahoria").price(BigDecimal.valueOf(20.99))
                .sellerName("AgroAlimentos S.A.").category("Fresco").build());
        return products;
    }

    public static List<IProductResponseProjection> getProductsFresh() {
        List<IProductResponseProjection> products = new ArrayList<>();

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getDescription() {
                return "Lechuga";
            }

            @Override
            public Double getPrice() {
                return 10.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Fresco";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 2L;
            }

            @Override
            public String getDescription() {
                return "Tomate";
            }

            @Override
            public Double getPrice() {
                return 15.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Fresco";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 3L;
            }

            @Override
            public String getDescription() {
                return "Zanahoria";
            }

            @Override
            public Double getPrice() {
                return 20.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Fresco";
            }
        });

        return products;
    }

    public static List<ProductResponseDTO> getProductsCooledDTO() {
        List<ProductResponseDTO> products = new ArrayList<>();
        products.add(ProductResponseDTO.builder().id(1L).description("Yogur").price(BigDecimal.valueOf(10.99))
                .sellerName("AgroAlimentos S.A.").category("Refrigerado").build());
        products.add(ProductResponseDTO.builder().id(2L).description("Leche").price(BigDecimal.valueOf(15.99))
                .sellerName("AgroAlimentos S.A.").category("Refrigerado").build());
        products.add(ProductResponseDTO.builder().id(3L).description("Jugo en caja").price(BigDecimal.valueOf(20.99))
                .sellerName("AgroAlimentos S.A.").category("Refrigerado").build());
        return products;
    }

    public static List<IProductResponseProjection> getProductsCooled() {
        List<IProductResponseProjection> products = new ArrayList<>();

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getDescription() {
                return "Yogur";
            }

            @Override
            public Double getPrice() {
                return 10.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Refrigerado";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 2L;
            }

            @Override
            public String getDescription() {
                return "Leche";
            }

            @Override
            public Double getPrice() {
                return 15.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Refrigerado";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 3L;
            }

            @Override
            public String getDescription() {
                return "Jugo en caja";
            }

            @Override
            public Double getPrice() {
                return 20.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Refrigerado";
            }
        });

        return products;
    }

    public static List<ProductResponseDTO> getProductsFrozenDTO() {
        List<ProductResponseDTO> products = new ArrayList<>();
        products.add(ProductResponseDTO.builder().id(1L).description("Helado").price(BigDecimal.valueOf(10.99))
                .sellerName("AgroAlimentos S.A.").category("Congelado").build());
        products.add(ProductResponseDTO.builder().id(2L).description("Choco Cono").price(BigDecimal.valueOf(15.99))
                .sellerName("AgroAlimentos S.A.").category("Congelado").build());
        products.add(ProductResponseDTO.builder().id(3L).description("Bocato").price(BigDecimal.valueOf(20.99))
                .sellerName("AgroAlimentos S.A.").category("Congelado").build());
        return products;
    }

    public static List<IProductResponseProjection> getProductsFrozen() {
        List<IProductResponseProjection> products = new ArrayList<>();

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getDescription() {
                return "Helado";
            }

            @Override
            public Double getPrice() {
                return 10.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Congelado";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 2L;
            }

            @Override
            public String getDescription() {
                return "Choco Cono";
            }

            @Override
            public Double getPrice() {
                return 15.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Congelado";
            }
        });

        products.add(new IProductResponseProjection() {
            @Override
            public Long getId() {
                return 3L;
            }

            @Override
            public String getDescription() {
                return "Bocato";
            }

            @Override
            public Double getPrice() {
                return 20.99;
            }

            @Override
            public String getSellerName() {
                return "AgroAlimentos S.A.";
            }

            @Override
            public String getCategory() {
                return "Congelado";
            }
        });

        return products;
    }

    public static List<ProductResponseDTO> getProductsResponseDTOIT() {
        List<ProductResponseDTO> products = new ArrayList<>();
        products.add(ProductResponseDTO.builder().id(1L).description("Lechuga").price(BigDecimal.valueOf(10.99))
                .sellerName("AgroAlimentos S.A.").category("Fresco").build());
        products.add(
                ProductResponseDTO.builder()
                        .id(2L)
                        .description("Yogur")
                        .price(BigDecimal.valueOf(15.99))
                        .sellerName("AgroAlimentos S.A.")
                        .category("Refrigerado")
                        .build()
        );
        return products;
    }

    public static Seller getSeller() {
        return Seller.builder()
                .id(1L)
                .name("Edwin")
                .description("the best seller")
                .build();
    }

    public static StorageType getStorageType() {
        return StorageType.builder()
                .id(1L)
                .name("Fresh")
                .build();
    }

    public static StorageType getStorageTypeCp() {
        return StorageType.builder()
                .id(2L)
                .name("Testing type")
                .build();
    }

    public static Product getProduct() {
        return Product.builder()
                .storageType(getStorageType())
                .description("Papitas")
                .id(1L)
                .build();
    }

    public static Product getProductCp() {
        return Product.builder()
                .storageType(getStorageTypeCp())
                .description("Papotas")
                .id(2L)
                .build();
    }

    public static ProductSeller getProductSeller() {
        return ProductSeller
                .builder()
                .product(getProduct())
                .seller(getSeller())
                .id(2L)
                .price(new BigDecimal("120.2"))
                .build();
    }

    public static ProductSeller getProductSellerCp() {
        return ProductSeller
                .builder()
                .product(getProductCp())
                .seller(getSeller())
                .id(2L)
                .price(new BigDecimal("120.2"))
                .build();
    }

    public static Batch getBatch() {
        return Batch.builder()
                .batchNumber(1L)
                .id(1L)
                .initialQuantity(10)
                .currentQuantity(10)
                .currentTemperature(new BigDecimal("2.3"))
                .minimumTemperature(new BigDecimal("2.4"))
                .manufacturingTime(LocalDateTime.now())
                .manufacturingDate(LocalDate.now())
                .dueDate(LocalDate.now())
                .productSeller(getProductSeller())
                .build();
    }

    public static Batch getBatchCp() {
        return Batch.builder()
                .batchNumber(1L)
                .id(1L)
                .initialQuantity(10)
                .currentQuantity(10)
                .currentTemperature(new BigDecimal("3.2"))
                .minimumTemperature(new BigDecimal("3.4"))
                .manufacturingTime(LocalDateTime.now())
                .manufacturingDate(LocalDate.now())
                .dueDate(LocalDate.now())
                .productSeller(getProductSeller())
                .build();
    }

    public static Section getSection() {
        return Section.builder()
                .code(1L)
                .name("fresh")
                .size(10)
                .storageType(getStorageType())
                .batches(new ArrayList<>(List.of(getBatch())))
                .build();
    }

    public static Section getSectionCp() {
        return Section.builder()
                .code(1L)
                .name("no fresh")
                .size(1)
                .storageType(getStorageTypeCp())
                .batches(List.of(getBatchCp()))
                .build();
    }

    public static Warehouse getWarehouse() {
        return Warehouse.builder()
                .id(1L)
                .name("any warehouse")
                .address("calle 93 # 23 -3")
                .sections(List.of(getSection()))
                .representatives(List.of(getRepresentative()))
                .build();
    }

    public static Warehouse getWarehouseCp() {
        return Warehouse.builder()
                .id(1L)
                .name("any warehouse")
                .address("calle 93 # 23 -3")
                .sections(List.of(getSectionCp()))
                .representatives(List.of(getRepresentative()))
                .build();
    }

    public static Representative getRepresentative() {
        return Representative.builder()
                .id(1L)
                .name("Carlos Cardozo")
                .build();
    }

    public static String getJsonProductsFrozen() {
        return "[{\"id\":3,\"description\":\"Helado\",\"price\":20.99,\"seller_name\":\"AgroAlimentos S.A." +
               "\",\"category\":\"Congelado\"}]";
    }

    public static Representative getRepresentativeAdditional() {
        return Representative.builder()
                .id(10L)
                .name("Rodrigo Gomez")
                .build();
    }

    public static BatchStockRequestDTO getRequestBatch() {
        Batch batch = getBatch();
        return BatchStockRequestDTO.builder()
                .batchNumber(batch.getId())
                .currentQuantity(batch.getCurrentQuantity())
                .currentTemperature(Double.parseDouble(batch.getCurrentTemperature().toString()))
                .minimumTemperature(Double.parseDouble(batch.getMinimumTemperature().toString()))
                .initialQuantity(batch.getInitialQuantity())
                .productId(batch.getProductSeller().getId())
                .dueDate(batch.getDueDate())
                .build();
    }

    public static SectionRequestDTO getRequestSection() {
        return SectionRequestDTO.builder()
                .sectionCode(getSection().getCode())
                .warehouseCode(getWarehouse().getId())
                .build();
    }

    public static SectionRequestDTO getRequestSectionCp() {
        return SectionRequestDTO.builder()
                .sectionCode(getSectionCp().getCode())
                .warehouseCode(getWarehouse().getId())
                .build();
    }

    public static String bodyCreateInboundOrderIntegration() {
        return "{\"inbound_order\": {\"order_number\": 1," +
               "\"order_date\": \"10-06-2024\"," +
               "\"section\": {" +
               "\"section_code\": 1," +
               "\"warehouse_code\": 1" +
               "},\"batch_stock\": [{" +
               "\"batch_number\": 5," +
               "\"product_id\": 1," +
               "\"current_temperature\": 4.4," +
               "\"minimum_temperature\": 4.3," +
               "\"initial_quantity\": 40," +
               "\"current_quantity\": 30," +
               "\"manufacturing_date\": \"01-04-2024\"," +
               "\"manufacturing_time\": \"01-04-2024 12:30:32\"," +
               "\"due_date\": \"25-02-2025\"}]}}";
    }

    public static String bodyUpdateInboundOrderIntegration() {
        return "{\"inbound_order\": {\"order_number\": 1," +
               "\"order_date\": \"10-06-2024\"," +
               "\"section\": {" +
               "\"section_code\": 1," +
               "\"warehouse_code\": 1" +
               "},\"batch_stock\": [{" +
               "\"batch_number\": 1," +
               "\"product_id\": 1," +
               "\"current_temperature\": 4.4," +
               "\"minimum_temperature\": 4.3," +
               "\"initial_quantity\": 40," +
               "\"current_quantity\": 20," +
               "\"manufacturing_date\": \"01-04-2024\"," +
               "\"manufacturing_time\": \"01-04-2024 12:30:32\"," +
               "\"due_date\": \"25-02-2025\"}]}}";
    }

    public static String responseUpdateInboundOrderIntegration() {
        return "{\"batch_stock\":[{\"batch_number\":1,\"product_id\":1,\"current_temperature\":4.4," +
               "\"minimum_temperature\":4.3,\"initial_quantity\":40,\"current_quantity\":20,\"manufacturing_date\":" +
               "\"01-04-2024\",\"manufacturing_time\":\"01-04-2024 12:30:32\",\"due_date\":\"25-02-2025\"}]}";
    }

    public static String responseCreateInboundOrderIntegration() {
        return "{\"batch_stock\":[{\"batch_number\":5,\"product_id\":1,\"current_temperature\":4.4," +
               "\"minimum_temperature\":4.3,\"initial_quantity\":40,\"current_quantity\":30,\"manufacturing_date\":" +
               "\"01-04-2024\",\"manufacturing_time\":\"01-04-2024 12:30:32\",\"due_date\":\"25-02-2025\"}]}";
    }

    public static BatchStockResponseDTO responseIntegrationInboundOrder() {
        return BatchStockResponseDTO.builder()
                .batchStock(List.of(
                        StockResponseDTO.builder()
                                .productId(1L)
                                .batchNumber(1L)
                                .currentTemperature(4.4)
                                .minimumTemperature(4.3)
                                .initialQuantity(10)
                                .currentQuantity(10)
                                .manufacturingTime(LocalDateTime.of(2024, 4, 1, 12, 30, 32))
                                .manufacturingDate(LocalDate.of(2024, 4, 1))
                                .dueDate(LocalDate.of(2025, 2, 25))
                                .build()
                ))
                .build();
    }

    public static InboundorderRequestDTO bodyForIntegrationInboundOrderDto() {
        return InboundorderRequestDTO.builder()
                .inboundOrder(
                        OrderRequestDTO
                                .builder()
                                .orderNumber(1)
                                .orderDate(LocalDate.of(2024, 6, 10))
                                .section(SectionRequestDTO.builder()
                                        .warehouseCode(1L)
                                        .sectionCode(1L)
                                        .build())
                                .batchStock(List.of(
                                        BatchStockRequestDTO.builder()
                                                .batchNumber(1L)
                                                .productId(1L)
                                                .currentQuantity(10)
                                                .initialQuantity(10)
                                                .minimumTemperature(4.3)
                                                .currentTemperature(4.4)
                                                .manufacturingTime(LocalDateTime.of(2024, 4, 1, 12, 30, 32))
                                                .manufacturingDate(LocalDate.of(2024, 4, 1))
                                                .dueDate(LocalDate.of(2025, 2, 25))
                                                .build()
                                ))
                                .build()
                )
                .build();
    }

    public static TotalPriceResponseDTO getTotalPriceResponseDtoWithPrice(Double price) {
        return TotalPriceResponseDTO.builder()
                .totalPrice(price)
                .build();
    }

    public static PurchaseOrderDetailsRequestDTO getOrderDetailsWithIdAndQuantity(
            Integer buyerId, OrderStatusRequestDTO statusDto, List<ProductPurchaseOrderRequestDto> products
    ) {
        return PurchaseOrderDetailsRequestDTO
                .builder()
                .date(LocalDate.now())
                .buyerId(buyerId)
                .orderStatus(statusDto)
                .products(products)
                .build();
    }

    public static LocationForProductDTO getJsonLocationProductoInWarehouse(Long idProduct) {
        List<BSResponseDTO> listBSResponseDTO = new ArrayList<>();
        listBSResponseDTO.add(BSResponseDTO.builder().id(1).dueDate(LocalDate.parse("2025-02-25")).currentQuantity(20).build());
        listBSResponseDTO.add(BSResponseDTO.builder().id(2).dueDate(LocalDate.parse("2024-09-09")).currentQuantity(50).build());
        listBSResponseDTO.add(BSResponseDTO.builder().id(5).dueDate(LocalDate.parse("2025-02-25")).currentQuantity(30).build());
        return LocationForProductDTO.builder().productId(idProduct).
                section(SectionResponseDTO.builder().sectionCode(1).warehouseCode(1).build()).batchStock(listBSResponseDTO).build();
    }

    public static IBatchSectionProductProjection createProjection(int batchNumber, int currentQuantity, LocalDate dueDate,
                                                            Long sectionCode, Long warehouseCode, Long productId) {
        return new IBatchSectionProductProjection() {
            @Override
            public Integer getBatchNumber() {
                return batchNumber;
            }

            @Override
            public Integer getCurrentQuantity() {
                return currentQuantity;
            }

            @Override
            public LocalDate getDueDate() {
                return dueDate;
            }

            @Override
            public Long getSectionCode() {
                return sectionCode;
            }

            @Override
            public Long getWarehouseCode() {
                return warehouseCode;
            }

            @Override
            public Long getProductId() {
                return productId;
            }

            @Override
            public List<BSResponseDTO> getBatchStock() {
                return Collections.emptyList();
            }
        };
    }

    public static IBatchTemperatures createBatchTempProjection(
            Long batchNumber, Long productId, double temperature, double minTemperature
    ) {
        return new IBatchTemperatures() {
            @Override
            public Long getBatchId() {
                return batchNumber;
            }

            @Override
            public Long getProductId() {
                return productId;
            }

            @Override
            public double getTemperature() {
                return temperature;
            }

            @Override
            public double getMinTemperature() {
                return minTemperature;
            }
        };
    }

    public static IBatchLowStock createBatchLowStockProjection(
            Long batchNumber, Long productId, int quantity, int initialQuantity
    ) {
        return new IBatchLowStock() {
            @Override
            public Long getBatchId() {
                return batchNumber;
            }

            @Override
            public Long getProductId() {
                return productId;
            }

            @Override
            public int getCurrentQuantity() {
                return quantity;
            }

            @Override
            public int getInitialQuantity() {
                return initialQuantity;
            }
        };
    }
}
