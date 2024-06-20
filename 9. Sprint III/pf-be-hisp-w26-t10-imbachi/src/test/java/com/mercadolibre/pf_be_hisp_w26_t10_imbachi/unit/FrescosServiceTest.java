package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.ShoppingCartProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.FrescosServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FrescosServiceTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    private IShoppingCartRepository shoppingCartRepository;

    @Mock
    private IShoppingCartProductRepository shoppingCartProductRepository;

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private FrescosServiceImpl frescosService;

    @Test
    @DisplayName("US-2-Issue-5 Create new purchase order")
    void createOrderHappyPathTest() {
        // Arrange
        LocalDate minDueDate = LocalDate.now().plusWeeks(3);
        List<Product> products = List.of(ShoppingCartUtils.getProductOne());

        PurchaseOrderDto order = new PurchaseOrderDto(
                new PurchaseOrderDetailsDto(
                        LocalDate.now(),
                        1,
                        new OrderStatusDto("shopping_cart"),
                        List.of(new ProductRequestDto(products.get(0).getId(), 10))));

        PurchaseValueResponseDto expected = new PurchaseValueResponseDto(
                (products.get(0).getPrice()
                        * order.getDetails().getProducts().get(0).getQuantity()));

        ShoppingCart newPurchaseOrder = new ShoppingCart();
        newPurchaseOrder.setOrderDate(order.getDetails().getDate());
        newPurchaseOrder.setOrderState(order.getDetails().getOrderStatus().getStatusCode());
        UserAccount user = new UserAccount();
        user.setUserId(order.getDetails().getBuyerId().longValue());
        newPurchaseOrder.setUser(user);

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(
                newPurchaseOrder.getId(), //REVISAR AQUI PLS
                newPurchaseOrder,
                products.get(0),
                order.getDetails().getProducts().get(0).getQuantity());

        when(batchRepository.findByProductIdAndDueDateAfterAndCurrentQuantityGreaterThanEqual(
                products.get(0).getId(), minDueDate,
                order.getDetails().getProducts().get(0).getQuantity()))
                .thenReturn(List.of(ShoppingCartUtils.getBatchOne()));
        when(shoppingCartRepository.save(any())).thenReturn(newPurchaseOrder);
        when(productRepository.findById(any())).thenReturn(Optional.of(products.get(0)));
        when(shoppingCartProductRepository.save(any())).thenReturn(shoppingCartProduct);

        // Act
        PurchaseValueResponseDto actual = frescosService.createOrder(order);
        // Assert
        assertEquals(expected.getTotal(), actual.getTotal());
    }
    @Test
    @DisplayName("US-2-Issue-5 Create new purchase order Sad Path")
    void createOrderSadPathTest() {
        LocalDate minDueDate = LocalDate.now().plusWeeks(3);
        Integer invalidProductId = -1;

        PurchaseOrderDto order = new PurchaseOrderDto(
                new PurchaseOrderDetailsDto(
                        LocalDate.now(),
                        1,
                        new OrderStatusDto("shopping_cart"),
                        List.of(new ProductRequestDto(-1, 10))));

        when(batchRepository.findByProductIdAndDueDateAfterAndCurrentQuantityGreaterThanEqual(
                invalidProductId, minDueDate,
                order.getDetails().getProducts().get(0).getQuantity()))
                .thenReturn(List.of());

        String actual = assertThrows(
                NotFoundException.class, () -> frescosService.createOrder(order))
                .getMessage();
        assertEquals("No tienes productos validos en el carrito", actual);
    }

}
