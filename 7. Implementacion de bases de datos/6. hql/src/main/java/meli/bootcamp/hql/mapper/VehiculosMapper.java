package meli.bootcamp.hql.mapper;

import java.util.List;
import meli.bootcamp.hql.dto.PatenteYMarcaDto;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;
import meli.bootcamp.hql.model.Vehiculo;
import meli.bootcamp.hql.projection.PatenteYMarcaView;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehiculosMapper {
    ModelMapper modelMapper;

    public VehiculosMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Vehiculo toEntity(VehiculoReqDto vehiculoReqDto) {
        return modelMapper.map(vehiculoReqDto, Vehiculo.class);
    }

    private VehiculoResDto toDto(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, VehiculoResDto.class);
    }

    public List<Vehiculo> toEntityList(List<VehiculoReqDto> vehiculoReqDtoList) {
        return vehiculoReqDtoList.stream()
            .map(this::toEntity)
            .toList();
    }

    public List<VehiculoResDto> toDtoList(List<Vehiculo> vehiculosGuardados) {
        return vehiculosGuardados.stream()
            .map(this::toDto)
            .toList();
    }

    public PatenteYMarcaDto patenteYMarcaToDto(PatenteYMarcaView patenteYMarcaView) {
        return new PatenteYMarcaDto(patenteYMarcaView.getPatente(), patenteYMarcaView.getMarca());
    }

    public List<PatenteYMarcaDto> patenteYMarcaToDtoList(List<PatenteYMarcaView> views) {
        return views.stream()
            .map(this::patenteYMarcaToDto)
            .toList();
    }
}
