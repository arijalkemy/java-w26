package com.mercadolibre.project_be_java_hisp_w26_team5.service;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ProductRequestPurchaseOrderDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductOfPurchaseOrderResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.PurchaseOrderCreatedResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.Role;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IOrderDetailRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IPurchaseOrderRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.impl.PurchaseOrderServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IProductServiceInternal;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IUserServiceInternal;
import com.mercadolibre.project_be_java_hisp_w26_team5.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {

    @Mock
    IUserServiceInternal userServiceInternal;
    @Mock
    IBatchRepository batchRepository;
    @Mock
    IOrderDetailRepository orderDetailRepository;
    @Mock
    IProductServiceInternal productServiceInternal;
    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;

    @InjectMocks
    private PurchaseOrderServiceImpl purchaseOrderService;

    final LocalDate MINIMUM_DUE_DATE = LocalDate
            .now()
            .plusWeeks(3);


    @Test
    @DisplayName("Should create a purchase order")
    void testCreatePurchaseOrder() {
        //arrange
        final Integer PRODUCT_1_QUANTITY = 10;
        final Integer PRODUCT_2_QUANTITY = 5;
        final Double PRICE_PRODUCT_ID_1 = 300d;
        final Double PRICE_PRODUCT_ID_2 = 300d;

        ProductRequestPurchaseOrderDTO productRequest1 = new ProductRequestPurchaseOrderDTO();
        productRequest1.setProductId(1);
        productRequest1.setQuantity(PRODUCT_1_QUANTITY);

        ProductRequestPurchaseOrderDTO productRequest2 = new ProductRequestPurchaseOrderDTO();
        productRequest2.setProductId(2);
        productRequest2.setQuantity(PRODUCT_2_QUANTITY);
        PurchaseOrderRequestDTO purchaseOrderRequestDTO = TestUtils.getPurchaseOrderRequestDTO(
                1,
                List.of(
                        productRequest1,
                        productRequest2
                )
        );

        UserEntity user = new UserEntity();
        user.setId(1);
        user.setRole(Role.BUYER);
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);

        Product product1 = new Product();
        product1.setId(1);
        product1.setPrice(300d);

        Product product2 = new Product();
        product2.setId(2);
        product2.setPrice(300d);

        when(userServiceInternal.findUserById(1)).thenReturn(user);
        when(productServiceInternal.findProductById(1)).thenReturn(product1);
        when(productServiceInternal.findProductById(2)).thenReturn(product2);
        when(batchRepository.findFirstStockOfAProductByProductIdAndExpirationDate(
                1,
                MINIMUM_DUE_DATE,
                PRODUCT_1_QUANTITY
        )).thenReturn(Optional.of(warehouse));
        when(batchRepository.findFirstStockOfAProductByProductIdAndExpirationDate(
                2,
                MINIMUM_DUE_DATE,
                PRODUCT_2_QUANTITY
        )).thenReturn(Optional.of(warehouse));

        PurchaseOrderCreatedResponseDTO expected = new PurchaseOrderCreatedResponseDTO();
        expected.setTotalPrice(PRODUCT_1_QUANTITY * PRICE_PRODUCT_ID_1 + PRODUCT_2_QUANTITY * PRICE_PRODUCT_ID_2);

        PurchaseOrderCreatedResponseDTO response = purchaseOrderService.upsertPurchaseOrder(
                purchaseOrderRequestDTO,
                null
        );

        verify(
                purchaseOrderRepository,
                times(1)
        ).save(any(PurchaseOrder.class));

        Assertions.assertEquals(
                expected,
                response
        );
    }

    @Test
    @DisplayName("Should get a products of a purchase order")
    void testGetPurchaseOrder() {
        //arrange
        LocalDate date = LocalDate.now();
        Instant creationDate = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        PurchaseOrder purchaseOrder = this.getPurchaseOrder(creationDate);

        when(purchaseOrderRepository.findById(1)).thenReturn(Optional.of(purchaseOrder));

        List<ProductOfPurchaseOrderResponseDTO> expected = new ArrayList<>();
        ProductOfPurchaseOrderResponseDTO productResponse = new ProductOfPurchaseOrderResponseDTO();
        ProductDetailResponseDto productDetail = new ProductDetailResponseDto();
        productDetail.setId(1);
        productDetail.setName("Product 1");
        productDetail.setType(TypeProduct.FF);
        productDetail.setCreationDate(creationDate);


        productResponse.setProduct(productDetail);
        productResponse.setQuantity(10);

        expected.add(productResponse);

        //act

        List<ProductOfPurchaseOrderResponseDTO> purchaseOrderResponse
                = purchaseOrderService.getProductsOfPurchaseOrder(1);


        //act
        Assertions.assertEquals(
                expected,
                purchaseOrderResponse
        );

    }

    private PurchaseOrder getPurchaseOrder(Instant creationDate){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1);
        purchaseOrder.setBuyer(new UserEntity());
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setStatus("shopping_cart");

        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        product.setId(1);
        product.setPrice(300d);
        product.setType(TypeProduct.FF);
        product.setName("Product 1");
        product.setSeller(new UserEntity());


        product.setCreationDate(creationDate);

        orderDetail.setProduct(product);
        orderDetail.setQuantity(10);
        orderDetail.setOrder(purchaseOrder);
        orderDetail.setQuantity(10);

        purchaseOrder.setOrderDetails(Set.of(orderDetail));

        return purchaseOrder;
    }



}