package com.meli.lasperlas.service;

import com.meli.lasperlas.dto.NewJewellResponseDTO;
import com.meli.lasperlas.dto.RequestJewellDTO;
import com.meli.lasperlas.dto.RequestUpdateJewellDTO;
import com.meli.lasperlas.dto.ResponseJewellDTO;
import com.meli.lasperlas.exception.NotForSaleException;
import com.meli.lasperlas.exception.NotFoundException;
import com.meli.lasperlas.model.Jewell;
import com.meli.lasperlas.repository.IJewellRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewellService implements IJewellService {

    private final IJewellRepository jewellRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private final String NOT_FOUND_MESSAGE = "Joya no encontrada";
    private final String NOT_FOR_SALE = "La joya no esta a la venta";

    @Override
    @Transactional(readOnly = true)
    public List<ResponseJewellDTO> getJewells() {
        return jewellRepository.findAll().stream()
                .filter(Jewell::getFor_sale)
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    @Transactional
    public NewJewellResponseDTO saveJewell(RequestJewellDTO requestJewellDTO) {
        Jewell jewell = jewellRepository.save(mapToEntity(requestJewellDTO));
        return modelMapper.map(jewell, NewJewellResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteJewell(Long id) {
        Jewell jewell = findJewellById(id);
        if (!jewell.getFor_sale()){
            throw new NotForSaleException(NOT_FOR_SALE);
        }
        jewell.setFor_sale(false);
        jewellRepository.save(jewell);
    }

    @Override
    public ResponseJewellDTO update(Long id, RequestUpdateJewellDTO requestUpdateJewellDTO) {
        findJewellById(id);
        jewellRepository.save(modelMapper.map(requestUpdateJewellDTO, Jewell.class));
        Jewell jewell = findJewellById(id);
        return mapToDTO(jewell);
    }


    //@Transactional(readOnly = true)
    private Jewell findJewellById(Long id) {
        return jewellRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(NOT_FOUND_MESSAGE)
        );
    }

    private Jewell mapToEntity(RequestJewellDTO requestJewellDTO){
        return modelMapper.map(requestJewellDTO, Jewell.class);
    }
    private ResponseJewellDTO mapToDTO(Jewell jewell){
        return  modelMapper.map(jewell, ResponseJewellDTO.class);
    }

}
