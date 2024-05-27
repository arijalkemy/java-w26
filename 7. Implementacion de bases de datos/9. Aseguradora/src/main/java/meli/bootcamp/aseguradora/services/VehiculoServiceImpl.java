package meli.bootcamp.aseguradora.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import meli.bootcamp.aseguradora.dtos.responses.VehiculoResponseDTO;
import meli.bootcamp.aseguradora.models.Vehiculo;
import meli.bootcamp.aseguradora.models.projections.MatriculaMarcaModeloPerdidaTotal;
import meli.bootcamp.aseguradora.models.projections.PatenteMarca;
import meli.bootcamp.aseguradora.repositories.IVehiculoRepository;
import meli.bootcamp.aseguradora.models.projections.MatriculaMarcaModelo;
import meli.bootcamp.aseguradora.services.interfaces.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehicleService {

    private final IVehiculoRepository vehiculoRepository;
    private ObjectMapper objectMapper;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoResponseDTO getVehiculoById(Long id) {
        Vehiculo vehiculo = vehiculoRepository
                .findById(id)
                .orElse(null);

        return objectMapper.convertValue(
                vehiculo,
                VehiculoResponseDTO.class
        );
    }

    @Override
    public List<VehiculoResponseDTO> findAll() {
        return vehiculoRepository
                .findAll()
                .stream()
                .map(v -> objectMapper.convertValue(
                        v,
                        VehiculoResponseDTO.class
                ))
                .toList();
    }

    @Override
    public List<String> findAllPatentes() {
        return this.vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteMarca> findAllPatentesAndMarcaOrderByAnioFabricacion() {
        return vehiculoRepository.findByOrderByAnioFabricacion();
    }

    @Override
    public List<String> findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual() {
        return vehiculoRepository.findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual();
    }

    @Override
    public List<MatriculaMarcaModelo> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000() {
        return vehiculoRepository.findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA(10000);
    }

    @Override
    public List<MatriculaMarcaModeloPerdidaTotal> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000AndPerdidaTotal() {
        return vehiculoRepository.findAllMatriculaMarcaModeloBySiniestroPerdidaTotalMayorA(10000);
    }
}
