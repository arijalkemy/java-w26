package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.dto.JoyaDTO;
import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.model.Joya;
import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.repository.IJoyasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JoyaService implements IJoyaService {
    private IJoyasRepository joyasRepository;
    private ObjectMapper mapper;

    @Override
    @Transactional
    public List<JoyaDTO> obtenerListaJoyas() {
        List<Joya> joyas = joyasRepository.findAll();

        List<JoyaDTO> joyasDTO = joyas.stream()
                .filter(Joya::getVentaONo)
                .map(this::convertir_a_joyaDTO)
                .collect(Collectors.toList());
        return joyasDTO;
    }

    @Override
    @Transactional
    public JoyaDTO guardarJoya(JoyaDTO joyaDTO) {
         Joya joya  = joyasRepository.save(convertir_joya(joyaDTO));
        return obtenerJoyaPorId(joya.getId());
    }

    @Override
    @Transactional
    public JoyaDTO modificarJoya(Long id, JoyaDTO joyaDTO) {
        Joya joya = getJoyaPorId(id);

        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPosee_piedra(joyaDTO.getPosee_piedra());
        joya.setVentaONo(joyaDTO.getVentaONo());

        joyasRepository.save(joya);

        return obtenerJoyaPorId(joya.getId());
    }

    @Override
    @Transactional
    public JoyaDTO obtenerJoyaPorId(Long id) {
        Joya joya = getJoyaPorId(id);
        return convertir_a_joyaDTO(joya);
    }

    @Override
    @Transactional
    public JoyaDTO eliminarJoya(Long id) {
        Joya joya = getJoyaPorId(id);
        joya.setVentaONo(false);
        joyasRepository.save(joya);
        return obtenerJoyaPorId(joya.getId());
    }

    private Joya getJoyaPorId(Long id) {
        return joyasRepository.findById(id).orElse(null);
    }

    private JoyaDTO convertir_a_joyaDTO(Joya joya){
        return mapper.convertValue(joya, JoyaDTO.class);
    }
    private Joya convertir_joya(JoyaDTO joyaDTO){
        return mapper.convertValue(joyaDTO, Joya.class);
    }
}
