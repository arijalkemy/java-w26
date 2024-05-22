package meli.bootcamp.hql.mapper;

import java.util.List;
import meli.bootcamp.hql.dto.SiniestroReqDto;
import meli.bootcamp.hql.dto.SiniestroResDto;
import meli.bootcamp.hql.model.Siniestro;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SiniestrosMapper {
    ModelMapper modelMapper;

    public SiniestrosMapper() {
        modelMapper = new ModelMapper();
    }

    public Siniestro toEntity(SiniestroReqDto siniestroReqDto) {
        return modelMapper.map(siniestroReqDto, Siniestro.class);
    }

    public List<Siniestro> toEntityList(List<SiniestroReqDto> siniestroReqDtos) {
        return siniestroReqDtos.stream().map(this::toEntity).toList();
    }

    public List<SiniestroResDto> toDtoList(List<Siniestro> siniestrosGuardados) {
        return siniestrosGuardados.stream().map(this::toDto).toList();
    }

    private SiniestroResDto toDto(Siniestro siniestro) {
        return modelMapper.map(siniestro, SiniestroResDto.class);
    }
}
