package com.bootcamp.joyeriacrud.service;

import com.bootcamp.joyeriacrud.exception.NotFoundException;
import com.bootcamp.joyeriacrud.model.Jewelry;
import com.bootcamp.joyeriacrud.model.dto.JewelryRequestDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryListResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.MessageResponseDTO;
import com.bootcamp.joyeriacrud.repository.JewelryRepository;
import com.bootcamp.joyeriacrud.utils.JewelryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelryServiceImpl implements IJewelryService {
    private final JewelryRepository jewelryRepository;

    private Jewelry findJewelryById(Long jewelryId) {
        return jewelryRepository.findByIdSellOrNot(jewelryId).orElseThrow(() -> new NotFoundException("Jewelry not found"));
    }

    @Override
    public JewelryListResponseDTO getJewelry() {
        List<JewelryResponseDTO> jewelryRequestDTOS = jewelryRepository.findAllSellOrNot().stream().map(JewelryMapper::mapEntityToResponseDTO).toList();
        return JewelryListResponseDTO.builder().jewelryRequestDTOS(jewelryRequestDTOS).build();
    }

    @Override
    public MessageResponseDTO saveJewelry(JewelryRequestDTO jewelryRequestDTO) {
        Jewelry jewelry = jewelryRepository.save(JewelryMapper.mapRequestDTOToEntity(jewelryRequestDTO));
        return MessageResponseDTO.builder().message("Created jewelry with ID: " + jewelry.getId()).build();
    }

    @Override
    public MessageResponseDTO deleteJewelry(Long jewelryId) {
        Jewelry jewelryToDelete = findJewelryById(jewelryId);
        jewelryToDelete.setSellOrNot(false);
        jewelryRepository.save(jewelryToDelete);
        return MessageResponseDTO.builder().message("Deleted jewelry with ID: " + jewelryToDelete.getId()).build();
    }

    @Override
    public JewelryResponseDTO updateJewelry(Long jewelryId, JewelryRequestDTO jewelryRequestDTO) {
        Jewelry jewelryToUpdate = findJewelryById(jewelryId);
        Jewelry jewelryUpdated = JewelryMapper.mapRequestDTOToEntity(jewelryRequestDTO);
        jewelryUpdated.setId(jewelryToUpdate.getId());
        return JewelryMapper.mapEntityToResponseDTO(jewelryRepository.save(jewelryUpdated));
    }
}
