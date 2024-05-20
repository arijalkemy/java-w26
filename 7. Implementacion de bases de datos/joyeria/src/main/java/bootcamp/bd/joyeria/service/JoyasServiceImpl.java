package bootcamp.bd.joyeria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.bd.joyeria.model.Joya;
import bootcamp.bd.joyeria.repository.JoyasRepository;

@Service
public class JoyasServiceImpl implements JoyasService {

    private final JoyasRepository joyasRepository;

    public JoyasServiceImpl(JoyasRepository joyasRepository) {
        this.joyasRepository = joyasRepository;
    }

    @Override
    public List<Joya> searchAll() {
        return joyasRepository
                .findAll()
                .stream()
                .filter(j -> j.getVentaONo().equals(true))
                .toList();
    }

    @Override
    public Long create(Joya joya) {
        Joya savedJoya = joyasRepository.save(joya);
        return savedJoya.getId();
    }

    @Override
    public void delete(Long id) {
        Joya joya = joyasRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        joya.setVentaONo(false);
        joyasRepository.save(joya);
    }

    @Override
    public Joya update(Joya joya, Long id) {
        return joyasRepository.findById(id).map(
                j -> {
                    joya.setId(j.getId());
                    return joyasRepository.save(joya);
                })
                .orElseThrow(
                        () -> {
                            throw new IllegalArgumentException();
                        });
    }
}
