package org.bootcamp.joyeria.service;

import org.bootcamp.joyeria.dto.RequestJewelryDTO;
import org.bootcamp.joyeria.dto.ResponseJewelryDTO;
import org.bootcamp.joyeria.model.Jewelry;
import org.bootcamp.joyeria.repository.JewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryServiceImpl implements IJewelryService {
    private final JewelryRepository jewelryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public JewelryServiceImpl(JewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public ResponseJewelryDTO createJewelry(RequestJewelryDTO requestJewelryDTO) {
        System.out.println(requestJewelryDTO);
        return modelMapper.map(jewelryRepository.save(modelMapper.map(requestJewelryDTO, Jewelry.class)),
                ResponseJewelryDTO.class);
    }

    @Override
    public List<ResponseJewelryDTO> getAllJewelry() {
        return List.of(modelMapper.map(jewelryRepository.findAllBySellTrue(), ResponseJewelryDTO[].class));
    }

    @Override
    public Void deleteJewelry(int id) {
        Jewelry jewelry = jewelryRepository.findById(id).orElseThrow();
        jewelry.setSell(false);
        jewelryRepository.save(jewelry);
        return null;
    }

    @Override
    public ResponseJewelryDTO updateJewelry(int id, RequestJewelryDTO requestJewelryDTO) {
        Jewelry jewelry = modelMapper.map(requestJewelryDTO, Jewelry.class);
        jewelry.setId(id);
        return modelMapper.map(jewelryRepository.save(jewelry), ResponseJewelryDTO.class);
    }
}
