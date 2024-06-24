package com.mercadolibre.pf_be_hisp_w26_t01_ditta.unit.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.controller.ProductController;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.controller.SectionController;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.SectionResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ISectionService;
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
public class SectionControllerTest {
    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private ISectionService sectionService;
    @InjectMocks
    private SectionController sectionController;

    @Test
    public void getAllSection_Ok() {
        //arrange
        HttpStatus expected = HttpStatus.OK;
        String mockedEmail = "asdgmail.com";
        when(authenticationService.getLogMail()).thenReturn(mockedEmail);
        //act
        ResponseEntity<?> obtained = sectionController.getAllSection();
        //assert
        verify(sectionService , atLeast(1)).getAll(mockedEmail);
        assertEquals(expected, obtained.getStatusCode());
    }

    @Test
    public void createNewSection_Ok() {
        //arrange
        HttpStatus expected = HttpStatus.OK;
        String mockedEmail = "asdgmail.com";
        SectionRequestDTO forMock = new SectionRequestDTO();
        when(authenticationService.getLogMail()).thenReturn(mockedEmail);
        //act
        ResponseEntity<?> obtained = sectionController.createNewSection(forMock);
        //assert
        verify(sectionService , atLeast(1)).save(forMock, mockedEmail);
        assertEquals(expected, obtained.getStatusCode());
    }
}
