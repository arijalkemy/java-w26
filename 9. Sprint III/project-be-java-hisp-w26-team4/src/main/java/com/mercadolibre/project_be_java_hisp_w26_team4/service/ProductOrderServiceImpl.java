package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.ProductOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductErrorDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductOrderDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductOrderTotalDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ProductNotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.UserIdNotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IProductRepository;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IPurchaseOrderRepository;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class ProductOrderServiceImpl implements IProductOrderService{


    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;

    /**
     * Get all products by purchase order id.
     *
     * @param purchaseOrderId the purchase order id
     * @return the all by purchase order id
     */
    @Override
    public List<ProductOrderDTO> getAllByPurchaseOrderId(Long purchaseOrderId) {
        List<ProductOrderDTO> productOrdersDTO;
        try {
            productOrdersDTO = purchaseOrderRepository.findById(purchaseOrderId).orElseThrow()
                    .getProductOrders()
                    .stream().map(productOrder -> ProductOrderDTO.builder()
                            .product(ProductDTO.builder()
                                    .id(productOrder.getProduct().getId())
                                    .productType(productOrder.getProduct().getProductType())
                                    .description(productOrder.getProduct().getDescription())
                                    .price(productOrder.getProduct().getPrice()).build())
                            .quantity(productOrder.getQuantity())
                            .build()).toList();

        } catch (ProductNotFoundException ex){
            throw new ProductNotFoundException("The list of products is empty");
        }
        return productOrdersDTO;
    }

    /**
     * Update order list.
     *
     * @param idOrder the id order
     * @param body   the body
     * @return the updated list
     */
    @Override
    public List<ProductOrderDTO> updateOrder(Long idOrder, PurchaseOrderRequestDTO body) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(idOrder)
                .orElseThrow(() -> new ProductNotFoundException("The purchase order not found"));

        User user = userRepository.findById(body.getBuyerId())
                .orElseThrow(() -> new UserIdNotFoundException("The User by id " + body.getBuyerId() + " not exist in db"));

        purchaseOrder.setDate(body.getDate());
        purchaseOrder.setBuyer(user);
        purchaseOrder.setStatus(body.getStatus().getStatusCode());
        List<ProductOrder> productOrders = body.getProducts().stream()
                .map(dto -> {
                    Product product = productRepository.findById(dto.getProduct())
                            .orElseThrow(() -> new ProductNotFoundException("Product not found"));

                    return ProductOrder.builder()
                            .product(product)
                            .quantity(dto.getQuantity())
                            .build();
                }).toList();

        purchaseOrder.setProductOrders(productOrders);
        purchaseOrderRepository.save(purchaseOrder);

        List<ProductOrderDTO> productOrderDTOs = productOrders.stream()
                .map(productOrder -> ProductOrderDTO.builder()
                        .product(ProductDTO.builder()
                                .id(productOrder.getProduct().getId())
                                .productType(productOrder.getProduct().getProductType())
                                .description(productOrder.getProduct().getDescription())
                                .price(productOrder.getProduct().getPrice()).build())
                        .quantity(productOrder.getQuantity())
                        .build())
                .toList();

        return productOrderDTOs;
    }

    /**
     * Post order list.
     *
     * @param purchaseOrderDTO the id order
     * @return the total price of the order
     */
    @Override
    public ProductOrderTotalDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderDTO) {

        User user = userRepository.findById(purchaseOrderDTO.getBuyerId())
                .orElseThrow(() -> new UserIdNotFoundException("The User by id " + purchaseOrderDTO.getBuyerId() + " not exist in db"));

        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .date(purchaseOrderDTO.getDate())
                .buyer(user)
                .status(purchaseOrderDTO.getStatus().getStatusCode())
                .productOrders(purchaseOrderDTO.getProducts().stream().map(product -> {
                    Product productEntity = productRepository.findById(product.getProduct())
                            .orElseThrow(() -> new ProductNotFoundException("Product not found"));


                    return ProductOrder.builder()
                            .product(productEntity)
                            .quantity(product.getQuantity())
                            .build();
                }).toList())
                .build();


        purchaseOrderRepository.save(purchaseOrder);


        return getProductOrderTotalDTO(purchaseOrderDTO);
    }

    public ProductOrderTotalDTO getProductOrderTotalDTO(PurchaseOrderRequestDTO purchaseOrderDTO) {
        List<ProductErrorDTO> errors = new ArrayList<>();

        return purchaseOrderDTO.getProducts().stream().map(product -> {
                    Product productEntity = getProductEntity(product);
                    if (productEntity != null && !checkProductQuantity(product, errors)) {
                        return null;
                    } else {
                        assert productEntity != null;
                        return ProductOrderTotalDTO.builder()
                                .totalPrice(productEntity.getPrice() * product.getQuantity())
                                .build();
                    }
                }).filter(Objects::nonNull)
                .reduce((total1, total2) -> ProductOrderTotalDTO.builder()
                        .totalPrice(total1.getTotalPrice() + total2.getTotalPrice())
                        .build())
                .map(total -> ProductOrderTotalDTO.builder()
                        .totalPrice(total.getTotalPrice())
                        .errors(errors)
                        .build())
                .orElse(ProductOrderTotalDTO.builder()
                        .totalPrice(0.0)
                        .errors(errors)
                        .build());
    }

    private Product getProductEntity(@Valid ProductOrderRequestDTO product) {
            return productRepository.findById(product.getProduct())
                    .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    private boolean checkProductQuantity(@Valid ProductOrderRequestDTO product, List<ProductErrorDTO> errors) {
        List<Batch> batches = batchRepository.findByProductIdAndDueDateGreaterThanEqual(product.getProduct(), LocalDate.now().minusWeeks(3));
        Integer maxQuantity = batches.stream().map(Batch::getCurrentQuantity).reduce(0, Integer::sum);
        if (product.getQuantity() > maxQuantity) {
            errors.add(new ProductErrorDTO(product.getProduct(), "Not enough quantity in stock"));
            return false;
        }
        return true;
    }

}
