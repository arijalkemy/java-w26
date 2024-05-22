package com.example.showroom.service.impl;

import com.example.showroom.dto.request.ClothRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.entity.Cloth;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.repository.IClothesRepository;
import com.example.showroom.service.IClothesService;
import com.example.showroom.util.ShowroomUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.showroom.util.ShowroomUtil.*;

@AllArgsConstructor
@Service
public class ClothesServiceImpl implements IClothesService {
    private final IClothesRepository clothesRepository;
    private final MessageDTO message = new MessageDTO();

    @Override
    public MessageDTO addNewCloth(ClothRequestDTO clotheRequest) {
        Cloth newCloth = clotheRequestDTOToClothe(clotheRequest);
        this.clothesRepository.save(newCloth);
        this.message.setMessage("Cloth added successfully with code: " + newCloth.getCode());
        return this.message;
    }

    @Override
    public List<ClothDTO> showAllClothes(String name) {
        List<Cloth> cloths = new ArrayList<>();
        if(name != null) {
            cloths = clothesRepository.findByNameContains(name);
        } else {
            cloths = clothesRepository.findAll();
        }
        return getClothesDTO(cloths);
    }

    @Override
    public List<ClothDTO> getClothesBySize(Integer size) {
        List<Cloth> cloths = clothesRepository.findAll();
        List<Cloth> clothesBySize = cloths.stream()
                .filter(c -> size.equals(c.getSize()))
                .collect(Collectors.toList());
        return getClothesDTO(clothesBySize);
    }

    @Override
    public void deleteCloth(Long code) {
        Cloth cloth = clothesRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Cloth not found."));

        clothesRepository.delete(cloth);
    }

    @Override
    public ClothDTO searchClothByCode(Long code) {
        Cloth cloth = clothesRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Cloth not found."));

        return ShowroomUtil.clotheToClotheDto(cloth);
    }

    @Override
    public MessageDTO updateClothByCode(Long code, ClothRequestDTO clothe){
        Cloth newCloth = clotheRequestDTOToClothe(clothe);
        newCloth.setCode(code);

        clothesRepository.save(newCloth);
        this.message.setMessage("Cloth updated successfully with code: " + newCloth.getCode());
        return this.message;
    }
}
