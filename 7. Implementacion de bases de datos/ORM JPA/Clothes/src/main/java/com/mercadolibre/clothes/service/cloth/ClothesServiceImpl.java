package com.mercadolibre.clothes.service.cloth;

import com.mercadolibre.clothes.dto.cloth.ClothRequestDTO;
import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.exception.ClothNotFoundException;
import com.mercadolibre.clothes.model.Cloth;
import com.mercadolibre.clothes.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService {
    private final IClothesRepository clothesRepository;
    public ClothesServiceImpl(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Long createCloth(ClothRequestDTO clothRequestDTO) {
        return clothesRepository.save(new ModelMapper().map(clothRequestDTO, Cloth.class)).getCode();
    }

    @Override
    public List<ClothResponseDTO> getAllClothes(String type) {
        List<Cloth> requested;
        if (type == null) {
            requested = clothesRepository.findAll();
        } else{
            requested = clothesRepository.findClothsByTypeEqualsIgnoreCase(type);
        }
        return requested
                .stream()
                .map(cloth -> new ModelMapper().map(cloth, ClothResponseDTO.class))
                .toList();
    }

    @Override
    public ClothResponseDTO getClothByCode(Long code) {
        Cloth cloth = findAndCheckClothById(code);
        return new ModelMapper().map(cloth, ClothResponseDTO.class);
    }

    @Override
    public ClothResponseDTO updateClothByCode(Long code, ClothRequestDTO clothRequestDTO) {
        findAndCheckClothById(code);
        Cloth newCloth = new ModelMapper().map(clothRequestDTO, Cloth.class);
        newCloth.setCode(code);
        clothesRepository.save(newCloth);
        return new ModelMapper().map(newCloth, ClothResponseDTO.class);
    }

    @Override
    public void deleteCloth(Long code) {
        findAndCheckClothById(code);
    }

    @Override
    public List<ClothResponseDTO> getClothesBySize(Integer size) {
        return clothesRepository.findClothsBySizeEquals(size)
                .stream()
                .map(cloth -> new ModelMapper().map(cloth, ClothResponseDTO.class))
                .toList();
    }

    private Cloth findAndCheckClothById(Long code) {
        return clothesRepository.findById(code)
                .orElseThrow(() -> new ClothNotFoundException("Cloth with code " + code + " not found"));
    }
}
