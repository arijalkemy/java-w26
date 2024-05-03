package com.viajescuidados.services;

import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.interfaces.IViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ViajesService implements IViajesService  {
    @Autowired
    private IViajesRepository viajesRepository;
    @Autowired
    private IPersonaServiceInternal personaService;
    @Autowired
    private ICalculadoraDemora calculadorDemora;

    @Override
    public ViajeResponseDTO crearViaje(ViajeDTO viajeDTO, Integer personaId) {
        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);

        Persona persona = personaService.buscarPersonaPorId(personaId);
        nuevoViaje.setPersona(persona);

        for(Integer idCuidador: viajeDTO.getCuidadores()) {
            Persona cuidador = personaService.buscarPersonaPorId(idCuidador);
            nuevoViaje.agregarCuidador(cuidador);
        }

        Long duracionEstimada = this.calculadorDemora
                .calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino());
        nuevoViaje.setDuracionEstimadaEnMins(duracionEstimada);

        this.viajesRepository.guardar(nuevoViaje);
        return ViajeMapper.crearViajeResponseDTO(nuevoViaje);
    }

    @Override
    public ViajeResponseDTO comenzarViaje(Integer id) {
        Viaje viaje = buscarViajePorId(id);

        viaje.setFechaComienzo(LocalDateTime.now());
        viaje.setEstado(EstadoViaje.EN_PROCESO);

        this.viajesRepository.modificar(viaje);

        return ViajeMapper.crearViajeResponseDTO(viaje);
    }

    private Viaje buscarViajePorId(Integer id) {
        Optional<Viaje> posibleViaje = this.viajesRepository.buscarPorId(id);

        if(posibleViaje.isEmpty())
            throw new NotFoundException("No existe un viaje que coincida con el id brindado");

        return posibleViaje.get();
    }
}
