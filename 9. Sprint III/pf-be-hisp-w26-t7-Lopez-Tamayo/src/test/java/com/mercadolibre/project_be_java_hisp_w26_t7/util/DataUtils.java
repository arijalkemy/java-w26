package com.mercadolibre.project_be_java_hisp_w26_t7.util;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.SectionRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
                .batches(Set.of(getBatch()))
                .build();
    }

    public static Section getSectionCp() {
        return Section.builder()
                .code(1L)
                .name("no fresh")
                .size(1)
                .storageType(getStorageTypeCp())
                .batches(Set.of(getBatchCp()))
                .build();
    }

    public static Warehouse getWarehouse() {
        return Warehouse.builder()
                .id(1L)
                .name("any warehouse")
                .address("calle 93 # 23 -3")
                .sections(Set.of(getSection()))
                .representatives(List.of(getRepresentative()))
                .build();
    }

    public static Warehouse getWarehouseCp() {
        return Warehouse.builder()
                .id(1L)
                .name("any warehouse")
                .address("calle 93 # 23 -3")
                .sections(Set.of(getSectionCp()))
                .representatives(List.of(getRepresentative()))
                .build();
    }

    public static Representative getRepresentative() {
        return Representative.builder()
                .id(1L)
                .name("Carlos Cardozo")
                .build();
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
}
