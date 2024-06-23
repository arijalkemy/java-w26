package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.controller.InboundOrderController;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IInboundOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InboundOrderControllerTest {

    @Mock
    private  AuthenticationService authenticationService;

    @Mock
    private IInboundOrderService inboundOrderService;

    @InjectMocks
    InboundOrderController inboundOrderController;

    @Test
    void CreateInboundOrder(){
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = createRequest(1);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO(request);


        when(authenticationService.getLogMail()).thenReturn(emailUser);

        BatchStockResponseDTO response = new BatchStockResponseDTO();
        response.setBatch_stock(request.getBatchStock());

        when(inboundOrderService.create(request,emailUser))
                .thenReturn(response);

        //act

        BatchStockResponseDTO result = inboundOrderController.createInboundOrder(inboundOrderRequestDTO).getBody();

        Assertions.assertEquals(1,result.getBatch_stock().size());




    }
    @Test
    void updateInboundOrder(){
        String emailUser = "jgual@gmail.com";
        InboundOrderDto request = createRequest(1);

        InboundOrderRequestDTO inboundOrderRequestDTO = new InboundOrderRequestDTO(request);


        when(authenticationService.getLogMail()).thenReturn(emailUser);

        BatchStockResponseDTO response = new BatchStockResponseDTO();
        response.setBatch_stock(request.getBatchStock());

        when(inboundOrderService.update(request,emailUser))
                .thenReturn(response);

        //act


        BatchStockResponseDTO result = (BatchStockResponseDTO) inboundOrderController.updateInboundOrder(inboundOrderRequestDTO).getBody();

        //Assertions
        Assertions.assertEquals(1,result.getBatch_stock().size());
    }

    InboundOrderDto createRequest(int orderNumber){
        InboundOrderDto request = new InboundOrderDto();
        request.setOrderNumber(orderNumber);
        request.setOrderDate(LocalDate.of(2023, 3, 15));
        SectionDTO sectionDto = new SectionDTO();
        sectionDto.setSection_code(1);
        sectionDto.setWarehouse_code(1);
        request.setSection(sectionDto);
        List<BatchStockDTO> listaStock = Arrays.asList(
                new BatchStockDTO(1,50,5.0,2.0,150,
                        145,
                        LocalDate.of(2023, 3, 15),
                        LocalDateTime.of(2023, 3, 15, 15, 30),
                        LocalDate.of(2025, 3, 15))

        );
        request.setBatchStock(listaStock);

        return request;
    }

    @Test
    public void getOrdersByIdWarehouse_Ok(){

        int idWarehouse = 1;
        String email = "email@gmail.com";
        int expectedCode = 200;

        List<InboundOrderResponseDTO> listInboundOrderResponseDto = new ArrayList<>();

        when(authenticationService.getLogMail()).thenReturn(email);

        when(inboundOrderService.getAllByIdWarehouse(idWarehouse,email)).thenReturn(listInboundOrderResponseDto);

        ResponseEntity<List<InboundOrderResponseDTO>> response = inboundOrderController.
                                                                    getOrdersByIdWarehouse(idWarehouse);

        Assertions.assertEquals(expectedCode, response.getStatusCode().value());
    }

    @Test
    public void getOrderById_Ok(){

        int idOrder = 1;
        String email = "email@gmail.com";
        int expectedCode = 200;

        InboundOrderResponseDTO inboundOrderResponseDto = new InboundOrderResponseDTO();
        inboundOrderResponseDto.setOrder_number(idOrder);

        when(authenticationService.getLogMail()).thenReturn(email);

        when(inboundOrderService.getById(idOrder,email)).thenReturn(inboundOrderResponseDto);

        ResponseEntity<InboundOrderResponseDTO> response = inboundOrderController.
                getOrderById(idOrder);

        Assertions.assertEquals(expectedCode, response.getStatusCode().value());
        Assertions.assertEquals(inboundOrderResponseDto.getOrder_number(),
                Objects.requireNonNull(response.getBody()).getOrder_number());
    }
}
