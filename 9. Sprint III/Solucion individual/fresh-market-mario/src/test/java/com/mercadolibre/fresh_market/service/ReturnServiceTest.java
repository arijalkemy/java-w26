package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.*;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.PurchaseOrder;
import com.mercadolibre.fresh_market.model.Returns;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.repository.IPurchaseOrderRepository;
import com.mercadolibre.fresh_market.repository.IReturnRepository;
import com.mercadolibre.fresh_market.service.impl.ReturnServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReturnServiceTest {


    @Mock
    private IPurchaseOrderRepository iPurchaseOrderRepository;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IReturnRepository returnRepository;

    @InjectMocks
    private ReturnServiceImpl returnService;

    @Test
    public void testCreateReturn() {
        // Arrange
        RequestReturnDTO requestReturnDTO = new RequestReturnDTO(1L, 1L, "reason", "details");
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        Product product = new Product();
        Returns returns = new Returns();
        returns.setId(1L);
        returns.setStatus("PENDIENTE");
        returns.setCreatedAt(LocalDateTime.now());

        when(iPurchaseOrderRepository.findById(1L)).thenReturn(Optional.of(purchaseOrder));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(returnRepository.findByPurchaseOrderAndProduct(purchaseOrder, product)).thenReturn(Optional.empty());
        when(returnRepository.save(any())).thenReturn(returns);

        // Act
        ResponseCreateReturnDTO responseCreateReturnDTO = returnService.createReturn(requestReturnDTO);

        // Assert
        assertEquals(1L, responseCreateReturnDTO.getReturnId());
        assertEquals("PENDIENTE", responseCreateReturnDTO.getStatus());
        assertEquals("Return request created successfully", responseCreateReturnDTO.getMessage());
    }

    @Test
    public void testGetAllReturnsByStatus() {
        // Arrange
        String status = "ALL";
        PurchaseOrder purchaseOrder1 = new PurchaseOrder();
        purchaseOrder1.setId(1L);
        Product product1 = new Product();
        product1.setId(1L);
        Returns return1 = new Returns();
        return1.setId(1L);
        return1.setStatus("PENDIENTE");
        return1.setCreatedAt(LocalDateTime.now());
        return1.setPurchaseOrder(purchaseOrder1);
        return1.setProduct(product1);

        PurchaseOrder purchaseOrder2 = new PurchaseOrder();
        purchaseOrder2.setId(2L);
        Product product2 = new Product();
        product2.setId(2L);
        Returns return2 = new Returns();
        return2.setId(2L);
        return2.setStatus("PENDIENTE");
        return2.setCreatedAt(LocalDateTime.now());
        return2.setPurchaseOrder(purchaseOrder2);
        return2.setProduct(product2);

        List<Returns> returnsList = List.of(return1, return2);

        when(returnRepository.findAll()).thenReturn(returnsList);

        // Act
        List<ResponseReturnsDTO> responseReturnsDTOList = returnService.getAllReturnsByStatus(status);

        // Assert
        assertEquals(2, responseReturnsDTOList.size());
        assertEquals(1L, responseReturnsDTOList.get(0).getReturnId());
        assertEquals("PENDIENTE", responseReturnsDTOList.get(0).getStatus());
        assertEquals(2L, responseReturnsDTOList.get(1).getReturnId());
        assertEquals("PENDIENTE", responseReturnsDTOList.get(1).getStatus());
    }

    @Test
    public void testUpdateReturnStatus() {
        // Arrange
        Long id = 1L;
        RequestUpdateReturnStatusDTO requestUpdateReturnStatusDTO = new RequestUpdateReturnStatusDTO("APPROVED", "comments");
        Returns returns = new Returns();
        returns.setId(id);
        returns.setStatus("PENDIENTE");
        returns.setCreatedAt(LocalDateTime.now());

        when(returnRepository.findById(id)).thenReturn(Optional.of(returns));
        when(returnRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        // Act
        ResponseUpdateReturnStatusDTO responseUpdateReturnStatusDTO = returnService.updateReturnStatus(id, requestUpdateReturnStatusDTO);

        // Assert
        assertEquals(id, responseUpdateReturnStatusDTO.getReturnId());
        assertEquals("APPROVED", responseUpdateReturnStatusDTO.getStatus());
        assertEquals("Return status updated successfully", responseUpdateReturnStatusDTO.getMessage());
    }

    @Test
    public void testGetReturnById() {
        // Arrange
        Long id = 1L;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);
        Product product = new Product();
        product.setId(1L);
        Returns returns = new Returns();
        returns.setId(id);
        returns.setStatus("PENDIENTE");
        returns.setCreatedAt(LocalDateTime.now());
        returns.setPurchaseOrder(purchaseOrder);
        returns.setProduct(product);

        when(returnRepository.findById(id)).thenReturn(Optional.of(returns));

        // Act
        ResponseReturnsDTO responseReturnsDTO = returnService.getReturnById(id);

        // Assert
        assertEquals(id, responseReturnsDTO.getReturnId());
        assertEquals("PENDIENTE", responseReturnsDTO.getStatus());
        assertEquals(purchaseOrder.getId(), responseReturnsDTO.getOrderId());
        assertEquals(product.getId(), responseReturnsDTO.getProductId());
    }
}
