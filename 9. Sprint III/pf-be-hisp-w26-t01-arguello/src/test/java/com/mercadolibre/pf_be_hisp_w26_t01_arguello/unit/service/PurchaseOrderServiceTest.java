package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.OrderStatusDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.PurchaseOrderService;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IUserService;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils.PurchaseOrderBuilder;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils.PurchaseOrderDtoBuilder;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.utils.UserBuilder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {


    @Mock
    private IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    private IUserService userService;

    @Mock
    private IBatchService batchService;

    @InjectMocks
    private PurchaseOrderService purchaseOrderService;

    @Test
    void calculatePurchaseTotalPriceTestCorrectly(){

        PurchaseOrderDTO purchaseOrderDTO = PurchaseOrderDtoBuilder.getPurchaseOrderDto();
        Double expectedAmount = 5.0D;

        Mockito.when(userService.searchUserById(purchaseOrderDTO.getBuyer_id())).thenReturn(UserBuilder.getUser());
        Mockito.when(batchService.checkProductStock(purchaseOrderDTO.getProducts())).thenReturn(5.0D);
        Assertions.assertEquals(expectedAmount,purchaseOrderService.calculatePurchaseTotalPrice(purchaseOrderDTO).getTotal_price());
        Mockito.verify(purchaseOrderRepository).save(Mockito.any(PurchaseOrder.class));
    }

    @Test
    void searchAllProductsByOrderReturnsListOfMappedDtos() {
        //arrange
        String productName = "Banana";
        int quantity = 3;
        PurchaseOrder mockedOrder = new PurchaseOrder();
        mockedOrder.setOrderItems(List.of(
                OrderItem.builder()
                        .id(1)
                        .product(Product.builder().name(productName).build())
                        .quantity(quantity)
                        .build()
        ));
        Mockito.when(purchaseOrderRepository.findPurchaseOrderById(Mockito.anyInt()))
                .thenReturn(Optional.of(mockedOrder));
        List<ProductPurchaseResponseDto> expected = List.of(
                ProductPurchaseResponseDto.builder()
                        .name(productName)
                        .quantity(quantity)
                        .build()
        );
        //act
        List<ProductPurchaseResponseDto> actual = purchaseOrderService.searchAllProductsByOrder(1);
        //assert
        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findPurchaseOrderById(Mockito.anyInt());
        Assertions.assertIterableEquals(expected,actual);
    }
    @Test
    void searchAllProductsByOrderThrowsApiException() {
        //arrange
        int expectedStatus = 404;
        Mockito.when(purchaseOrderRepository.findPurchaseOrderById(Mockito.anyInt()))
                .thenReturn(Optional.empty());
        //act and assert
        ApiException actual = Assertions.assertThrows(ApiException.class,
                () -> purchaseOrderService.searchAllProductsByOrder(1));
        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findPurchaseOrderById(Mockito.anyInt());
        Assertions.assertEquals(expectedStatus,actual.getStatusCode());
    }

    @Test
    void modifyOrder_Ok() {
        User user = new User();
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO("CARRITO");
        PurchaseOrderDTO orderDTO = new PurchaseOrderDTO(null, 1, orderStatusDTO, List.of());
        Mockito.when(userService.searchUserById(orderDTO.getBuyer_id())).thenReturn(user);

        purchaseOrderService.modifyOrder(1, orderDTO);

        Mockito.verify(purchaseOrderRepository).save(any(PurchaseOrder.class));
    }

    @Test
    void modifyOrder_InvalidArguments() {

        OrderStatusDTO orderStatusDTO = new OrderStatusDTO("Estado invalido");
        PurchaseOrderDTO orderDTO = new PurchaseOrderDTO(null, 1, orderStatusDTO, List.of());

        Assertions.assertThrows(ApiException.class, () -> purchaseOrderService.modifyOrder(1, orderDTO));
    }

}
