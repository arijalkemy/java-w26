package co.com.mercadolibre.miniseries.service.impl;

import co.com.mercadolibre.miniseries.dto.MiniSerieDTO;
import co.com.mercadolibre.miniseries.model.MiniSerie;
import co.com.mercadolibre.miniseries.repository.IMiniSerieRepository;
import co.com.mercadolibre.miniseries.service.IMiniSerieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieService implements IMiniSerieService {

    @Autowired
    private IMiniSerieRepository miniSerieRepository;

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MiniSerieDTO create(MiniSerieDTO miniSerieDTO) {
        MiniSerie miniSerie = objectMapper.convertValue(miniSerieDTO, MiniSerie.class);
        miniSerieRepository.save(miniSerie);
        return objectMapper.convertValue(miniSerie, MiniSerieDTO.class);
    }

    @Override
    public List<MiniSerieDTO> findAll() {
        return miniSerieRepository.findAll().stream()
                .map(miniSerie -> new ObjectMapper().convertValue(miniSerie, MiniSerieDTO.class))
                .toList();
    }

    @Override
    public MiniSerieDTO findById(Long id) {
        MiniSerie miniSerie = miniSerieRepository.findById(id).orElse(null);
        if (miniSerie != null) {
            return objectMapper.convertValue(miniSerie, MiniSerieDTO.class);
        }
        return null;
    }

    @Override
    public MiniSerieDTO update(MiniSerieDTO miniSerieDTO, Long id) {
        MiniSerie miniSerie = objectMapper.convertValue(miniSerieDTO, MiniSerie.class);
        if (miniSerieRepository.existsById(id)) {
            miniSerie.setId(id);
            miniSerieRepository.save(miniSerie);
            return objectMapper.convertValue(miniSerie, MiniSerieDTO.class);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (miniSerieRepository.existsById(id)) {
            miniSerieRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
