package meli.bootcamp.hql.service;

import java.util.List;
import java.util.function.Supplier;
import meli.bootcamp.hql.dto.PatenteYMarcaDto;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;
import meli.bootcamp.hql.mapper.VehiculosMapper;
import meli.bootcamp.hql.model.Vehiculo;
import meli.bootcamp.hql.projection.PatenteYMarcaView;
import meli.bootcamp.hql.repository.IVehiculosRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculosServiceImpl implements IVehiculosService {
    IVehiculosRepository vehiculosRepository;
    VehiculosMapper vehiculosMapper;

    public VehiculosServiceImpl(
        IVehiculosRepository vehiculosRepository, VehiculosMapper vehiculosMapper
    ) {
        this.vehiculosRepository = vehiculosRepository;
        this.vehiculosMapper = vehiculosMapper;
    }

    @Override
    public List<VehiculoResDto> saveAll(List<VehiculoReqDto> vehiculoReqDtoList) {
        List<Vehiculo> vehiculosNuevos = vehiculosMapper.toEntityList(vehiculoReqDtoList);
        List<Vehiculo> vehiculosGuardados = vehiculosRepository.saveAll(vehiculosNuevos);
        return vehiculosMapper.toDtoList(vehiculosGuardados);
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculosRepository.findAllPatentes();
    }

    @Override
    public List<PatenteYMarcaDto> findAllPatentesYMarcasOrdenadas(String orden) {
        if (orden.equalsIgnoreCase("asc")) {
            return findAllPatentesYMarcasOrdenadas(
                vehiculosRepository::findAllPatentesYMarcasOrdenadasPorAnioFabricacionAsc);
        }

        return findAllPatentesYMarcasOrdenadas(
            vehiculosRepository::findAllPatentesYMarcasOrdenadasPorAnioFabricacionDesc);
    }

    private List<PatenteYMarcaDto> findAllPatentesYMarcasOrdenadas(
        Supplier<List<PatenteYMarcaView>> findFunction
    ) {
        List<PatenteYMarcaView> patenteYMarcaViews = findFunction.get();
        return vehiculosMapper.patenteYMarcaToDtoList(patenteYMarcaViews);
    }

    @Override
    public List<String> findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio() {
        return vehiculosRepository.findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio();
    }

}
