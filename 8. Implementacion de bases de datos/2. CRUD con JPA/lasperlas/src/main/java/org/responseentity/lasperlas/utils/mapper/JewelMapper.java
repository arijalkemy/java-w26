package org.responseentity.lasperlas.utils.mapper;

import org.responseentity.lasperlas.dto.JoyaDTO;
import org.responseentity.lasperlas.model.Jewel;

public class JewelMapper {
    public static Jewel dtoToEntity(JoyaDTO joyaDTO){
        return Jewel.builder()
                .id(joyaDTO.getNro_identificatorio())
                .name(joyaDTO.getNombre())
                .material(joyaDTO.getMaterial())
                .weight(joyaDTO.getPeso())
                .particularity(joyaDTO.getParticularidad())
                .hasStone(joyaDTO.getPosee_piedra())
                .isForSale(joyaDTO.getVentaONo())
                .build();
    }

    public static JoyaDTO entityToDTO(Jewel jewel){
        return JoyaDTO.builder()
                .nro_identificatorio(jewel.getId())
                .nombre(jewel.getName())
                .material(jewel.getMaterial())
                .peso(jewel.getWeight())
                .particularidad(jewel.getParticularity())
                .posee_piedra(jewel.getHasStone())
                .ventaONo(jewel.getIsForSale())
                .build();
    }
}
