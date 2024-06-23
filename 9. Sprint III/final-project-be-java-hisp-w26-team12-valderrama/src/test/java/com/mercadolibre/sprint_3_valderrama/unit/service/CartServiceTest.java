package com.mercadolibre.sprint_3_valderrama.unit.service;

import com.mercadolibre.sprint_3_valderrama.dto.request.CartDTO;
import com.mercadolibre.sprint_3_valderrama.entity.Cart;
import com.mercadolibre.sprint_3_valderrama.entity.Product;
import com.mercadolibre.sprint_3_valderrama.entity.ProductInCart;
import com.mercadolibre.sprint_3_valderrama.entity.User;
import com.mercadolibre.sprint_3_valderrama.enums.Category;
import com.mercadolibre.sprint_3_valderrama.enums.OrderStatus;
import com.mercadolibre.sprint_3_valderrama.exceptions.ApiException;
import com.mercadolibre.sprint_3_valderrama.repository.ICartRepository;
import com.mercadolibre.sprint_3_valderrama.service.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private ICartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    Cart cartMock;

    /**
     * Setups the test variables.
     */
    @BeforeEach
    void setup() {
        //Create a cart with products
        cartMock = new Cart();
        cartMock.setBuyer(User.builder().id(1L).build());
        cartMock.setOrderStatus(OrderStatus.CARRITO);
        cartMock.setCarDate(Date.valueOf("2024-10-10"));
        cartMock.setId(1L);
        ProductInCart productInCart1 = new ProductInCart(1L,10, new Product(1L,"Sample 1",43.5, Category.FF,null,null), cartMock);
        ProductInCart productInCart2 = new ProductInCart(2L,5, new Product(2L,"Sample 2",23.5, Category.FF,null,null), cartMock);
        cartMock.setProducts(List.of(productInCart1,productInCart2));
        cartMock.setTotalPrice(cartMock.getProducts().stream().mapToDouble(productInCart -> productInCart.getProduct().getPrice() * productInCart.getQuantity()).sum());

    }

    /**
     * Test to get all products in the cart. Happy path.
     */
    @Test
    @DisplayName("Test to get all products in the cart. Happy path.")
    void getALlProductsInTheCartTest() {
        //Arrange - Mock the repository
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
        // Act
        CartDTO serviceCart = cartService.getCart(1L);
        // Assert
        assert serviceCart.getPurchaseOrder().getIdBuyer().equals(1);
        assert serviceCart.getPurchaseOrder().getProductDTO().size() == 2;
        assert serviceCart.getPurchaseOrder().getProductDTO().get(0).getQuantity() == 10;
        assert serviceCart.getPurchaseOrder().getProductDTO().get(1).getQuantity() == 5;
        assert serviceCart.getPurchaseOrder().getProductDTO().get(0).getIdProduct().equals(1);
        assert serviceCart.getPurchaseOrder().getProductDTO().get(1).getIdProduct().equals(2);
    }

    /**
     * Test to get all products in the cart. Cart not found.
     */
    @Test
    @DisplayName("Test to get all products in the cart. Cart not found.")
    void getALlProductsInTheCartCartNotFoundTest() {
        //Arrange - Mock the repository
        when(cartRepository.findById(1L)).thenReturn(Optional.empty());
        // Act and Assert
        assertThrows(ApiException.class, () -> cartService.getCart(1L));
    }

//    /**
//     * Test to the validation of the fields of the cart. CarDate is null.
//     */
//    @Test
//    @DisplayName("Test to the validation of the fields of the cart. CarDate is null.")
//    void validateCartFieldsCarDateIsNullTest() {
//        //Arrange - Mock the repository
//        cartMock.setCarDate(null);
//        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
//        // Act and Assert
//        assertThrows(ApiException.class, () -> cartService.getCart(1L));
//    }

    /**
     * Test to the validation of the fields of the cart. Buyer is null.
     */
    @Test
    @DisplayName("Test to the validation of the fields of the cart. Buyer is null.")
    void validateCartFieldsBuyerIsNullTest() {
        //Arrange - Mock the repository
        cartMock.setBuyer(null);
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
        // Act and Assert
        assertThrows(ApiException.class, () -> cartService.getCart(1L));
    }

    /**
     * Test to the validation of the fields of the cart. Buyer ID is null.
     */
    @Test
    @DisplayName("Test to the validation of the fields of the cart. Buyer ID is null.")
    void validateCartFieldsBuyerIdIsNullTest() {
        //Arrange - Mock the repository
        cartMock.getBuyer().setId(null);
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
        // Act and Assert
        assertThrows(ApiException.class, () -> cartService.getCart(1L));
    }

    /**
     * Test to the validation of the fields of the cart. OrderStatus is null.
     */
    @Test
    @DisplayName("Test to the validation of the fields of the cart. OrderStatus is null.")
    void validateCartFieldsOrderStatusIsNullTest() {
        //Arrange - Mock the repository
        cartMock.setOrderStatus(null);
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
        // Act and Assert
        assertThrows(ApiException.class, () -> cartService.getCart(1L));
    }

    /**
     * Test to the validation of the fields of the cart. Products is null.
     */
    @Test
    @DisplayName("Test to the validation of the fields of the cart. Products is null.")
    void validateCartFieldsProductsIsNullTest() {
        //Arrange - Mock the repository
        cartMock.setProducts(null);
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cartMock));
        // Act and Assert
        assertThrows(ApiException.class, () -> cartService.getCart(1L));
    }

}
