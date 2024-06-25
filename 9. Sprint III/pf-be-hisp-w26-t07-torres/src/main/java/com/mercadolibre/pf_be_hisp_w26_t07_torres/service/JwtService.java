package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.DecodedJwt;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TokenResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.sellers.SellerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.JwtException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.security.JWTAuthenticationConfig;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IBuyerService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IRepresentativeService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.ISellerService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.RoleEnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JwtService implements UserDetailsService {
    private final IBuyerService buyerService;
    private final ISellerService sellerService;
    private final IRepresentativeService representativeService;
    private final JWTAuthenticationConfig jwtAuthenticationConfig;

    public JwtService(@Autowired ISellerService sellerService,
                      @Autowired IRepresentativeService representativeService,
                      @Autowired IBuyerService buyerService,
                      @Autowired JWTAuthenticationConfig jwtAuthenticationConfig) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.representativeService = representativeService;
        this.jwtAuthenticationConfig = jwtAuthenticationConfig;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, "", List.of());
    }

    public TokenResponseDto generateToken(RoleEnumUtil role, Long id) {
        return switch (role) {
            case SELLER -> {
                SellerResponseDto current = sellerService.findById(id);
                yield jwtAuthenticationConfig.getJWTToken(current.getId().toString(), Map.of("role", RoleEnumUtil.SELLER));
            }
            case BUYER -> {
                BuyerResponseDto current = buyerService.findById(id);
                yield jwtAuthenticationConfig.getJWTToken(current.getId().toString(), Map.of("role", RoleEnumUtil.BUYER));
            }
            case REPRESENTATIVE -> {
                RepresentativeResponseDto current = representativeService.findById(id);
                yield jwtAuthenticationConfig.getJWTToken(current.getId().toString(), Map.of("role", RoleEnumUtil.REPRESENTATIVE));
            }
        };
    }

    public TokenResponseDto refreshToken(String authorization) {
        DecodedJwt decodedJwt;
        try {
            decodedJwt = jwtAuthenticationConfig.decodeToken(authorization);
        } catch (JsonProcessingException ex) {
            throw new JwtException("There was an error refreshing the token");
        }
        Long id = Long.valueOf(decodedJwt.getSub());
        RoleEnumUtil role = RoleEnumUtil.fromString(decodedJwt.getRole());
        return generateToken(role, id);
    }
}
