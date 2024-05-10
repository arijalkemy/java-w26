package org.example.romansnumbertesting.controller;

import org.example.romansnumbertesting.dto.RomanDto;
import org.example.romansnumbertesting.service.IRomanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RomanControllerTest {
    @Mock
    private IRomanService service;
    @InjectMocks
    private RomanController controller;

    @Test
    public void testRomanControllerEncodeNumber() {
        String expected = "VII";
        HttpStatus statusExpected = HttpStatus.OK;
        // act
        when(service.encodeRomanNumber(7)).thenReturn(new RomanDto(expected));
        ResponseEntity<RomanDto> actual = controller.decodeRomanNumber(7);

        // assert
        Assertions.assertEquals(expected, actual.getBody().getRoman());
        Assertions.assertEquals(statusExpected, actual.getStatusCode());
    }
}
