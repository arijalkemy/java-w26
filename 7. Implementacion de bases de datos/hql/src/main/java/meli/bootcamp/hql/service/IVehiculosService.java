package meli.bootcamp.hql.service;

import java.util.List;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;

public interface IVehiculosService {
    List<VehiculoResDto> saveAll(List<VehiculoReqDto> vehiculoReqDtoList);
}
