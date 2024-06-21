package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors.SimpleProductErrorDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.order.OrderStatusRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductPurchaseOrderRequestDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.PurchaseOrderDetailsRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.*;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.BadRequestException;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.*;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.TestDataGenerator;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.MessageError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @Mock
    private IBuyerRepository buyerRepository;
    @Mock
    private IStateRepository statusRepository;
    @Mock
    private IProductSellerRepository productSellerRepository;
    @Mock
    private IOrderProductSellerRepository orderProductSellerRepository;
    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private IOrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Save: Buyer does not exist")
    void saveProductListTest_BuyerNotExist() {
        // Arrange
        Long nonexistentId = 11111L;
        when(buyerRepository.findById(nonexistentId)).thenReturn(Optional.empty());

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(nonexistentId.intValue())
                                .build()
                )
                .build();
        // Act
        // Assert
        NotFoundException thrownEx = assertThrows(
                NotFoundException.class,
                () -> orderService.saveProductList(purchaseOrderRequestDTO)
        );
        assertEquals(MessageError.BUYER_NOT_FOUND.getMessage(), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Save: User must have just one order")
    void saveProductListTest_OnlyOneOrder() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        when(orderRepository.existsByBuyerId(buyerId)).thenReturn(true);

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .build()
                )
                .build();
        // Act
        // Assert
        BadRequestException thrownEx = assertThrows(
                BadRequestException.class,
                () -> orderService.saveProductList(purchaseOrderRequestDTO)
        );
        assertEquals(MessageError.USER_ALREADY_HAS_AN_ORDER.getMessage(), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Save: Status does not exist")
    void saveProductListTest_StatusNotExist() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String nonexistentStatusName = "NON_EXISTENT_STATUS_NAME";
        when(statusRepository.findFirstByDescription(nonexistentStatusName)).thenReturn(Optional.empty());

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(nonexistentStatusName)
                                                .build()
                                )
                                .build()
                )
                .build();
        // Act
        // Assert
        NotFoundException thrownEx = assertThrows(
                NotFoundException.class,
                () -> orderService.saveProductList(purchaseOrderRequestDTO)
        );
        assertEquals(MessageError.STATUS_NOT_FOUND.getMessage(), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Save: Product in request is empty")
    void saveProductListTest_EmptyProductList() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(new ArrayList<>())
                                .build()
                )
                .build();
        // Act
        // Assert
        BadRequestException thrownEx = assertThrows(
                BadRequestException.class,
                () -> orderService.saveProductList(purchaseOrderRequestDTO)
        );
        assertEquals(MessageError.PRODUCT_LIST_NOT_EXIST.getMessage(), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Save: Product does not exist")
    void saveProductListTest_ProductNotExist() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto nonExistentProduct = TestDataGenerator.getProductOrderWithId(9999);
        productsListDto.add(nonExistentProduct);
        lenient().when(productSellerRepository.findById(
                nonExistentProduct.getProductId().longValue())
        ).thenReturn(Optional.empty());

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(productsListDto)
                                .build()
                )
                .build();

        List<SimpleProductErrorDto> productErrorDtoList = new ArrayList<>();
        SimpleProductErrorDto productErrorDto = SimpleProductErrorDto
                .builder()
                .productId(nonExistentProduct.getProductId())
                .errorDescription(MessageError.PRODUCTS_NOT_FOUND.getMessage())
                .build();
        productErrorDtoList.add(productErrorDto);

        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(0.0)
                .productErrorDto(productErrorDtoList)
                .build();
        // Act
        TotalPriceResponseDTO responseDTO = orderService.saveProductList(purchaseOrderRequestDTO);
        // Assert
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("Save: Product has no batch")
    void saveProductListTest_NoBatch() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);
        Double productSellerPrice = 1500.0;

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto noBatchProduct = TestDataGenerator.getProductOrderWithId(8888);
        productsListDto.add(noBatchProduct);
        Long noBatchProductId = noBatchProduct.getProductId().longValue();
        ProductSeller productSeller = TestDataGenerator.getProductSellerWithIdAndPrice(noBatchProductId, productSellerPrice);
        when(productSellerRepository.findById(
                noBatchProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(productSeller));

        when(batchRepository.findBatchesByProductSellerId(noBatchProductId)).thenReturn(Optional.empty());

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(productsListDto)
                                .build()
                )
                .build();

        List<SimpleProductErrorDto> productErrorDtoList = new ArrayList<>();
        SimpleProductErrorDto productErrorDto = SimpleProductErrorDto
                .builder()
                .productId(noBatchProduct.getProductId())
                .errorDescription(MessageError.PRODUCTS_BATCH_NOT_FOUND.getMessage())
                .build();
        productErrorDtoList.add(productErrorDto);

        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(0.0)
                .productErrorDto(productErrorDtoList)
                .build();
        // Act
        TotalPriceResponseDTO responseDTO = orderService.saveProductList(purchaseOrderRequestDTO);
        // Assert
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("Save: Product has no stock")
    void saveProductListTest_NoStock() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);
        Double productSellerPrice = 1500.0;

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto noStockProduct = TestDataGenerator.getProductOrderWithId(8888);
        productsListDto.add(noStockProduct);
        Long noStockProductId = noStockProduct.getProductId().longValue();
        ProductSeller productSeller = TestDataGenerator.getProductSellerWithIdAndPrice(noStockProductId, productSellerPrice);
        when(productSellerRepository.findById(
                noStockProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(productSeller));

        Batch noStockBatch = TestDataGenerator.getBatchWithProps(7777L, productSeller, false, false);
        when(
                batchRepository.findBatchesByProductSellerId(noStockProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(noStockBatch));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(productsListDto)
                                .build()
                )
                .build();

        List<SimpleProductErrorDto> productErrorDtoList = new ArrayList<>();
        SimpleProductErrorDto productErrorDto = SimpleProductErrorDto
                .builder()
                .productId(noStockProduct.getProductId())
                .errorDescription(MessageError.PRODUCTS_STOCK.getMessage())
                .build();
        productErrorDtoList.add(productErrorDto);

        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(0.0)
                .productErrorDto(productErrorDtoList)
                .build();
        // Act
        TotalPriceResponseDTO responseDTO = orderService.saveProductList(purchaseOrderRequestDTO);
        // Assert
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("Save: Product is about to expire")
    void saveProductListTest_AboutToExpire() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);
        Double productSellerPrice = 1500.0;

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto expiredProduct = TestDataGenerator.getProductOrderWithId(8888);
        productsListDto.add(expiredProduct);
        Long expiredProductId = expiredProduct.getProductId().longValue();
        ProductSeller productSeller = TestDataGenerator.getProductSellerWithIdAndPrice(expiredProductId, productSellerPrice);
        when(productSellerRepository.findById(
                expiredProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(productSeller));

        Batch expiredBatch = TestDataGenerator.getBatchWithProps(77L, productSeller, true, true);
        when(
                batchRepository.findBatchesByProductSellerId(expiredProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(expiredBatch));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(productsListDto)
                                .build()
                )
                .build();

        List<SimpleProductErrorDto> productErrorDtoList = new ArrayList<>();
        SimpleProductErrorDto productErrorDto = SimpleProductErrorDto
                .builder()
                .productId(expiredProduct.getProductId())
                .errorDescription(MessageError.PRODUCTS_EXPIRED.getMessage())
                .build();
        productErrorDtoList.add(productErrorDto);

        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(0.0)
                .productErrorDto(productErrorDtoList)
                .build();
        // Act
        TotalPriceResponseDTO responseDTO = orderService.saveProductList(purchaseOrderRequestDTO);
        // Assert
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("Save: Ok creation")
    void saveProductListTest_Ok() {
        // Arrange
        Long buyerId = 1L;
        Buyer buyer = TestDataGenerator.getBuyerWithCustomId(buyerId);
        when(buyerRepository.findById(buyerId)).thenReturn(TestDataGenerator.getOptionalObject(buyer));

        String statusName = "carrito";
        Status status = TestDataGenerator.getStatusWithName(statusName);
        when(statusRepository.findFirstByDescription(statusName)).thenReturn(TestDataGenerator.getOptionalObject(status));

        LocalDate testDate = LocalDate.of(2024, 1, 1);
        double expectedFinalPrice = 7500.0;
        double productSellerPrice = 1500.0;

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto okProduct = TestDataGenerator.getOrderProductsWithIdAndQuantity(7, 5);
        productsListDto.add(okProduct);
        Long okProductId = okProduct.getProductId().longValue();
        ProductSeller productSeller = TestDataGenerator.getProductSellerWithIdAndPrice(okProductId, productSellerPrice);
        when(
                productSellerRepository.findById(okProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(productSeller));

        Batch okBatch = TestDataGenerator.getBatchWithProps(77L, productSeller, true, false);
        when(
                batchRepository.findBatchesByProductSellerId(okProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(okBatch));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(testDate)
                                .products(productsListDto)
                                .build()
                )
                .build();
        ProductSeller testProductSeller = TestDataGenerator.getProductSellerWithIdAndPrice(okProductId, productSellerPrice);
        Double expectedPrice = okProduct.getQuantity().doubleValue() * testProductSeller.getPrice().doubleValue();
        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(expectedPrice)
                .build();

        Order order = Order
                .builder()
                .buyer(TestDataGenerator.getBuyerWithCustomId(buyerId))
                .date(testDate)
                .status(status)
                .total(BigDecimal.valueOf(expectedFinalPrice))
                .build();
        Order returnOrder = Order
                .builder()
                .id(1L)
                .buyer(TestDataGenerator.getBuyerWithCustomId(buyerId))
                .date(testDate)
                .status(status)
                .total(BigDecimal.valueOf(expectedFinalPrice))
                .build();
        when(orderRepository.save(order)).thenReturn(returnOrder);
        List<OrderProductSeller> orderProductSellerList = new ArrayList<>();
        orderProductSellerList.add(
                OrderProductSeller
                        .builder()
                        .productSeller(testProductSeller)
                        .quantity(okProduct.getQuantity())
                        .price(BigDecimal.valueOf(expectedFinalPrice))
                        .order(returnOrder)
                        .build()
        );
        when(orderProductSellerRepository.saveAll(orderProductSellerList)).thenReturn(null);
        // Act
        TotalPriceResponseDTO responseDTO = orderService.saveProductList(purchaseOrderRequestDTO);
        // Assert
        verify(orderRepository, atLeast(1)).save(order);
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("Test - Find products by order id 1")
    void findProductsByOrderWithId1Test() {
        // Arrange
        Long id = 1L;
        Order order = DataUtils.getOrderById1();
        List<IProductResponseProjection> products = DataUtils.getProductsResponseProjection();
        List<ProductResponseDTO> expected = DataUtils.getProductsResponseDTO();
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(productSellerRepository.findAllByOrderId(id)).thenReturn(products);
        // Act
        List<ProductResponseDTO> result = orderService.findProductsByOrder(id);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test - Find products by order id 3 And Order not exist - exception")
    void findProductsByOrderWithId3AndOrderNotExistTest() {
        // Arrange
        Long id = 3L;
        when(orderRepository.findById(id)).thenReturn(Optional.ofNullable(null));
        // Act - Assert
        assertThrows(NotFoundException.class, () -> orderService.findProductsByOrder(id));
    }

    @Test
    @DisplayName("Test - Find products by order id 1 And without products - exception")
    void findProductsByOrderWithId3AndWithoutProductsTest() {
        Long id = 1L;
        Order order = DataUtils.getOrderById1();
        List<IProductResponseProjection> products = new ArrayList<>();
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        when(productSellerRepository.findAllByOrderId(id)).thenReturn(products);
        // Act - Assert
        assertThrows(NotFoundException.class, () -> orderService.findProductsByOrder(id));
    }

    @Test
    @DisplayName("Update: Order exists")
    void updateProductListTest_OrderExists() {
        // Arrange
        Long nonExistentOrderId = 9999L;

        when(orderRepository.findById(nonExistentOrderId)).thenReturn(Optional.empty());

        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .build();

        // Act
        // Assert
        NotFoundException thrownEx = assertThrows(
                NotFoundException.class,
                () -> orderService.updateProductList(nonExistentOrderId, requestDTO)
        );
        assertEquals(MessageError.ORDER_NOT_FOUND.getMessage(nonExistentOrderId), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Update: Buyer from request matches with order")
    void updateProductListTest_BuyerMatches() {
        // Arrange
        Long orderId = 1L;
        Long wrongBuyerId = 9999L;
        Double orderTotal = 7500.0;
        Order mockOrder = TestDataGenerator.getOrderWithProps(
                orderId, wrongBuyerId, orderTotal, false);

        when(orderRepository.findById(orderId))
                .thenReturn(TestDataGenerator.getOptionalObject(mockOrder));

        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(wrongBuyerId.intValue())
                                .date(LocalDate.now())
                                .build()
                )
                .build();
        // Act
        // Assert
        BadRequestException thrownEx = assertThrows(
                BadRequestException.class,
                () -> orderService.updateProductList(orderId, requestDTO)
        );
        assertEquals(MessageError.BUYER_NOT_MATCHES_ORDER.getMessage(wrongBuyerId), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Update: Product list must not be empty")
    void updateProductListTest_ProductListNotEmpty() {
        // Arrange
        Long orderId = 1L;
        Long buyerId = 2L;
        String statusName = "carrito";
        Double orderTotal = 7500.0;
        Order mockOrder = TestDataGenerator.getOrderWithProps(
                orderId, buyerId, orderTotal, true);

        when(orderRepository.findById(orderId))
                .thenReturn(TestDataGenerator.getOptionalObject(mockOrder));

        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(LocalDate.now())
                                .products(new ArrayList<>())
                                .build()
                )
                .build();
        // Act
        // Assert
        BadRequestException thrownEx = assertThrows(
                BadRequestException.class,
                () -> orderService.updateProductList(orderId, requestDTO)
        );
        assertEquals(MessageError.PRODUCT_LIST_NOT_EXIST.getMessage(), thrownEx.getMessage());
    }

    @Test
    @DisplayName("Update: Ok response")
    void updateProductListTest_Ok() {
        // Arrange
        Long orderId = 1L;
        Long buyerId = 2L;
        String statusName = "carrito";
        double productSellerPrice = 1500.0;
        int productQuantity = 5;
        double orderTotal = productQuantity * productSellerPrice;
        Order mockOrder = TestDataGenerator.getOrderWithProps(
                orderId, buyerId, orderTotal, true);

        when(orderRepository.findById(orderId))
                .thenReturn(TestDataGenerator.getOptionalObject(mockOrder));

        List<ProductPurchaseOrderRequestDto> productsListDto = new ArrayList<>();
        ProductPurchaseOrderRequestDto okProduct = TestDataGenerator.getOrderProductsWithIdAndQuantity(7, productQuantity);
        productsListDto.add(okProduct);
        Long okProductId = okProduct.getProductId().longValue();

        ProductSeller productSeller = TestDataGenerator.getProductSellerWithIdAndPrice(okProductId, productSellerPrice);
        when(
                productSellerRepository.findById(okProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(productSeller));

        Batch okBatch = TestDataGenerator.getBatchWithProps(77L, productSeller, true, false);
        when(
                batchRepository.findBatchesByProductSellerId(okProductId)
        ).thenReturn(TestDataGenerator.getOptionalObject(okBatch));

        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(
                        PurchaseOrderDetailsRequestDTO.builder()
                                .buyerId(buyerId.intValue())
                                .orderStatus(
                                        OrderStatusRequestDTO.builder()
                                                .statusCode(statusName)
                                                .build()
                                )
                                .date(LocalDate.now())
                                .products(productsListDto)
                                .build()
                )
                .build();

        List<OrderProductSeller> orderProductSellerList = new ArrayList<>();
        orderProductSellerList.add(
                OrderProductSeller
                        .builder()
                        .productSeller(productSeller)
                        .quantity(okProduct.getQuantity())
                        .price(BigDecimal.valueOf(orderTotal))
                        .order(mockOrder)
                        .build()
        );

        when(orderProductSellerRepository.saveAll(orderProductSellerList)).thenReturn(null);

        TotalPriceResponseDTO expectedResponse = TotalPriceResponseDTO
                .builder()
                .totalPrice(orderTotal)
                .build();
        // Act
        TotalPriceResponseDTO responseDTO = orderService.updateProductList(orderId, requestDTO);
        // Assert
        verify(orderProductSellerRepository, atLeast(1)).saveAll(orderProductSellerList);
        assertThat(responseDTO).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

}