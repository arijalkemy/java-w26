package perlas.joyeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import perlas.joyeria.dto.JoyaDto;
import perlas.joyeria.model.Joya;
import perlas.joyeria.repository.IJoyaRepository;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    private IJoyaRepository joyaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDto> getJoyas() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream()
                .filter(joya -> joya.getVentaONo())
                .map(this::convertToDto).toList();
    }

    @Override
    @Transactional
    public String saveJoya(JoyaDto joya) {
        Joya newJoya = joyaRepository.save(convertToEntity(joya));
        return "Joya guardada con éxito con el ID: " + newJoya.getId();
    }

    @Override
    @Transactional
    public String deleteJoya(long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (joya == null){
            return "La joya no existe";
        }
        joya.setVentaONo(Boolean.FALSE);
        joyaRepository.save(joya);
        return "Joya eliminada con éxito";

    }

    @Override
    public JoyaDto findJoya(long id) {
        return joyaRepository.findById(id).map(this::convertToDto).orElse(null);
    }

    @Override
    public String updateJoya(long id, JoyaDto joya) {
        Joya joyaToUpdate = joyaRepository.findById(id).orElse(null);
        if (joyaToUpdate == null){
            return "La joya no existe";
        }
        joyaToUpdate.setNombre(joya.getNombre());
        joyaToUpdate.setMaterial(joya.getMaterial());
        joyaToUpdate.setPeso(joya.getPeso());
        joyaToUpdate.setParticularidad(joya.getParticularidad());
        joyaToUpdate.setPosee_piedra(joya.getPosee_piedra());
        joyaRepository.save(joyaToUpdate);
        return "Joya actualizada con éxito";
    }

    public Joya convertToEntity(JoyaDto joyaDto){
        Joya joya = new Joya();
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPosee_piedra(joyaDto.getPosee_piedra());
        joya.setVentaONo(Boolean.TRUE);
        return joya;
    }

    public JoyaDto convertToDto(Joya joya){
        JoyaDto joyaDto = new JoyaDto();
        joyaDto.setNombre(joya.getNombre());
        joyaDto.setMaterial(joya.getMaterial());
        joyaDto.setPeso(joya.getPeso());
        joyaDto.setParticularidad(joya.getParticularidad());
        joyaDto.setPosee_piedra(joya.getPosee_piedra());
        return joyaDto;
    }
}
