package co.com.mercadolibre.siniestros.service.impl;

import co.com.mercadolibre.siniestros.dto.PatenteMarcaDTO;
import co.com.mercadolibre.siniestros.dto.ResponseDTO;
import co.com.mercadolibre.siniestros.dto.SumaDTO;
import co.com.mercadolibre.siniestros.entity.projection.VehiculoProjection;
import co.com.mercadolibre.siniestros.entity.Vehiculo;
import co.com.mercadolibre.siniestros.entity.projection.VehiculoSumProjection;
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
    public List<ResponseDTO> listarMatriculaMarcaYModeloConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaYModeloConSiniestroMayor().stream()
                .map(VehiculoService::mapToResponseDTO)
                .toList();
    }

    @Override
    public List<SumaDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor().stream()
                .map(VehiculoService::mapToSumaDTO)
                .toList();

    }

    private PatenteMarcaDTO convertToDtoMarcaPatente(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, PatenteMarcaDTO.class);
    }

    private static ResponseDTO mapToResponseDTO(VehiculoProjection vehiculoProjection) {
        return new ResponseDTO(vehiculoProjection.getPatente(), vehiculoProjection.getMarca(), vehiculoProjection.getModelo());
    }

private static SumaDTO mapToSumaDTO(VehiculoSumProjection vehiculoSumProjection) {
        return new SumaDTO(vehiculoSumProjection.getPatente(), vehiculoSumProjection.getMarca(), vehiculoSumProjection.getModelo(), vehiculoSumProjection.getSuma());
    }
}
