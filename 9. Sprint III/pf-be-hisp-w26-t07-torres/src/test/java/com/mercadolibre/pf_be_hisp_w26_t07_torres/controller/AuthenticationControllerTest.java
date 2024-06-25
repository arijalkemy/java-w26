package com.mercadolibre.pf_be_hisp_w26_t07_torres.controller;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TokenResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.RoleEnumUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {
    private final String token = "{token}";

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthenticateController controller;

    @Test
    @DisplayName("generate token by buyer")
    public void generateTokenByBuyer() {
        // Arrange
        Long id = 1L;
        TokenResponseDto expected = new TokenResponseDto(token);

        // Act
        mockService(id, RoleEnumUtil.BUYER, expected);
        ResponseEntity<TokenResponseDto> current = controller.authenticateBuyer(id);

        // Assert
        assertionToken(expected, current);
    }

    @Test
    @DisplayName("generate token by seller")
    public void generateTokenBySeller() {
        // Arrange
        Long id = 1L;
        TokenResponseDto expected = new TokenResponseDto(token);

        // Act
        mockService(id, RoleEnumUtil.SELLER, expected);
        ResponseEntity<TokenResponseDto> current = controller.authenticateSeller(id);

        // Assert
        assertionToken(expected, current);
    }

    @Test
    @DisplayName("generate token by representative")
    public void generateTokenByRepresentative() {
        // Arrange
        Long id = 1L;
        TokenResponseDto expected = new TokenResponseDto(token);

        // Act
        mockService(id, RoleEnumUtil.REPRESENTATIVE, expected);
        ResponseEntity<TokenResponseDto> current = controller.authenticateRepresentative(id);

        // Assert
        assertionToken(expected, current);
    }

    private void mockService(Long id, RoleEnumUtil role, TokenResponseDto expected) {
        when(jwtService.generateToken(role, id)).thenReturn(expected);
    }

    private void assertionToken(TokenResponseDto expected, ResponseEntity<TokenResponseDto> response) {
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expected, response.getBody());
    }
}
