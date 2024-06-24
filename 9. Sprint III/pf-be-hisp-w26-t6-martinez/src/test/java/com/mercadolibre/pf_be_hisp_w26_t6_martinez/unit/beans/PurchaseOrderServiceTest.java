package com.mercadolibre.pf_be_hisp_w26_t6_martinez.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductPurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.OrderStatusDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderInsertRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseWithWarningsDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseWithoutWarningsDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IBatchesRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IProductsRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IUsersRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.purchaseOrder.PurchaseOrderServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.OrderType;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.UserRoles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {
    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    IProductsRepository productsRepository;

    @Mock
    IBatchesRepository batchesRepository;

    @Mock
    IUsersRepository usersRepository;

    @InjectMocks
    PurchaseOrderServiceImpl purchaseOrderService;

    private User buyer;
    private User supervisor;
    private Product product1;
    private Product product2;
    private Batch batchWithEnoughAmountNotAboutToExpireOfProduct;
    private Batch batchWithoutStock;
    private Batch batchSoonToExpire;
    private PurchaseOrderPostResponseWithoutWarningsDto expectedSavedResponseWithoutWarnings;
    private PurchaseOrderPostResponseWithWarningsDto expectedSavedResponseWithWarnings;
    private PurchaseOrderInsertRequestDto successfulSaveRequestDto;
    private PurchaseOrderInsertRequestDto incompleteSaveRequestDto;
    private PurchaseOrderInsertRequestDto unsuccessfulSaveRequestDto;
    private PurchaseOrder purchaseOrder;

    @BeforeEach
    void setUp() {
        ProductPurchaseOrderDto niceProduct = ProductPurchaseOrderDto.builder()
                .productId(1L)
                .quantity(10).build();
        ProductPurchaseOrderDto badProduct = ProductPurchaseOrderDto.builder()
                .productId(2L)
                .quantity(10000)
                .build();
        buyer = User.builder()
                .id(1L)
                .name("Buyer Test")
                .userRole(UserRoles.BUYER)
                .username("yy")
                .hashedPassword("xx")
                .build();
        supervisor = User.builder()
                .id(2L)
                .name("Supervisor Test")
                .userRole(UserRoles.SUPERVISOR)
                .username("xx")
                .hashedPassword("yy")
                .build();
        product1 = Product.builder()
                .id(1L)
                .name("Product 1")
                .storageType(StorageType.FS)
                .unitPrice(1.0)
                .build();
        product2 = Product.builder()
                .id(2L)
                .name("Product 2")
                .storageType(StorageType.FS)
                .unitPrice(2.0)
                .build();
        batchWithEnoughAmountNotAboutToExpireOfProduct = Batch.builder()
                .id(1L)
                .batchNumber(123)
                .product(product1)
                .currentTemperature(10.0)
                .minimumTemperature(1.0)
                .manufacturingDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
                .dueDate(LocalDate.now().plus(5, ChronoUnit.YEARS).atStartOfDay())
                .quantity(100)
                .build();
        batchWithoutStock = Batch.builder()
                .id(2L)
                .batchNumber(123)
                .product(product2)
                .currentTemperature(10.0)
                .minimumTemperature(1.0)
                .manufacturingDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
                .dueDate(LocalDate.now().plus(5, ChronoUnit.YEARS).atStartOfDay())
                .quantity(5)
                .build();
        batchSoonToExpire = Batch.builder()
                .id(3L)
                .batchNumber(123)
                .product(product1)
                .currentTemperature(10.0)
                .minimumTemperature(1.0)
                .manufacturingDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
                .dueDate(LocalDate.now().plus(2, ChronoUnit.WEEKS).atStartOfDay())
                .quantity(5)
                .build();
        expectedSavedResponseWithoutWarnings =
                PurchaseOrderPostResponseWithoutWarningsDto.builder()
                        .totalPrice(10.0)
                        .build();
        expectedSavedResponseWithWarnings =
                PurchaseOrderPostResponseWithWarningsDto.builder()
                        .totalPrice(10.0)
                        .warnings(List.of("There's not enough stock of " + product2.getName() +
                                ". They will be removed from the cart."))
                        .build();
        successfulSaveRequestDto =
                buildCarrito("13-06-2024", 1L, "CARRITO", List.of(niceProduct));
        unsuccessfulSaveRequestDto =
                buildCarrito("13-06-2024", 2L, "CHECKOUT", List.of(niceProduct));
        incompleteSaveRequestDto =
                buildCarrito("13-06-2024", 1L, "CARRITO",
                        List.of(niceProduct, badProduct));
        purchaseOrder = PurchaseOrder.builder()
                .id(1L)
                .date(LocalDate.now())
                .type(OrderType.CARRITO)
                .buyer(buyer)
                .purchaseOrderDetails(List.of(
                        PurchaseOrderDetail.builder()
                                .id(1L)
                                .product(product1)
                                .quantity(10)
                                .build(),
                        PurchaseOrderDetail.builder()
                                .id(2L)
                                .product(product2)
                                .quantity(5)
                                .build()
                ))
                .build();
    }

    @Test
    @DisplayName("Purchase order is saved with all its products")
    public void purchaseOrderIsCorrectlySaved(){
        // Arrange
        Mockito.when(usersRepository.findById(1L)).thenReturn(Optional.of(buyer));
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(product1));
        Mockito.when(batchesRepository.findAllByProduct(product1))
                .thenReturn(List.of(batchWithEnoughAmountNotAboutToExpireOfProduct, batchSoonToExpire));

        // Act
        PurchaseOrderPostResponseDto obtained = purchaseOrderService.addPurchaseOrder(successfulSaveRequestDto);

        // Assert
        Mockito.verify(purchaseOrderRepository, Mockito.times(1)).save(any());
        Assertions.assertEquals(expectedSavedResponseWithoutWarnings, obtained);
    }

    @Test
    @DisplayName("Purchase order with product without enough stock does not count the product")
    public void purchaseOrderWithoutEnoughStockTest(){
        // Arrange
        Mockito.when(usersRepository.findById(1L)).thenReturn(Optional.of(buyer));
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(product1));
        Mockito.when(productsRepository.findById(2L)).thenReturn(Optional.of(product2));
        Mockito.when(batchesRepository.findAllByProduct(product1))
                .thenReturn(List.of(batchWithEnoughAmountNotAboutToExpireOfProduct, batchSoonToExpire));
        Mockito.when(batchesRepository.findAllByProduct(product2)).thenReturn(List.of(batchWithoutStock));

        // Act
        PurchaseOrderPostResponseDto obtained = purchaseOrderService.addPurchaseOrder(incompleteSaveRequestDto);

        // Assert
        Mockito.verify(purchaseOrderRepository, Mockito.times(1)).save(any());
        Assertions.assertEquals(expectedSavedResponseWithWarnings, obtained);
    }

    @Test
    @DisplayName("Purchase order throws exception when user not found")
    public void purchaseOrderThrowsExceptionWhenUserNotFoundTest(){
        // Arrange
        Mockito.when(usersRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> purchaseOrderService.addPurchaseOrder(successfulSaveRequestDto));
    }

    @Test
    @DisplayName("Purchase order throws exception when user is not buyer")
    public void purchaseOrderThrowsExceptionWhenUserIsNotBuyerTest(){
        // Arrange
        Mockito.when(usersRepository.findById(2L)).thenReturn(Optional.of(supervisor));

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> purchaseOrderService.addPurchaseOrder(unsuccessfulSaveRequestDto));
    }

    @Test
    @DisplayName("Purchase order throws exception when status code is not CARRITO")
    public void purchaseOrderThrowsExceptionWhenStatusCodeIsInvalid(){
        // Arrange
        Mockito.when(usersRepository.findById(2L)).thenReturn(Optional.of(buyer));
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(product1));

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> purchaseOrderService.addPurchaseOrder(unsuccessfulSaveRequestDto));
    }

    @Test
    @DisplayName("Purchase order throws exception when product is not found")
    public void purchaseOrderThrowsExceptionWhenProductNotFound(){
        // Arrange
        Mockito.when(usersRepository.findById(1L)).thenReturn(Optional.of(buyer));
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> purchaseOrderService.addPurchaseOrder(successfulSaveRequestDto));
    }

    @Test
    @DisplayName("Get purchase order for valid id returns the products of created order")
    public void getPurchaseOrderForValidIdTest(){
        // Arrange
        PurchaseOrderProductsResponseDto expectedResponse = PurchaseOrderProductsResponseDto.builder()
                .products(List.of(
                        PurchaseOrderProductResponseDto.builder()
                                .productId(product1.getId())
                                .name(product1.getName())
                                .quantity(10)
                                .build(),
                        PurchaseOrderProductResponseDto.builder()
                                .productId(product2.getId())
                                .name(product2.getName())
                                .quantity(5)
                                .build()
                ))
                .build();

        Mockito.when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.of(purchaseOrder));

        // Act
        PurchaseOrderProductsResponseDto obtained = purchaseOrderService.getPurchaseOrderProducts(1L);

        // Assert
        Assertions.assertEquals(expectedResponse, obtained);
    }

    @Test
    @DisplayName("Get purchase order without valid ID throws exception")
    public void getPurchaseOrderWithoutValidIdTest(){
        // Arrange
        Mockito.when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> purchaseOrderService.getPurchaseOrderProducts(1L));
    }

    @Test
    @DisplayName("Update of existing purchase order is done correctly")
    public void updateOfExistingPurchaseOrderTest(){
        // Arrange
        Mockito.when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.of(purchaseOrder));
        Mockito.when(usersRepository.findById(1L)).thenReturn(Optional.of(buyer));
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(product1));
        Mockito.when(batchesRepository.findAllByProduct(product1))
                .thenReturn(List.of(batchWithEnoughAmountNotAboutToExpireOfProduct, batchSoonToExpire));

        // Act
        PurchaseOrderPostResponseDto obtained =
                purchaseOrderService.updatePurchaseOrder(successfulSaveRequestDto, 1L);

        // Assert
        Mockito.verify(purchaseOrderRepository, Mockito.times(1)).save(any());
        Assertions.assertEquals(expectedSavedResponseWithoutWarnings, obtained);
    }

    @Test
    @DisplayName("Update of invalid PurchaseOrderId throws exception")
    public void invalidUpdateOfPurchaseOrderIdTest(){
        // Arrange
        Mockito.when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> purchaseOrderService.updatePurchaseOrder(successfulSaveRequestDto, 1L));
    }

    private PurchaseOrderInsertRequestDto buildCarrito
            (String date, Long buyerId, String statusCode, List<ProductPurchaseOrderDto> productsDtos) {
        return PurchaseOrderInsertRequestDto.builder()
                .purchaseOrderDto(PurchaseOrderDto.builder()
                        .date(date)
                        .buyerId(buyerId)
                        .orderStatusDto(OrderStatusDto.builder()
                                .statusCode(statusCode)
                                .build())
                        .products(productsDtos).build())
                .build();
    }
}
