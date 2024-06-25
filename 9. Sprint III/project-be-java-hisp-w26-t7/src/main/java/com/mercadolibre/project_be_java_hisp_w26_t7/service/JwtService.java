package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TokenResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.sellers.SellerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.security.JWTAuthenticationConfig;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IBuyerService;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IRepresentativeService;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.ISellerService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.RoleEnumUtil;
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
}
