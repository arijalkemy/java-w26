package org.example.joyeria.service;

import org.example.joyeria.dto.JewelRequestDTO;
import org.example.joyeria.dto.JewelResponseDTO;
import org.example.joyeria.model.Jewel;
import org.example.joyeria.repository.IJewerlyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewerlyServiceImpl implements IJewerlyService {

    @Autowired
    IJewerlyRepository jewerlyRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDTO> getJewerly() {
         List<Jewel> list = jewerlyRepository.findAll().stream().filter(Jewel::isVentaONo).toList();
         return list.stream().map(j -> modelMapper.map(j, JewelResponseDTO.class)).toList();
    }

    @Override
    public Long saveJewel(JewelRequestDTO jewelDTO) {
        Jewel jewel = modelMapper.map(jewelDTO, Jewel.class);
        jewerlyRepository.save(jewel);
        return jewel.getNroIdentificatorio();
    }

    @Override
    public void deleteJewel(Long id) {
        JewelResponseDTO jewelUpdate = findJewel(id);
        jewelUpdate.setVentaONo(false);
        jewerlyRepository.save(modelMapper.map(jewelUpdate, Jewel.class));
    }

    @Override
    @Transactional(readOnly = true)
    public JewelResponseDTO findJewel(Long id) {
        Jewel jewel = jewerlyRepository.findById(id).orElse(null);
        return modelMapper.map(jewel, JewelResponseDTO.class);
    }

    @Override
    public JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewelUpdate) {
        JewelResponseDTO jewel = findJewel(id);
        if (jewel != null) {
            jewel.setMaterial(jewelUpdate.getMaterial());
            jewel.setNombre(jewelUpdate.getNombre());
            jewel.setPeso(jewelUpdate.getPeso());
            jewel.setParticularidad(jewelUpdate.getParticularidad());
            jewel.setPoseePiedra(jewelUpdate.isPoseePiedra());
            jewel.setVentaONo(jewelUpdate.isVentaONo());
        }
        jewerlyRepository.save(modelMapper.map(jewel, Jewel.class));
        return jewel;
    }


}
