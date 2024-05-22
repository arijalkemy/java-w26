package com.bootcamp.jewerly.service.impl;

import java.util.List;
import java.util.Optional;

import com.bootcamp.jewerly.dto.JewerlyDTO;
import com.bootcamp.jewerly.dto.ResponseDTO;
import com.bootcamp.jewerly.mapper.JewerlyMapper;
import com.bootcamp.jewerly.service.IJewerlyService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.bootcamp.jewerly.exception.NotFoundException;
import com.bootcamp.jewerly.model.Jewerly;
import com.bootcamp.jewerly.repository.IJewerlyRepository;

@Service
public class JewerlyService implements IJewerlyService {
    private final IJewerlyRepository jewerlyRepository;

    public JewerlyService(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewerlyDTO> getAll() {
        List<Jewerly> jewerlyList = jewerlyRepository.findAll();
        return JewerlyMapper.jewerlyListToJewerlyDTOList(jewerlyList.stream().
                filter(Jewerly::getVentaONo).toList());
    }

    @Override
    @Transactional
    public ResponseDTO create(JewerlyDTO jewerlyDto) {
        Jewerly jewerly = jewerlyRepository.save(JewerlyMapper.jewerlyDTOToJewerly(jewerlyDto));
        return new ResponseDTO("Nro. Identificatorio "
                + (jewerly.getNroIdentificatorio() == null ? "0" : jewerly.getNroIdentificatorio()));
    }

    @Override
    @Transactional
    public ResponseDTO delete(long id) {
        Jewerly jewerly = getJewerlyById(id);
        jewerly.setVentaONo(Boolean.FALSE);
        jewerlyRepository.save(jewerly);
        return new ResponseDTO("Se ha eliminado la joya correctamente.");
    }

    @Override
    public JewerlyDTO getById(long id) {
        Jewerly jewerly = getJewerlyById(id);
        if (jewerly.getVentaONo() == Boolean.FALSE)
            throw new NotFoundException("No se encontró ninguna joya con el id indicado.");

        return JewerlyMapper.jewerlyToJewerlyDTO(jewerly);
    }

    @Override
    @Transactional
    public JewerlyDTO update(JewerlyDTO jewerlyDTO) {
        if (jewerlyDTO == null || jewerlyDTO.getNroIdentificatorio() == null)
            throw new NotFoundException("El Nro. Identificatorio de la joya es requerido.");

        if (!jewerlyRepository.existsById(jewerlyDTO.getNroIdentificatorio()))
            throw new NotFoundException("No se encontró ninguna joya con el Nro. Identificatorio " + jewerlyDTO.getNroIdentificatorio() + ".");

        jewerlyRepository.save(JewerlyMapper.jewerlyDTOToJewerly(jewerlyDTO));
        return jewerlyDTO;
    }

    protected Jewerly getJewerlyById(Long id) {
        Optional<Jewerly> jewerly = jewerlyRepository.findById(id);

        if (jewerly.isEmpty()) {
            throw new NotFoundException("No se encontró ninguna joya con el id indicado.");
        }

        return jewerly.get();
    }
}
