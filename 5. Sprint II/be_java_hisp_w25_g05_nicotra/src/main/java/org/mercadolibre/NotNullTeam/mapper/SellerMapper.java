package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseWithNotBuyerListDTO;
import org.mercadolibre.NotNullTeam.model.Seller;

import java.util.List;

public class SellerMapper {

    public static SellerResponseWithNotBuyerListDTO toSellerResponseWithNotBuyerListDTO(Seller seller) {
        return SellerResponseWithNotBuyerListDTO.builder()
                .user_id(seller.getUser().getId())
                .user_name(seller.getUsername())
                .build();
    }

    public static List<SellerResponseWithNotBuyerListDTO> toListSellerResponseWithNotBuyerListDTO(List<Seller> sellerList) {
        return sellerList.stream().map(SellerMapper::toSellerResponseWithNotBuyerListDTO).toList();
    }

    public static SellerResponseDTO toSellerResponseDTO(Seller seller, List<BuyerResponseWithNotSellerListDTO> buyers){
        return SellerResponseDTO.builder()
                .id(seller.getUser().getId())
                .name(seller.getUsername())
                .followers(buyers)
                .build();
    }
}
