package meli.bootcamp.hql.service;

import java.util.List;
import meli.bootcamp.hql.dto.PatenteYMarcaDto;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;

public interface IVehiculosService {
    List<VehiculoResDto> saveAll(List<VehiculoReqDto> vehiculoReqDtoList);

    List<String> findAllPatentes();

    List<PatenteYMarcaDto> findAllPatentesYMarcasOrdenadas(String orden);

    List<String> findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio();
}
