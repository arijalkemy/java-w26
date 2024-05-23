package co.com.mercadolibre.siniestros.service.impl;

import co.com.mercadolibre.siniestros.dto.MarcaModeloPatenteDTO;
import co.com.mercadolibre.siniestros.dto.PatenteMarcaDTO;
import co.com.mercadolibre.siniestros.dto.VehiculoDTO;
import co.com.mercadolibre.siniestros.entity.Vehiculo;
import co.com.mercadolibre.siniestros.repository.IVehiculoRepository;
import co.com.mercadolibre.siniestros.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<String> listarTodasLasPatentes() {
        return vehiculoRepository.listarTodasLasPatentes().stream()
                .toList();
    }

    @Override
    public List<PatenteMarcaDTO> listarPatentesYMarcaOrdenadoPorAnio() {
        return vehiculoRepository.findByOrderByAnioDeFabricacionAsc().stream()
                .map(this::convertToDtoMarcaPatente)
                .toList();
    }

    @Override
    public List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio() {
        return vehiculoRepository.listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio().stream()
                .toList();
    }

    @Override
    public List<VehiculoDTO> listarMatriculaMarcaYModeloConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaYModeloConSiniestroMayor().stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor().stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class))
                .toList();

    }

    private VehiculoDTO convertToDto(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    private PatenteMarcaDTO convertToDtoMarcaPatente(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, PatenteMarcaDTO.class);
    }
}
