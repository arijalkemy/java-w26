package org.example.lasperlas.Service;

import org.example.lasperlas.DTO.CrearJoyaRequestDTO;
import org.example.lasperlas.DTO.CrearJoyaResponseDTO;
import org.example.lasperlas.DTO.ObtenerJoyaResponseDTO;
import org.example.lasperlas.Model.Joya;
import org.example.lasperlas.Repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    IJoyaRepository joyaRepository;

    @Override
    @Transactional
    public CrearJoyaResponseDTO nuevaJoya(CrearJoyaRequestDTO joyaDTO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Joya joya = joyaRepository.save(mapper.map(joyaDTO, Joya.class));
        return new CrearJoyaResponseDTO(joya.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ObtenerJoyaResponseDTO> traerJoyas() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        List<Joya> joyas = joyaRepository.findAll();
        List<ObtenerJoyaResponseDTO> joyasDTO = new ArrayList<>();
        mapper.map(joyas, joyasDTO);
        return joyasDTO;
    }

    @Override
    @Transactional
    public CrearJoyaResponseDTO vender(Long id) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isEmpty()) {
            // Esto está mal, hay que manejar excepciones
            return new CrearJoyaResponseDTO((long) -1);
        }
        Joya joyaAModificar = joya.get();
        joyaAModificar.setVentaONo(false);
        joyaRepository.save(joyaAModificar);
        return new CrearJoyaResponseDTO(id);
    }

    @Override
    public ObtenerJoyaResponseDTO actualizar(Long id, CrearJoyaRequestDTO joyaNuevaDTO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isEmpty()) {
            return new ObtenerJoyaResponseDTO();
        }
        Joya joyaNueva = mapper.map(joyaNuevaDTO, Joya.class);
        joyaNueva.setId(id);
        Joya joyaGuardada = joyaRepository.save(joyaNueva);
        return mapper.map(joyaGuardada, ObtenerJoyaResponseDTO.class);
    }
}
