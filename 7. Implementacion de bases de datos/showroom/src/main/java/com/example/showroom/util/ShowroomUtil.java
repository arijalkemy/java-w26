package com.example.showroom.util;


import com.example.showroom.dto.request.ClothRequestDTO;
import com.example.showroom.dto.request.SaleRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.SaleDTO;
import com.example.showroom.entity.Cloth;
import com.example.showroom.entity.Sale;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ShowroomUtil {
    private static ModelMapper mapper = new ModelMapper();

    public static List<ClothDTO> getClothesDTO(List<Cloth> cloths){
        return cloths.stream()
                .map(ShowroomUtil::clotheToClotheDto)
                .collect(Collectors.toList());
    }

    public static ClothDTO clotheToClotheDto(Cloth clote) {
        return mapper.map(clote, ClothDTO.class);
    }

    public static Cloth clotheRequestDTOToClothe(ClothRequestDTO clothe) {
        return mapper.map(clothe, Cloth.class);
    }

    public static Sale saleRequestDTOToSale(SaleRequestDTO sale) { return mapper.map(sale, Sale.class);}

    public static List<SaleDTO> getSalesDTO(List<Sale> sales){
        return sales.stream()
                .map(ShowroomUtil::saleToSaleDto)
                .collect(Collectors.toList());
    }

    public static SaleDTO saleToSaleDto(Sale sale) {
        return mapper.map(sale, SaleDTO.class);
    }

}
