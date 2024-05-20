package com.bootcamp.joyeria.services;

import com.bootcamp.joyeria.dtos.JewelRequestDTO;
import com.bootcamp.joyeria.dtos.JewelResponseDTO;
import com.bootcamp.joyeria.dtos.JewelUpdateDTO;
import com.bootcamp.joyeria.dtos.MessageResponseDTO;
import com.bootcamp.joyeria.entities.Jewel;
import com.bootcamp.joyeria.repositories.JewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private final JewelRepository jewellRepository;
    private ModelMapper modelMapper;

    public JewelService(JewelRepository jewellRepository) {
        this.jewellRepository = jewellRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageResponseDTO createJewel(JewelRequestDTO jewelRequestDTO) {
        Jewel jewel = modelMapper.map(jewelRequestDTO, Jewel.class);
        jewel.setSellOrNot(true);
        Jewel jewelSaved = jewellRepository.save(jewel);
        return new MessageResponseDTO("Jewel created with ID " + jewelSaved.getId());
    }

    @Override
    public List<JewelResponseDTO> getAllJewels() {
        return jewellRepository.findAll()
                .stream().map(x -> modelMapper.map(x, JewelResponseDTO.class))
                .filter(JewelResponseDTO::isSellOrNot)
                .toList();
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel jewel = this.jewellRepository.findById(id).orElseThrow(()-> new RuntimeException("Jewel not found"));
        jewel.setSellOrNot(false);
        this.jewellRepository.save(jewel);
    }

    @Override
    public MessageResponseDTO updateJewel(Long id, JewelUpdateDTO jewelUpdateDTO) {
        Jewel jewel = this.jewellRepository.findById(id).orElseThrow(()-> new RuntimeException("Jewel not found"));
        jewel.setName(jewelUpdateDTO.getName());
        jewel.setMaterial(jewelUpdateDTO.getMaterial());
        jewel.setParticularity(jewelUpdateDTO.getParticularity());
        jewel.setHasStone(jewelUpdateDTO.isHasStone());
        jewel.setWeight(jewelUpdateDTO.getWeight());
        jewel.setSellOrNot(jewelUpdateDTO.isSellOrNot());
        Jewel jewelSaved = jewellRepository.save(jewel);
        return new MessageResponseDTO("Jewel updated with ID " + jewelSaved.getId());
    }

    private JewelResponseDTO convertJewelToJewelResponseDTO(Jewel jewel) {
        return new JewelResponseDTO(
                jewel.getId(),
                jewel.getName(),
                jewel.getMaterial(),
                jewel.getWeight(),
                jewel.getParticularity(),
                jewel.isHasStone(),
                jewel.isSellOrNot()
        );
    }
}
