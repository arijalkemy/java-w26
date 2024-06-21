package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TokenResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.sellers.SellerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.security.JWTAuthenticationConfig;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.RepresentativeServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.RoleEnumUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {
    private final String token = "{token}";
    private final TokenResponseDto expected = new TokenResponseDto(token);

    @Mock
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @Mock
    private SellerServiceImpl sellerServiceImpl;

    @Mock
    private BuyerServiceImpl buyerServiceImpl;

    @Mock
    private RepresentativeServiceImpl representativeServiceImpl;

    @InjectMocks
    private JwtService service;


    @Test
    @DisplayName("generate token seller")
    public void generateTokenSeller() {
        // Arrange
        RoleEnumUtil currentRole = RoleEnumUtil.SELLER;
        Long id = 2L;
        SellerResponseDto seller = new SellerResponseDto(id, "Fries", "papa");

        // Act
        when(sellerServiceImpl.findById(id)).thenReturn(seller);
        when(jwtAuthenticationConfig.getJWTToken(id.toString(), Map.of("role", currentRole))).thenReturn(expected);
        TokenResponseDto actual = service.generateToken(currentRole, id);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.getToken(), actual.getToken());
    }

    @Test
    @DisplayName("generate token buyer")
    public void generateTokenBuyer() {
        // Arrange
        RoleEnumUtil currentRole = RoleEnumUtil.BUYER;
        Long id = 2L;
        BuyerResponseDto buyer = new BuyerResponseDto(id, "904290340", "Daniel", "Hoyos");

        // Act
        when(buyerServiceImpl.findById(id)).thenReturn(buyer);
        when(jwtAuthenticationConfig.getJWTToken(id.toString(), Map.of("role", currentRole))).thenReturn(expected);
        TokenResponseDto actual = service.generateToken(currentRole, id);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.getToken(), actual.getToken());
    }

    @Test
    @DisplayName("generate token representative")
    public void generateTokenRepresentative() {
        // Arrange
        RoleEnumUtil currentRole = RoleEnumUtil.REPRESENTATIVE;
        Long id = 2L;
        RepresentativeResponseDto representative = new RepresentativeResponseDto(id, "Camilo Cardozo");

        // Act
        when(representativeServiceImpl.findById(id)).thenReturn(representative);
        when(jwtAuthenticationConfig.getJWTToken(id.toString(), Map.of("role", currentRole))).thenReturn(expected);
        TokenResponseDto actual = service.generateToken(currentRole, id);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.getToken(), actual.getToken());
    }

    @Test
    @DisplayName("test for user details jwt")
    public void loadUserByUsername() {
        // Arrange
        String username = "1E";
        User expected = new User(username, "", List.of());

        // Act
        UserDetails actual = service.loadUserByUsername(username);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

}
