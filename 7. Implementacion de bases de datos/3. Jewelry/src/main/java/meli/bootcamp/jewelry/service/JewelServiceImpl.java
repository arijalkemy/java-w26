package meli.bootcamp.jewelry.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.jewelry.dto.JewelRequestDTO;
import meli.bootcamp.jewelry.dto.JewelResponseDTO;
import meli.bootcamp.jewelry.dto.mapper.Mapper;
import meli.bootcamp.jewelry.entity.Jewel;
import meli.bootcamp.jewelry.exception.NotFoundException;
import meli.bootcamp.jewelry.repository.IJewelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JewelServiceImpl implements IJewelService {

    private final IJewelRepository jewelRepository;


    @Override
    @Transactional
    public Map<String, Long> saveJewel(JewelRequestDTO jewelDTO) {
        Jewel newJewel = jewelRepository.save(Mapper.toEntity(jewelDTO));
        return Map.of("id", newJewel.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public JewelResponseDTO getJewelById(Long id) {
        return Mapper.toDto(jewelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Jewel with id %s is not found", id))));
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDTO> getJewels() {
        return jewelRepository.findAll().stream()
                .filter(Jewel::getIsForSale)
                .map(Mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteJewel(Long id) {
        JewelResponseDTO jewel = getJewelById(id);
        jewel.setIsForSale(false);

        jewelRepository.save(Mapper.toEntity(jewel));

    }

    @Override
    @Transactional
    public JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewelDTO) {
        JewelResponseDTO jewel = getJewelById(id);
        jewel.setName(jewelDTO.getName());
        jewel.setMaterial(jewelDTO.getMaterial());
        jewel.setWeight(jewelDTO.getWeight());
        jewel.setParticularity(jewelDTO.getParticularity());
        jewel.setHasStone(jewelDTO.getHasStone());

        jewelRepository.save(Mapper.toEntity(jewel));

        return jewel;
    }

}
