package org.mercadolibre.NotNullTeam.mapper;

import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseWithNotBuyerListDTO;
import org.mercadolibre.NotNullTeam.model.Buyer;

import java.util.List;

public class BuyerMapper {

    public static BuyerResponseDTO toBuyerResponseDTO(Buyer buyer, List<SellerResponseWithNotBuyerListDTO> sellers) {
        return new BuyerResponseDTO(
                buyer.getUser().getId(),
                buyer.getUser().getName(),
                sellers
        );
    }

    public static BuyerResponseWithNotSellerListDTO toBuyerResponseWithNotSellerListDTO(Buyer buyer) {
        return new BuyerResponseWithNotSellerListDTO(buyer.getUser().getId(), buyer.getUser().getName());
    }

    public static List<BuyerResponseWithNotSellerListDTO> toListBuyerResponseWithNotSellerListDTO(List<Buyer> buyerList) {
        return buyerList.stream().map(BuyerMapper::toBuyerResponseWithNotSellerListDTO).toList();
    }

}
