package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.PurchaseOrderDataRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductOfPurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.PurchaseOrderCreatedResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.Role;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.UserRoleMismatchException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.*;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IOrderDetailRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IPurchaseOrderService;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IPurchaseOrderServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IUserServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements IPurchaseOrderService, IPurchaseOrderServiceInternal {

    final IUserServiceInternal userServiceInternal;
    final IBatchRepository batchRepository;
    final IOrderDetailRepository orderDetailRepository;
    final IProductServiceInternal productServiceInternal;
    final IPurchaseOrderRepository purchaseOrderRepository;
    final String DEFAULT_STATUS = "shopping_cart";
    final LocalDate MINIMUM_DUE_DATE = LocalDate
            .now()
            .plusWeeks(3);

    @Override
    @Transactional
    public PurchaseOrderCreatedResponseDTO upsertPurchaseOrder(
            PurchaseOrderRequestDTO purchaseOrderDTO, Integer idOrder
    ) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        if (idOrder != null) {
            purchaseOrder.setId(idOrder);
            PurchaseOrder purchaseOrderOld = findPurchaseOrderById(idOrder);
            this.orderDetailRepository.deleteAllByOrder(purchaseOrderOld);
        }

        PurchaseOrderDataRequestDTO purchaseOrderData = purchaseOrderDTO.getPurchaseOrder();

        UserEntity user = userServiceInternal.findUserById(purchaseOrderData.getBuyerId());

        if (!user
                .getRole()
                .equals(Role.BUYER))
        {
            throw new UserRoleMismatchException(Role.BUYER.toString());
        }

        List<String> stockErrors = new ArrayList<>();
        AtomicReference<Double> totalPrice = new AtomicReference<>(0.0);


        purchaseOrder.setBuyer(user);
        purchaseOrder.setStatus(DEFAULT_STATUS);
        purchaseOrder.setDate(purchaseOrderData.getDate());
        purchaseOrder.setOrderDetails(new HashSet<>());

        purchaseOrderData
                .getProducts()
                .parallelStream()
                .forEach(productRequest -> {
                    Optional<Warehouse> warehouse
                            = batchRepository.findFirstStockOfAProductByProductIdAndExpirationDate(
                            productRequest.getProductId(),
                            MINIMUM_DUE_DATE,
                            productRequest.getQuantity()
                    );
                    Product product = productServiceInternal.findProductById(productRequest.getProductId());
                    if (warehouse.isEmpty()) {
                        synchronized (stockErrors) {
                            stockErrors.add("There is not enough stock of the product with id: " +
                                    productRequest.getProductId());
                        }
                    } else {
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setOrder(purchaseOrder);
                        orderDetail.setProduct(product);
                        orderDetail.setQuantity(productRequest.getQuantity());
                        orderDetail.setPrice(product.getPrice());
                        orderDetail.setWarehouse(warehouse.get());
                        synchronized (purchaseOrder) {
                            purchaseOrder
                                    .getOrderDetails()
                                    .add(orderDetail);
                        }
                        synchronized (totalPrice) {
                            totalPrice.set(totalPrice.get() + productRequest.getQuantity() * product.getPrice());
                        }
                    }
                });

        purchaseOrderRepository.save(purchaseOrder);

        if (!stockErrors.isEmpty()) {
            return new PurchaseOrderCreatedResponseDTO(
                    purchaseOrder.getId(),
                    totalPrice.get(),
                    stockErrors
            );
        } else {
            return new PurchaseOrderCreatedResponseDTO(
                    purchaseOrder.getId(),
                    totalPrice.get(),
                    null
            );
        }
    }

    @Override
    @Transactional
    public List<ProductOfPurchaseOrderResponseDTO> getProductsOfPurchaseOrder(Integer idOrder) {

        PurchaseOrder purchaseOrder = findPurchaseOrderById(idOrder);
        List<ProductOfPurchaseOrderResponseDTO> productsDTO = new ArrayList<>();

        for (OrderDetail orderDetail : purchaseOrder.getOrderDetails()) {
            ProductOfPurchaseOrderResponseDTO productDTO = new ProductOfPurchaseOrderResponseDTO();
            productDTO.setProduct(ProductMapper.toProductDetailResponseDto(orderDetail.getProduct()));
            productDTO.setQuantity(orderDetail.getQuantity());
            productsDTO.add(productDTO);
        }

        return productsDTO;
    }

    public PurchaseOrder findPurchaseOrderById(Integer id) {
        return purchaseOrderRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Purchase order with id: " + id + ", "));
    }

}
