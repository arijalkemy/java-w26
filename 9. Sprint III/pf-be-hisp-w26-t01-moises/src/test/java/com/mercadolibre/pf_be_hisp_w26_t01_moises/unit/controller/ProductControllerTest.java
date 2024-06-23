package com.mercadolibre.pf_be_hisp_w26_t01_moises.unit.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.authentication.AuthenticationService;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.controller.ProductController;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IBatchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private IBatchService batchService;
    @InjectMocks
    private ProductController productController;



    @Test
    @DisplayName("Get product location returns ResponseEntity with status Ok")
    public void getProductLocation_Ok() {
        //arrange
        HttpStatus expected = HttpStatus.OK;
        String mockedEmail = "asd@asd.com";
        when(authenticationService.getLogMail()).thenReturn(mockedEmail);
        //act
        ResponseEntity<?> actual = productController.getProductLocation(
                1,
                BatchOrderType.C
        );
        //assert
        verify(batchService , atLeast(1))
                .getProductLocation(mockedEmail,1,BatchOrderType.C);
        assertEquals(expected, actual.getStatusCode());
    }

}
