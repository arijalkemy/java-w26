package com.bootcamp.miniserie.service.impl;

import java.util.List;
import java.util.Optional;

import com.bootcamp.miniserie.dto.ResponseDTO;
import com.bootcamp.miniserie.exception.NotFoundException;
import com.bootcamp.miniserie.mapper.MiniSerieMapper;
import com.bootcamp.miniserie.service.IMiniSerieService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.bootcamp.miniserie.dto.MiniSerieDTO;
import com.bootcamp.miniserie.model.MiniSerie;
import com.bootcamp.miniserie.repository.IMiniSerieRepository;

@Service
public class MiniSerieService implements IMiniSerieService {

    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiniSerieDTO> getMiniSeries() {
        return MiniSerieMapper.miniSerieListToMiniSerieDTOList(miniSerieRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerieDTO findMiniSerie(long id) {
        return MiniSerieMapper.miniSerieToMiniSerieDTO(this.getById(id));
    }

    @Override
    @Transactional
    public ResponseDTO saveMiniSerie(MiniSerieDTO miniSerieDto) {
        miniSerieRepository.save(MiniSerieMapper.miniSerieDTOToMiniSerie(miniSerieDto));
        return new ResponseDTO("Se ha agregado la miniserie correctamente.");
    }

    @Override
    public ResponseDTO updateMiniSerie(MiniSerieDTO miniSerieDto) {
        if(miniSerieDto.getId() == null)
            throw new NotFoundException("El id de la miniserie es requerido.");

        if (!miniSerieRepository.existsById(miniSerieDto.getId()))
            throw new NotFoundException("No se encontró ninguna miniserie con el id " + miniSerieDto.getId() + ".");
        miniSerieRepository.save(MiniSerieMapper.miniSerieDTOToMiniSerie(miniSerieDto));
        return new ResponseDTO("Se ha actualizado la miniserie correctamente.");
    }

    @Override
    @Transactional
    public ResponseDTO deleteMiniSerie(long id) {
        miniSerieRepository.deleteById(getById(id).getId());
        return new ResponseDTO("Se ha eliminado de manera correcta la miniserie.");
    }

    public MiniSerie getById(Long id) {
        Optional<MiniSerie> miniSerie = miniSerieRepository.findById(id);

        if (miniSerie.isEmpty()) {
            throw new NotFoundException("No se encontró ninguna miniserie con el id " + id + ".");
        }

        return miniSerie.get();
    }

}