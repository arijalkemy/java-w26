package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.OrderStatusRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.ProductOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductOrderTotalDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.UserIdNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.*;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IUserRepository;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderServiceImplTest {

    @Mock
    private IPurchaseOrderRepository purchaseOrderRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductOrderServiceImpl productOrderService;

    @Test
    @DisplayName("Obtener todos los productos de un pedido con un id valido")
    void getAllByPurchaseOrderId_withValidId() {
        // Arrange
        Long purchaseOrderId = 1L;
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        List<ProductOrderDTO> productOrderDTOList = List.of(productOrderDTO);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);
        purchaseOrder.setBuyer(new User());

        purchaseOrder.setProductOrders(List.of(new ProductOrder(new Product(), 1)));

        when(purchaseOrderRepository.findById(purchaseOrderId)).thenReturn(Optional.of(purchaseOrder));

        // Act
        List<ProductOrderDTO> result = productOrderService.getAllByPurchaseOrderId(purchaseOrderId);

        // Assert
        assertEquals(productOrderDTOList.size(), result.size());
    }

    @Test
    @DisplayName("Obtener todos los productos de un pedido con un id invalido")
    void getAllByPurchaseOrderId_withInvalidId() {
        // Arrange
        Long purchaseOrderId = 1L;

        when(purchaseOrderRepository.findById(purchaseOrderId)).thenThrow(new ProductNotFoundException("The list of products is empty"));

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productOrderService.getAllByPurchaseOrderId(purchaseOrderId));
    }

    @Test
    @DisplayName("Actualizar un pedido con un id valido")
    void updateOrder_ShouldUpdateOrder_WhenValidRequest() {
        //Arrange
        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setBuyerId(1L);
        purchaseOrderRequestDTO.setDate(LocalDate.of(2023, 3,12));
        purchaseOrderRequestDTO.setStatus(new OrderStatusRequestDTO("carrito"));
        purchaseOrderRequestDTO.setProducts(List.of(new ProductOrderRequestDTO(1L, 2)));
        String expected= "[ProductOrderDTO(product=ProductDTO(id=1, productType=null, description=null, price=null)" +
                ", quantity=2)]";
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);
        purchaseOrder.setBuyer(new User());

        User user = new User();
        user.setId(1L);

        Product product = new Product();
        product.setId(1L);

        when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.of(purchaseOrder));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        //Act
        List<ProductOrderDTO> result = productOrderService.updateOrder(1L, purchaseOrderRequestDTO);

        //Assert
        verify(purchaseOrderRepository).save(purchaseOrder);
        assertEquals(expected, result.toString());
    }

    @Test
    @DisplayName("Actualizar un pedido con un id invalido")
    void updateOrder_withInvalidId() {
        // Arrange
        Long idOrder = 1L;
        PurchaseOrderRequestDTO body = new PurchaseOrderRequestDTO();

        when(purchaseOrderRepository.findById(idOrder)).thenThrow(new ProductNotFoundException("The purchase order not found"));

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productOrderService.updateOrder(idOrder, body));
    }

    @Test
    @DisplayName("Actualizar un pedido con un id valido y un usuario invalido")
    void updateOrder_withInvalidUserId() {
        // Arrange
        Long idOrder = 1L;
        PurchaseOrderRequestDTO body = new PurchaseOrderRequestDTO();

        when(purchaseOrderRepository.findById(idOrder)).thenReturn(Optional.of(new PurchaseOrder()));
        when(userRepository.findById(body.getBuyerId())).thenThrow(new UserIdNotFoundException("The User by id " + body.getBuyerId() + " not exist in db"));

        // Act & Assert
        assertThrows(UserIdNotFoundException.class, () -> productOrderService.updateOrder(idOrder, body));
    }

    @Test
    @DisplayName("Crear un pedido con un id valido")
    void postOrder() {
        //Arrange
        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setBuyerId(1L);
        purchaseOrderRequestDTO.setDate(LocalDate.of(2023, 3, 12));
        purchaseOrderRequestDTO.setStatus(new OrderStatusRequestDTO("carrito"));
        purchaseOrderRequestDTO.setProducts(List.of(new ProductOrderRequestDTO(1L, 2)));
        ProductOrderTotalDTO expected = new ProductOrderTotalDTO(3.0);

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        User user = new User();
        user.setId(1L);
        Product product = new Product();
        product.setId(1L);
        product.setPrice(1.5);

        purchaseOrder.setBuyer(user);
        purchaseOrder.setDate(LocalDate.of(2023, 3, 12));
        purchaseOrder.setStatus("carrito");
        purchaseOrder.setProductOrders(List.of(new ProductOrder(product, 2)));

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(purchaseOrderRepository.save(purchaseOrder)).thenReturn(purchaseOrder);

        //Act
        ProductOrderTotalDTO result = productOrderService.saveOrder(purchaseOrderRequestDTO);

        //Assert
        verify(purchaseOrderRepository).save(purchaseOrder);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Crear un pedido con un producto invalido")
    void postOrderWithInvalidProductId(){
        //Arrange
        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setBuyerId(1L);
        purchaseOrderRequestDTO.setDate(LocalDate.of(2023, 3, 12));
        purchaseOrderRequestDTO.setStatus(new OrderStatusRequestDTO("carrito"));
        purchaseOrderRequestDTO.setProducts(List.of(new ProductOrderRequestDTO(1L, 2)));

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        User user = new User();

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(productRepository.findById(1L)).thenThrow(new ProductNotFoundException("Product not found"));
        //when(purchaseOrderRepository.save(purchaseOrder)).thenReturn(purchaseOrder);

        //Act & Assert
        assertThrows(ProductNotFoundException.class, () -> productOrderService.saveOrder(purchaseOrderRequestDTO));
    }

    @Test
    @DisplayName("Crear un pedido con un usuario invalido")
    void postOrderWithInvalidUserId() {
        // Arrange
        PurchaseOrderRequestDTO body = PurchaseOrderRequestDTO.builder()
                .buyerId(1L)
                .build();

        when(userRepository.findById(1L)).thenThrow(new UserIdNotFoundException("The User by id " + body.getBuyerId() + " not exist in db"));

        // Act & Assert
        assertThrows(UserIdNotFoundException.class, () -> productOrderService.saveOrder(body));

    }
}
