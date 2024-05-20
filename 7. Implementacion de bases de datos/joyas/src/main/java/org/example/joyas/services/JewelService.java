package org.example.joyas.services;

import org.example.joyas.DTO.JewelNewResponseDTO;
import org.example.joyas.DTO.JewelRequestDTO;
import org.example.joyas.DTO.JewelResponseDTO;
import org.example.joyas.exceptions.NotFoundException;
import org.example.joyas.models.Jewel;
import org.example.joyas.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    private final ModelMapper mapper;
    IJewelRepository jewelRepository;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        mapper=new ModelMapper();
    }

    @Override
    @Transactional(readOnly = false)
    public JewelNewResponseDTO createJewerly(JewelRequestDTO newJewel) {
        Jewel jewel = convert(newJewel);
        jewel = jewelRepository.save(jewel);
        return convertNewJewel(jewel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDTO> listAll() {
        List<Jewel> jewelList = jewelRepository.findAll();
        jewelList = jewelList.stream().filter(Jewel::getVentaONo).toList();
        return jewelList.stream().map(this::convert).toList();
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteJewerlyById(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(()->
                new NotFoundException("The jewel with id: " + id + ", not exists"));
        jewel.setVentaONo(!jewel.getVentaONo());
        jewelRepository.save(jewel);
    }

    @Override
    @Transactional(readOnly = false)
    public JewelResponseDTO updateById(Long id, JewelRequestDTO jewel){
        jewelRepository.findById(id).orElseThrow(()->
                new NotFoundException("The jewel with id: " + id + ", not exists"));
        Jewel newJowerly = convert(jewel);
        newJowerly.setNro_identificatorio(id);
        newJowerly = jewelRepository.save(newJowerly);
        return convert(newJowerly);
    }
    /*
    * Región de conversores de DTO a Model
    * Conversor Model a DTO
    * */

    private Jewel convert(JewelRequestDTO jewel){
        return mapper.map(jewel, Jewel.class);
    }
    private JewelResponseDTO convert(Jewel jewel){
        return mapper.map(jewel, JewelResponseDTO.class);
    }
    private JewelNewResponseDTO convertNewJewel(Jewel jewel){
        return mapper.map(jewel, JewelNewResponseDTO.class);
    }
}
