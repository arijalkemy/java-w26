package org.ggomezr.miniseries.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.miniseries.dto.MiniSerieDTO;
import org.ggomezr.miniseries.exception.MiniSerieNotFoundException;
import org.ggomezr.miniseries.model.MiniSerie;
import org.ggomezr.miniseries.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieService {

    private final IMiniserieRepository miniserieRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public MiniSerieService(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    public MiniSerie createMiniserie(MiniSerieDTO miniSerieDTO){
        return miniserieRepository.save(convertMiniSerieDtoToMiniSerie(miniSerieDTO));
    }

    public MiniSerie getMiniSerieById(Long id) throws MiniSerieNotFoundException {
        return miniserieRepository.findById(id).orElseThrow(MiniSerieNotFoundException::new);
    }

    public MiniSerie updateMiniSerie(MiniSerieDTO miniSerieDTO, Long id) throws MiniSerieNotFoundException{
        MiniSerie miniSerie = miniserieRepository.findById(id).orElseThrow(MiniSerieNotFoundException::new);

        miniSerie.setName(miniSerieDTO.getName());
        miniSerie.setRating(miniSerieDTO.getRating());
        miniSerie.setAmount_of_awards(miniSerieDTO.getAmount_of_awards());

        return miniserieRepository.save(miniSerie);
    }

    public String deleteMiniSerie(Long id) throws MiniSerieNotFoundException {
        MiniSerie miniSerie = miniserieRepository.findById(id).orElseThrow(MiniSerieNotFoundException::new);
        miniserieRepository.deleteById(miniSerie.getId());
        return "MiniSerie " + miniSerie.getName() + " has been deleted";
    }

    public List<MiniSerie> getAllMiniSeries(){
        return miniserieRepository.findAll();
    }

    private MiniSerie convertMiniSerieDtoToMiniSerie(MiniSerieDTO dto){
        return objectMapper.convertValue(dto, MiniSerie.class);
    }
}
