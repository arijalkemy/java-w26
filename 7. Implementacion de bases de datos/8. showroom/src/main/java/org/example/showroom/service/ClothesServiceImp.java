package org.example.showroom.service;

import org.example.showroom.DTO.RequestClothesDTO;
import org.example.showroom.DTO.ResponseClothesDTO;
import org.example.showroom.model.ClothesModel;
import org.example.showroom.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImp implements IClothesService{

    private final IClothesRepository clothesRepository;
    private final ModelMapper modelMapper;
    public ClothesServiceImp(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResponseClothesDTO createClothes(RequestClothesDTO requestClothesDTO) {
        ClothesModel clothesModel = modelMapper.map(requestClothesDTO, ClothesModel.class);
        ClothesModel responseClothesModel = clothesRepository.save(clothesModel);
        return modelMapper.map(responseClothesModel, ResponseClothesDTO.class);
    }

    @Override
    public List<ResponseClothesDTO> getAllClothes(String keyword) {
        if(keyword != null && !keyword.isEmpty()){
            List<ClothesModel> listClothes = clothesRepository.findByNameContainingIgnoreCase(keyword);
            return listClothes.stream().map(clothesModel -> modelMapper.map(clothesModel, ResponseClothesDTO.class)).toList();
        }
        List<ClothesModel> listClothes = clothesRepository.findAll();
        return List.of(modelMapper.map(listClothes, ResponseClothesDTO[].class));
    }

    @Override
    public ResponseClothesDTO getClothesByCode(Long code) {
        ClothesModel clothesModel = clothesRepository.findById(code).orElse(null);
        return modelMapper.map(clothesModel, ResponseClothesDTO.class);
    }

    @Override
    public ResponseClothesDTO updateClothes(Long code, RequestClothesDTO requestClothesDTO) {
        ClothesModel clothesModel = modelMapper.map(requestClothesDTO, ClothesModel.class);
        clothesModel.setCode(code);

        return modelMapper.map(clothesRepository.save(clothesModel), ResponseClothesDTO.class);

    }

    @Override
    public void deleteClothes(Long code) {
        clothesRepository.deleteById(code);
    }

    @Override
    public List<ResponseClothesDTO> getClothesBySize(float size) {
        List<ClothesModel> listClothes = clothesRepository.findBySize(size);
        return List.of(modelMapper.map(listClothes, ResponseClothesDTO[].class));
    }
}
