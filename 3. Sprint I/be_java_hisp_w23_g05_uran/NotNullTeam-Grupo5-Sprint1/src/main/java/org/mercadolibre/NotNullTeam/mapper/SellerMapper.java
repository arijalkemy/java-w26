package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerResponseWithNotBuyerListDTO;
import org.mercadolibre.NotNullTeam.model.Seller;

import java.util.List;

public class SellerMapper {

    public static SellerResponseWithNotBuyerListDTO toSellerResponseWithNotBuyerListDTO(Seller seller) {
        return new SellerResponseWithNotBuyerListDTO(seller.getUser().getId(), seller.getUser().getName());
    }

    public static List<SellerResponseWithNotBuyerListDTO> toListSellerResponseWithNotBuyerListDTO(List<Seller> sellerList) {
        return sellerList.stream().map(SellerMapper::toSellerResponseWithNotBuyerListDTO).toList();
    }

    public static SellerResponseDTO toSellerResponseDTO(Seller seller, List<BuyerResponseWithNotSellerListDTO> buyers){
        return new SellerResponseDTO(
                seller.getUser().getId(),
                seller.getUser().getName(),
                buyers
        );
    }
}
