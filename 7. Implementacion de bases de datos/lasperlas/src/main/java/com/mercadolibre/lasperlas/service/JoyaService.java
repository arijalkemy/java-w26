package com.mercadolibre.lasperlas.service;

import com.mercadolibre.lasperlas.dto.JoyaRequestDTO;
import com.mercadolibre.lasperlas.dto.JoyaResponseDTO;
import com.mercadolibre.lasperlas.model.Joya;
import com.mercadolibre.lasperlas.repository.IJoyaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepo;

    @Override
    public void saveJoya(JoyaRequestDTO joya) {
        joyaRepo.save(mapToEntity(joya));
    }

    @Override
    public List<Joya> getJoyas() {

        return joyaRepo.findAll();

    }

    @Override
    public JoyaResponseDTO findJoya(Long id) {
        return mapToDto(findJoyaEntity(id));
    }
    private Joya findJoyaEntity(Long id) {
        return joyaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la joya"));
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joyaOriginal = this.findJoyaEntity(id);
        joyaOriginal.setVentaONo(false);
        joyaRepo.save(joyaOriginal);
    }

    @Override
    public void editJoya(Long idModificar, JoyaRequestDTO joyaModif) {

        Joya joyaOriginal = this.findJoyaEntity(idModificar);

        joyaOriginal.setNombre(joyaModif.getNombre());
        joyaOriginal.setMaterial(joyaModif.getMaterial());
        joyaOriginal.setPeso(joyaModif.getPeso());
        joyaOriginal.setParticularidad(joyaModif.getParticularidad());
        joyaOriginal.setPoseePiedra(joyaModif.isPoseePiedra());
        joyaRepo.save(joyaOriginal);

    }

    private Joya mapToEntity(JoyaRequestDTO dto) {
        return new Joya(
                null,
                dto.getNombre(),
                dto.getMaterial(),
                dto.getPeso(),
                dto.getParticularidad(),
                dto.isPoseePiedra(),
                true
        );
    }

    private JoyaResponseDTO mapToDto(Joya joya) {
        return new JoyaResponseDTO(
                joya.getNroId(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.isPoseePiedra(),
                joya.isVentaONo()
        );
    }
}
