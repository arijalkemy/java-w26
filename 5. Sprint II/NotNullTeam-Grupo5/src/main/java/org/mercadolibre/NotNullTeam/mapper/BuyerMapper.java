package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseWithNotBuyerListDTO;
import org.mercadolibre.NotNullTeam.model.Buyer;

import java.util.List;

public class BuyerMapper {

    public static BuyerResponseDTO toBuyerResponseDTO(Buyer buyer, List<SellerResponseWithNotBuyerListDTO> sellers) {
        return BuyerResponseDTO.builder()
                .user_id(buyer.getUser().getId())
                .user_name(buyer.getUsername())
                .sellers(sellers)
                .build();
    }

    public static BuyerResponseWithNotSellerListDTO toBuyerResponseWithNotSellerListDTO(Buyer buyer) {
        return BuyerResponseWithNotSellerListDTO.builder()
                .id(buyer.getUser().getId())
                .name(buyer.getUser().getName())
                .build();
    }

    public static List<BuyerResponseWithNotSellerListDTO> toListBuyerResponseWithNotSellerListDTO(List<Buyer> buyerList) {
        return buyerList.stream().map(BuyerMapper::toBuyerResponseWithNotSellerListDTO).toList();
    }

}
