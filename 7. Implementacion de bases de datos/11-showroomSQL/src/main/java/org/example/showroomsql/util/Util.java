package org.example.showroomsql.util;

import org.example.showroomsql.dto.RequestClothesDTO;
import org.example.showroomsql.dto.RequestSaleDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.dto.ResponseSaleDTO;
import org.example.showroomsql.model.Clothes;
import org.example.showroomsql.model.Sale;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Util {
    static ModelMapper mapper = new ModelMapper();

    public static ResponseClothesDTO mapToClothesDTO(Clothes clothes) {
        return mapper.map(clothes, ResponseClothesDTO.class);
    }

    public static Clothes mapToClothesEntity(RequestClothesDTO RequestClothesDTO) {
        return mapper.map(RequestClothesDTO, Clothes.class);
    }

    public static ResponseSaleDTO mapToSaleDTO(Sale sale) {
        List<ResponseClothesDTO> listClothes = sale.getClothes().stream().map(c -> mapper.map(c, ResponseClothesDTO.class)).toList();
        ResponseSaleDTO responseSaleDTO = mapper.map(sale, ResponseSaleDTO.class);
        responseSaleDTO.setClothes(listClothes);
        return responseSaleDTO;
    }

    public static Sale mapToSaleEntity(RequestSaleDTO requestSaleDTO) {
        List<Clothes> listClothes = requestSaleDTO.getClothes().stream().map(c -> mapper.map(c, Clothes.class)).toList();
        Sale sale = mapper.map(requestSaleDTO, Sale.class);
        sale.setClothes(listClothes);
        return sale;
    }
}
