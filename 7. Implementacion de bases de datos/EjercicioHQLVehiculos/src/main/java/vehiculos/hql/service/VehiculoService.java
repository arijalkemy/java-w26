package vehiculos.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vehiculos.hql.dto.*;
import vehiculos.hql.model.Siniestro;
import vehiculos.hql.model.Vehiculo;
import vehiculos.hql.model.projection.PatenteAndMarca;
import vehiculos.hql.repository.ISiniestroRepository;
import vehiculos.hql.repository.IVehiculoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ISiniestroRepository siniestroRepository;
    private final ObjectMapper objectMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository, ISiniestroRepository siniestroRepository, ObjectMapper objectMapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroRepository = siniestroRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public VehiculoResponseDto saveVehiculo(VehiculoRequestDto vehiculoRequestDto) {
        Vehiculo vehiculo = vehiculoRepository.save(mapToVehiculo(vehiculoRequestDto));
        return mapToVehiculoResponseDto(vehiculo);
    }

    @Override
    @Transactional
    public SiniestroResponseDto saveSiniestro(SiniestroRequestDto siniestroRequestDto) {
        Siniestro siniestro = mapToSiniestro(siniestroRequestDto);

        siniestro.setVehiculo(vehiculoRepository.findById(siniestroRequestDto.getVehiculo_id()).get());
        Siniestro siniestroR = siniestroRepository.save(siniestro);
        return mapToSiniestroResponseDto(siniestroR);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculoResponseWithSiniestroDto> findAll() {
        return vehiculoRepository.findAll()
                .stream()
                .map(vehiculo -> {
                    VehiculoResponseWithSiniestroDto vehiculoResponseWithSiniestroDto = objectMapper.convertValue(vehiculo, VehiculoResponseWithSiniestroDto.class);
                    Set<SiniestroRequestDto> siniestroRequestDtoList = vehiculo.getSiniestros().stream()
                            .map(siniestro -> objectMapper.convertValue(siniestro, SiniestroRequestDto.class))
                            .collect(Collectors.toSet());
                    vehiculoResponseWithSiniestroDto.setSiniestros(siniestroRequestDtoList);
                    return vehiculoResponseWithSiniestroDto;
                })
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> getPatentesAndMarca() {
        return vehiculoRepository.findAllPatentesAndMarcaOrderedByAnoFabricacion();
    }

    @Override
    public List<?> getPatentesModeloAndMarca() {
        return vehiculoRepository.findAllVehiculosWithSiniestroGreaterThan10000();
    }

    @Override
    public List<?> getRuedas() {
        return vehiculoRepository.findAllPatentesWithMoreThanFourWheelsAndFabricatedThisYear();
    }

    @Override
    public List<?> getPerdidaTotal() {
        return vehiculoRepository.findAllVehiculosWithSiniestroGreaterThan10000AndTotalLoss();
    }


    private Vehiculo mapToVehiculo(VehiculoRequestDto vehiculoRequestDto) {
        return objectMapper.convertValue(vehiculoRequestDto, Vehiculo.class);
    }

    private VehiculoRequestDto mapToVehiculoRequestDto(Vehiculo vehiculo) {
        return objectMapper.convertValue(vehiculo, VehiculoRequestDto.class);
    }

    private VehiculoResponseDto mapToVehiculoResponseDto(Vehiculo vehiculo) {
        return objectMapper.convertValue(vehiculo, VehiculoResponseDto.class);
    }

    private SiniestroResponseDto mapToSiniestroResponseDto(Siniestro siniestro) {
        return objectMapper.convertValue(siniestro, SiniestroResponseDto.class);
    }

    private Siniestro mapToSiniestro(SiniestroRequestDto siniestroRequestDto) {
        return objectMapper.convertValue(siniestroRequestDto, Siniestro.class);
    }

    private SiniestroRequestDto mapToSiniestroRequestDto(Siniestro siniestro) {
        return objectMapper.convertValue(siniestro, SiniestroRequestDto.class);
    }

    private VehiculoResponseWithSiniestroDto mapToVehiculoResponseWithSiniestroDto(Vehiculo vehiculo) {
        return objectMapper.convertValue(vehiculo, VehiculoResponseWithSiniestroDto.class);
    }
}
