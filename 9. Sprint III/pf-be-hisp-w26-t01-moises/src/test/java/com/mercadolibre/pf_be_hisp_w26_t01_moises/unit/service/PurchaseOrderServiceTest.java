package com.mercadolibre.pf_be_hisp_w26_t01_moises.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.OrderStatusDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.PurchaseOrderSortingType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.PurchaseOrderService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IUserServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.utils.PurchaseOrderBuilder;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.utils.PurchaseOrderDtoBuilder;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {


    @Mock
    private IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    private IUserServiceInternal userService;

    @Mock
    private IBatchService batchService;

    @InjectMocks
    private PurchaseOrderService purchaseOrderService;

    @Test
    void calculatePurchaseTotalPriceTestCorrectly() {

        PurchaseOrderDTO purchaseOrderDTO = PurchaseOrderDtoBuilder.getPurchaseOrderDto();
        Double expectedAmount = 5.0D;

        Mockito.when(userService.searchUserById(purchaseOrderDTO.getBuyerId())).thenReturn(UserBuilder.getUser());
        Mockito.when(batchService.checkProductStock(purchaseOrderDTO.getProducts())).thenReturn(5.0D);
        Assertions.assertEquals(expectedAmount, purchaseOrderService.calculatePurchaseTotalPrice(purchaseOrderDTO).getTotal_price());
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
        Assertions.assertIterableEquals(expected, actual);
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
        Assertions.assertEquals(expectedStatus, actual.getStatusCode());
    }


    @Test
    void getAllByBuyerEmailSortedThrowsApiException() {
        //arrange
        User mockedUser = UserBuilder.getUser();
        Mockito.when(userService.searchByEmail(mockedUser.getEmail())).thenReturn(mockedUser);
        Mockito.when(purchaseOrderRepository.findAllByUser_Id(1)).thenReturn(List.of());
        String expectedMessage = "No se encontraron ordenes pertenecientes al comprador";
        int expectedStatus = 404;
        //act and assert
        ApiException actual = Assertions.assertThrows(ApiException.class,
                () -> purchaseOrderService.getAllByBuyerEmailSorted(mockedUser.getEmail(),Optional.empty()));

        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findAllByUser_Id(1);
        Assertions.assertEquals(expectedStatus, actual.getStatusCode());
        Assertions.assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void getAllByBuyerEmailSortedReturnsUnsortedList() {
        //arrange
        User mockedUser = UserBuilder.getUser();
        List<PurchaseOrder> mockedOrder = List.of(PurchaseOrderBuilder.getPurchaseOrder());
        Mockito.when(userService.searchByEmail(mockedUser.getEmail())).thenReturn(mockedUser);
        Mockito.when(purchaseOrderRepository.findAllByUser_Id(1))
                .thenReturn(mockedOrder);
        List<PurchaseOrderResponseDTO> expected = List.of(PurchaseOrderDtoBuilder.getPurchaseOrderResponseDto());
        //act
        List<PurchaseOrderResponseDTO> actual =
                purchaseOrderService.getAllByBuyerEmailSorted(mockedUser.getEmail(), Optional.empty());
        //assert
        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findAllByUser_Id(1);
        Assertions.assertIterableEquals(expected, actual);
    }
    @Test
    void getAllByBuyerEmailSortedReturnsListSortedByDate() {
        //arrange
        User mockedUser = UserBuilder.getUser();
        List<PurchaseOrder> mockedOrder = PurchaseOrderBuilder.getListWithDifferentDates();
        Mockito.when(userService.searchByEmail(mockedUser.getEmail())).thenReturn(mockedUser);
        Mockito.when(purchaseOrderRepository.findAllByUser_Id(1))
                .thenReturn(mockedOrder);
        List<PurchaseOrderResponseDTO> expected = PurchaseOrderDtoBuilder.getResponseListWithDifferentDatesOrdered();
        //act
        List<PurchaseOrderResponseDTO> actual = purchaseOrderService.getAllByBuyerEmailSorted(
                mockedUser.getEmail(),
                Optional.of(PurchaseOrderSortingType.date)
        );
        //assert
        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findAllByUser_Id(1);
        Assertions.assertIterableEquals(expected, actual);
    }
    @Test
    void getAllByBuyerEmailSortedReturnsListSortedByPrice() {
        //arrange
        User mockedUser = UserBuilder.getUser();
        List<PurchaseOrder> mockedOrder = PurchaseOrderBuilder.getListWithDifferentPrices();
        Mockito.when(userService.searchByEmail(mockedUser.getEmail())).thenReturn(mockedUser);
        Mockito.when(purchaseOrderRepository.findAllByUser_Id(1))
                .thenReturn(mockedOrder);
        List<PurchaseOrderResponseDTO> expected = PurchaseOrderDtoBuilder.getResponseListWithDifferentPricesOrdered();
        //act
        List<PurchaseOrderResponseDTO> actual = purchaseOrderService.getAllByBuyerEmailSorted(
                mockedUser.getEmail(),
                Optional.of(PurchaseOrderSortingType.total)
        );
        //assert
        Mockito.verify(purchaseOrderRepository, Mockito.atLeastOnce()).findAllByUser_Id(1);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void modifyOrder_Ok() {
        User user = new User();
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO("CARRITO");
        PurchaseOrderDTO orderDTO = new PurchaseOrderDTO(null, 1, orderStatusDTO, List.of());
        Mockito.when(userService.searchUserById(orderDTO.getBuyerId())).thenReturn(user);

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
