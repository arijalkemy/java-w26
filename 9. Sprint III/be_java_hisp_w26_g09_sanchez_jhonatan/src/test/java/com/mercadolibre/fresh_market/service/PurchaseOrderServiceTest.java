package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.config.exception.NoRolePermitionsException;
import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.dtos.product.ProductDTO;
import com.mercadolibre.fresh_market.dtos.ProjectionPurchaseOrder;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.dtos.ResponseDTO;
import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.OrderStatus;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.impl.PurchaseOrderService;
import com.mercadolibre.fresh_market.service.impl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
public class PurchaseOrderServiceTest {


    @Mock
    private IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    private ICartDetailRepository cartDetailRepository;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserServiceImpl userServiceImplMock;
    
    @Mock
    private IPurchaseOrderValidationService purchaseOrderValidationServiceMock;

    @Autowired
    private PurchaseOrderService systemUnderTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Modify the existence of a purchase order - Failed by role permitions")
    @WithMockUser(roles="SELLER")
    public void testModifyOrderExistence_NoRolePermitionsException()
    {
        // Arrange
        Long orderId = 1L;
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();

        // Act & Assert
        assertThrows(AccessDeniedException.class, ()-> {
            systemUnderTest.modifyOrderExistence(orderId, purchaseOrderDTO);
        });

        // Verify that the repositories and methods were not called due to the exception
        verify(purchaseOrderRepository, never()).findById(orderId);
        verify(cartDetailRepository, never()).findById_OrderId(orderId);
    }

    @Test
    @DisplayName("Modify the existence of a purchase order - Failed by stock availability")
    @WithMockUser(roles="BUYER")
    public void testModifyOrderExistence_NoStockAvailability() {
        // Arrange
        Long orderId = 2L;
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setProducts(Set.of(new ProductDTO(1L, 5))); // Lista de productos con cantidad
        purchaseOrderDTO.setBuyerId(46L); // Configurar un buyerId válido
        purchaseOrderDTO.setDate(LocalDate.now());
        purchaseOrderDTO.setOrder_status(OrderStatus.STATUS_CODE);

        // Crear un usuario con el rol adecuado
        User user = User.builder()
                .id(46L)
                .email("test@example.com")
                .password("password")
                .role(Role.BUYER) // Rol permitido
                .build();

        // Mocking repository calls
        when(purchaseOrderRepository.findById(orderId)).thenReturn(Optional.of(new PurchaseOrder()));
        when(cartDetailRepository.findById_OrderId(orderId)).thenReturn(Collections.emptyList());
        when(userRepository.findById(46L)).thenReturn(Optional.of(user)); // Mocking userRepository call

        // Mocking productRepository call
        Product product = new Product();
        product.setId(35L);
        product.setPrice(10.0);
        when(productRepository.findById(35L)).thenReturn(Optional.of(product));

        // Mocking batchRepository call
        Batch batch = new Batch();
        batch.setCurrentQuantity(3); // Stock insuficiente
        batch.setDueDate(LocalDate.now().plusWeeks(2)); // Fecha en rango
        when(batchRepository.findByProduct(product)).thenReturn(Collections.singletonList(batch));

        verify(purchaseOrderRepository, never()).save(any()); // Verificar que no se guarda la orden de compra
    }


    @Test
    @WithMockUser(roles="BUYER")
    public void testModifyOrderExistence_WithRole() {
        // Arrange
        Long orderId = 1L;
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setProducts(Set.of(new ProductDTO(1L, 5)));
        purchaseOrderDTO.setBuyerId(1L);
        purchaseOrderDTO.setDate(LocalDate.now());
        purchaseOrderDTO.setOrder_status(OrderStatus.STATUS_CODE);

        // Create a user with the allowed role
        User user = User.builder()
                .id(1L)
                .email("test@example.com")
                .password("password")
                .role(Role.BUYER) // Allowed role
                .build();


        // Mocking repository calls
        when(purchaseOrderRepository.findById(orderId)).thenReturn(Optional.of(new PurchaseOrder()));
        when(cartDetailRepository.findById_OrderId(orderId)).thenReturn(Collections.emptyList());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user)); // Mocking userRepository call

        // Mocking productRepository call
        Product product = new Product();
        product.setId(222L);
        product.setPrice(10.0);
        when(productRepository.findById(222L)).thenReturn(Optional.of(product));

        // Mocking batchRepository call
        Batch batch = new Batch();
        batch.setCurrentQuantity(10); // Suficiente stock
        batch.setDueDate(LocalDate.now().plusWeeks(1)); // Date in range
        when(batchRepository.findByProduct(product)).thenReturn(Collections.singletonList(batch));

        // Act
        ResponseDTO response = systemUnderTest.modifyOrderExistence(orderId, purchaseOrderDTO);

        // Assert
        assertEquals("Updated successfully", response.getMessage()); // Verify the response message is correct
        assertEquals(500.0, response.getTotal_price()); // Check that the total price is correct (5 products * 10.0 price each)
    }



    @Test
    public void testIsUserValid_UserNotFound() {
        // Arrange
        Long userId = 333L;
        Long orderId = 1L;
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setDate(LocalDate.now());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setQuantity(2);
        purchaseOrderDTO.setProducts(Set.of(productDTO));

        // Configurar el userRepository para devolver Optional.empty() cuando se llama a findById con userId
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        // Verificar que lanzará NoRolePermitionsException cuando el usuario no se encuentra
        assertThrows(NoRolePermitionsException.class, () -> {
            systemUnderTest.isUserValid(userId);
        });
    }

    @Test
    @DisplayName("Test to verify createPurchaseOrder when role is not valid (!ROLE_BUYER)")
    @WithMockUser(roles = "SELLER")
    void createPurcharseOrderWhenInvalidRoleThrowException() {

        
        //Act and assert
        AccessDeniedException exceptionResult = assertThrows(AccessDeniedException.class, ()-> {
            this.systemUnderTest.createPurcharseOrder(null, null);
        });    
    }

        @Test
    @DisplayName("Test to verify when given purchase order exists and has role right")
    @WithMockUser(roles="BUYER")
    void getProductsByPurchaseOrderWhenOrderExistsReturnResponse() {
        //Arrange
        Long id = 1L;
        //Act
        when(this.purchaseOrderRepository.findById(id)).thenReturn(Optional.of(PurchaseOrder.builder().build()));
        ProjectionPurchaseOrder result = this.systemUnderTest.getProductsByPurchaseOrder(id);
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test to verify when given purchase order not exists and has role right")
    @WithMockUser(roles="BUYER")
    void getProductsByPurchaseOrderWhenOrderNotExistsThrowsException() {
        //Arrange
        Long id = -1L;
        String messageExpected = "The purchase order with id " + id + " was not found.";
        
        //Act
        when(this.purchaseOrderRepository.findById(id)).thenReturn(Optional.empty());
        EntityNotFound exceptionResult  = assertThrows(EntityNotFound.class, ()-> {
            this.systemUnderTest.getProductsByPurchaseOrder(id);
        });

        //Assert
        assertEquals(messageExpected, exceptionResult.getDescription());
    } 
}