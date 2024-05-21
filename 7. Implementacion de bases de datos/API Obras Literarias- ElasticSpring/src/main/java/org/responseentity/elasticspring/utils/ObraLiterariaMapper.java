package org.responseentity.elasticspring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.responseentity.elasticspring.dto.ObraLiterariaDTO;

import java.util.ArrayList;
import java.util.List;

public class ObraLiterariaMapper {

    public static List<ObraLiterariaDTO> mapToObraLiterariaDtoList(List<ObraLiteraria> obraLiterariaList){
        List<ObraLiterariaDTO> obraLiterariaDTOS = new ArrayList<>();

        for (ObraLiteraria obraLiteraria: obraLiterariaList){
            obraLiterariaDTOS.add(mapToObraLiterariaDto(obraLiteraria));
        }

        return obraLiterariaDTOS;
    }

    public static ObraLiterariaDTO mapToObraLiterariaDto(ObraLiteraria obraLiteraria){
        return new ObjectMapper().convertValue(obraLiteraria, ObraLiterariaDTO.class);
    }

}
