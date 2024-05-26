package org.responseentity.elasticspring.utils.mapper;

import org.responseentity.elasticspring.domain.ObraLiteraria;
import org.responseentity.elasticspring.dto.ObraLiterariaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ObraLiterariaMapper {
    public static ObraLiterariaDTO entidadADTO(ObraLiteraria entidad) {
        return ObraLiterariaDTO.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .autor(entidad.getAutor())
                .cantidadPaginas(entidad.getCantidadPaginas())
                .editorial(entidad.getEditorial())
                .anioPrimerPublicacion(entidad.getAnioPrimerPublicacion())
                .build();
    }

    public static ObraLiteraria dtoAEntidad(ObraLiterariaDTO dto) {
        return ObraLiteraria.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .autor(dto.getAutor())
                .cantidadPaginas(dto.getCantidadPaginas())
                .editorial(dto.getEditorial())
                .anioPrimerPublicacion(dto.getAnioPrimerPublicacion())
                .build();
    }

    public static List<ObraLiterariaDTO> listaEntidadesAListaDTOs(List<ObraLiteraria> entidades) {
        return entidades.stream()
                .map(ObraLiterariaMapper::entidadADTO)
                .collect(Collectors.toList());
    }

    public static List<ObraLiteraria> listaDTOsAListaEntidades(List<ObraLiterariaDTO> dtos) {
        return dtos.stream()
                .map(ObraLiterariaMapper::dtoAEntidad)
                .collect(Collectors.toList());
    }
}
