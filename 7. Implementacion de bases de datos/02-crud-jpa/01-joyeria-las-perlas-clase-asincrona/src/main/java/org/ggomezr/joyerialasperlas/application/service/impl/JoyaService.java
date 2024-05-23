package org.ggomezr.joyerialasperlas.application.service.impl;

import org.ggomezr.joyerialasperlas.application.service.interfaces.IJoyaService;
import org.ggomezr.joyerialasperlas.domain.dto.JoyaDTO;
import org.ggomezr.joyerialasperlas.domain.dto.ResposeDTO;
import org.ggomezr.joyerialasperlas.domain.exception.NotFoundException;
import org.ggomezr.joyerialasperlas.domain.model.Joya;
import org.ggomezr.joyerialasperlas.domain.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepository;

    private final ModelMapper modelMapper;

    public JoyaService(IJoyaRepository joyaRepository, ModelMapper modelMapper) {
        this.joyaRepository = joyaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResposeDTO createJoya(JoyaDTO joyaDTO) {
        Joya joya = convertJoyaDtoToJoya(joyaDTO);
        joyaRepository.save(joya);
        return new ResposeDTO("nro_identificatorio: " + joya.getNro_identificatorio());
    }

    @Override
    public JoyaDTO getJoyaById(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);

        if(joya.isEmpty() || joya.get().getVentaONo().equals(false)) throw new NotFoundException("Joya no encontrada");

        return convertJoyaToJoyaDto(joya.get());
    }

    @Override
    public List<JoyaDTO> getAll() {
        return joyaRepository.findAll().stream()
                .filter(joya -> joya.getVentaONo().equals(true))
                .map(this::convertJoyaToJoyaDto)
                .toList();
    }

    @Override
    public ResposeDTO deleteJoya(Long id) {
        Optional<Joya> currentJoya = joyaRepository.findById(id);

        if(currentJoya.isEmpty()) throw new NotFoundException("Joya no encontrada");

        currentJoya.get().setVentaONo(false);

        joyaRepository.save(currentJoya.get());

        return new ResposeDTO("Joya " + currentJoya.get().getNombre() + " eliminada");
    }

    @Override
    public ResposeDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Optional<Joya> currentJoya = joyaRepository.findById(id);

        if(currentJoya.isEmpty()) throw new NotFoundException("Joya no encontrada");

        currentJoya.get().setNombre(joyaDTO.getNombre());
        currentJoya.get().setMaterial(joyaDTO.getMaterial());
        currentJoya.get().setPeso(joyaDTO.getPeso());
        currentJoya.get().setParticularidad(joyaDTO.getParticularidad());
        currentJoya.get().setPosee_piedra(joyaDTO.getPosee_piedra());
        currentJoya.get().setVentaONo(joyaDTO.getVentaONo());

        joyaRepository.save(currentJoya.get());
        return new ResposeDTO("Joya " + currentJoya.get().getNro_identificatorio() + " actualizado");
    }

    private Joya convertJoyaDtoToJoya(JoyaDTO joyaDTO){
        return modelMapper.map(joyaDTO, Joya.class);
    }

    private JoyaDTO convertJoyaToJoyaDto(Joya joya){
        return modelMapper.map(joya, JoyaDTO.class);
    }
}
