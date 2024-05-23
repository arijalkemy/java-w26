package org.ggomezr.miniseries.application.service.impl;

import org.ggomezr.miniseries.domain.dto.MiniSerieDTO;
import org.ggomezr.miniseries.domain.dto.ResponseDTO;
import org.ggomezr.miniseries.domain.exception.NotFoundException;
import org.ggomezr.miniseries.domain.model.MiniSerie;
import org.ggomezr.miniseries.domain.repository.IMiniserieRepository;
import org.ggomezr.miniseries.application.service.interfaces.IMiniSerieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniSerieService implements IMiniSerieService {
    private final IMiniserieRepository miniserieRepository;
    private final ModelMapper modelMapper;

    public MiniSerieService(IMiniserieRepository miniserieRepository, ModelMapper modelMapper) {
        this.miniserieRepository = miniserieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MiniSerieDTO createMiniserie(MiniSerieDTO miniSerieDTO){
        miniserieRepository.save(convertMiniSerieDtoToMiniSerie(miniSerieDTO));
        return miniSerieDTO;
    }

    @Override
    public MiniSerieDTO getMiniSerieById(Long id) {
        Optional<MiniSerie> existingMiniSerie = miniserieRepository.findById(id);

        if(existingMiniSerie.isEmpty()) throw new NotFoundException("MiniSerie not found");

        return convertMiniSerieToMiniSerieDTO(existingMiniSerie.get());
    }

    @Override
    public MiniSerieDTO updateMiniSerie(MiniSerieDTO miniSerieDTO, Long id){
        Optional<MiniSerie> existingMiniSerie = miniserieRepository.findById(id);

        if(existingMiniSerie.isEmpty()) throw new NotFoundException("MiniSerie not found");

        existingMiniSerie.get().setName(miniSerieDTO.getName());
        existingMiniSerie.get().setRating(miniSerieDTO.getRating());
        existingMiniSerie.get().setAmount_of_awards(miniSerieDTO.getAmount_of_awards());

        miniserieRepository.save(existingMiniSerie.get());
        return convertMiniSerieToMiniSerieDTO(existingMiniSerie.get());
    }

    @Override
    public ResponseDTO deleteMiniSerie(Long id){
        Optional<MiniSerie> existingMiniSerie = miniserieRepository.findById(id);

        if(existingMiniSerie.isEmpty()) throw new NotFoundException("MiniSerie not found");

        miniserieRepository.deleteById(existingMiniSerie.get().getId());
        return new ResponseDTO("MiniSerie " + existingMiniSerie.get().getName() + " has been deleted");
    }

    @Override
    public List<MiniSerieDTO> getAllMiniSeries(){
        return miniserieRepository.findAll().stream()
                .map(this::convertMiniSerieToMiniSerieDTO)
                .toList();
    }

    private MiniSerie convertMiniSerieDtoToMiniSerie(MiniSerieDTO dto){
        return modelMapper.map(dto, MiniSerie.class);
    }

    private MiniSerieDTO convertMiniSerieToMiniSerieDTO(MiniSerie miniSerie){
        return modelMapper.map(miniSerie, MiniSerieDTO.class);
    }
}
