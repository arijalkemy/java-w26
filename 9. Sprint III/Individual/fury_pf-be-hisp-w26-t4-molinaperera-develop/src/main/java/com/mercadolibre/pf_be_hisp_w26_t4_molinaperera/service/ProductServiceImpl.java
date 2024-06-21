package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductPromoDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.WarehouseProductQuantityDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.InvalidCategoryException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.InvalidEndDatePromoException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductPromo;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductType;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductPromoRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IProductPromoRepository productPromoRepository;
    private final IProductTypeRepository productTypeRepository;
    private final IBatchRepository batchRepository;

    @Override
    public WarehouseProductStockDTO searchProductStockInWarehouses(Long productId) {
        List<Object[]> results = productRepository.findProductQuantityInWarehouses(productId);
        List<WarehouseProductQuantityDTO> warehouseProductQuantity = results.stream()
                .map(result -> WarehouseProductQuantityDTO.builder()
                        .id(((Number) result[0]).longValue())
                        .totalQuantity(((Number) result[1]).intValue())
                        .build()).toList();

        if (warehouseProductQuantity.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        return WarehouseProductStockDTO.builder()
                .productId(productId)
                .warehouseProductQuantity(warehouseProductQuantity)
                .build();
    }


    @Override
    public ProductPromoDTO setProductPromo(Long id, Double porcentage) {
        ProductPromo productPromo = productRepository.findById(id)
                .map(product -> ProductPromo.builder()
                        .id(product.getId())
                        .productType(product.getProductType())
                        .description(product.getDescription())
                        .priceOriginal(product.getPrice())
                        .pricePromo(applyDiscount(product.getPrice(), porcentage))
                        .startDate(LocalDate.now())
                        .endDate(checkLessThanThreeWeeks(id))
                        //verifica que la fecha de cierre de la promo sea menor a la de vencimiento
                        .build())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

            productPromoRepository.save(productPromo);
            ProductPromoDTO productDTO = ProductPromoDTO.builder()
                    .id(productPromo.getId())
                    .productType(productPromo.getProductType())
                    .description(productPromo.getDescription())
                    .priceOriginal(productPromo.getPriceOriginal())
                    .pricePromo(productPromo.getPricePromo())
                    .startDate(productPromo.getStartDate())
                    .endDate(productPromo.getEndDate())
                    .build();
        return productDTO;
    }

    private LocalDate checkLessThanThreeWeeks(Long id) {
        LocalDate endDate = LocalDate.now().plusWeeks(3);
        if (endDate.isBefore(batchRepository.findByProductId(id).getDueDate())) {
            return endDate;
        }else{
            throw new InvalidEndDatePromoException("The product cannot be promoted for more than 3 weeks.");
        }


    }

    @Override
    public List<ProductPromoDTO> getProductPromoList() {
        List<ProductPromo> productPromoList = productPromoRepository.findAll();
        if (productPromoList.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        } else {
            return productPromoRepository.findAll()
                    .stream()
                    .map(productPromo -> ProductPromoDTO.builder()
                            .id(productPromo.getId())
                            .productType(productPromo.getProductType())
                            .description(productPromo.getDescription())
                            .priceOriginal(productPromo.getPriceOriginal())
                            .pricePromo(productPromo.getPricePromo())
                            .startDate(productPromo.getStartDate())
                            .endDate(productPromo.getEndDate())
                            .build())
                    .toList();
        }
    }

    private double applyDiscount(double originalPrice, double discountPercentage) {
        double discountAmount = originalPrice * (discountPercentage / 100);
        double finalPrice = originalPrice - discountAmount;
        return finalPrice;
    }

    //Y que el producto tenga stock
    //
    //Y que el vencimiento del producto no sea inferior a 3 semanas

    /**
     * Search all products list.
     *
     * @param category the category
     * @return the list
     */
    @Override
    public List<ProductDTO> searchAllProducts(String category) {
        List<ProductDTO> productDTOList;
        ProductType productType;

        if(category != null){
            productType = switch (category) {
                case "FS" -> productTypeRepository.findByDescription(ProductTypeEnum.FRESCO);
                case "RF" -> productTypeRepository.findByDescription(ProductTypeEnum.REFRIGERADO);
                case "FF" -> productTypeRepository.findByDescription(ProductTypeEnum.CONGELADO);
                default -> throw new InvalidCategoryException("Invalid category");

            };

            try {
                productDTOList = productRepository.findAllByProductTypeId(productType.getId())
                        .stream().map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .productType(product.getProductType())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .build()).toList();
            } catch (ProductNotFoundException ex){
                throw new ProductNotFoundException("The list is empty.");
            }

        } else {
            try {
                productDTOList = productRepository.findAll()
                        .stream()
                        .map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .productType(product.getProductType())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .build()).toList();

            } catch (ProductNotFoundException ex){
                throw new ProductNotFoundException("The list is empty.");
            }
        }
        return productDTOList;
    }
}
