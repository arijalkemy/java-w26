package com.mercadolibre.final_project_java_hisp_w26_t1.unit.controller;

import com.mercadolibre.final_project_java_hisp_w26_t1.authentication.AuthenticationService;
import com.mercadolibre.final_project_java_hisp_w26_t1.controller.InboundOrderController;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.*;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IInboundOrdenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InboundOrderControllerTest {

    @Mock
    private  AuthenticationService authenticationService;

    @Mock
    private  IInboundOrdenService inboundOrderService;

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
}
