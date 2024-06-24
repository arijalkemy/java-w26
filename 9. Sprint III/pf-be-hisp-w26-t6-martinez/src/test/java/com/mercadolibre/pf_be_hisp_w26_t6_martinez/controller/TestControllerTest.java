package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

    @InjectMocks
    TestController testController;

    @Test
    void test1() {
        // Arrange
        String expectedResponse = "Hello World";

        // ACT
        String response = this.testController.test().getBody();

        // Assert
        assertEquals(expectedResponse, response);
    }
}