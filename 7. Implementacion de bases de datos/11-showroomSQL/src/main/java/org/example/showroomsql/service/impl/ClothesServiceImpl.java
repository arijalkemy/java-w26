package org.example.showroomsql.service.impl;

import org.example.showroomsql.dto.RequestClothesDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.exception.entity.NotFoundException;
import org.example.showroomsql.model.Clothes;
import org.example.showroomsql.repository.IClothesRepository;
import org.example.showroomsql.service.IClothesService;
import org.example.showroomsql.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.example.showroomsql.util.Util.*;

import java.util.List;


@Service
public class ClothesServiceImpl implements IClothesService {

    @Autowired
    IClothesRepository repository;

    @Override
    public ResponseClothesDTO createClothes(RequestClothesDTO request) {
        Clothes newClothes = mapToClothesEntity(request);
        return mapToClothesDTO(repository.save(newClothes));
    }

    @Override
    public List<ResponseClothesDTO> getAllClothes() {
        List<Clothes> clothesList = repository.findAll();
        return clothesList
                .stream()
                .map(Util::mapToClothesDTO)
                .toList();
    }

    @Override
    public ResponseClothesDTO getClothesByCode(Long code) {
        Clothes clothes = this.findById(code);
        return mapToClothesDTO(clothes);
    }

    @Override
    public ResponseClothesDTO updateClothes(Long code, RequestClothesDTO request) {
        Clothes clothes = this.findById(code);

        Clothes clothesUpdate = Util.mapToClothesEntity(request);
        clothesUpdate.setCode(code);
        repository.save(clothesUpdate);

        return mapToClothesDTO(clothesUpdate);
    }

    @Override
    public String deleteClothes(Long code) {
        Clothes clothes = this.findById(code);
        repository.deleteById(code);
        return "La prenda con el codigo " + code + " ha sido eliminado con éxito!";
    }

    @Override
    public List<ResponseClothesDTO> getClothesBySize(String size) {
        List<Clothes> clothesList = repository.findAllBySize(size);
        return clothesList
                .stream()
                .map(Util::mapToClothesDTO)
                .toList();
    }

    @Override
    public List<ResponseClothesDTO> getClothesByName(String name) {
        List<Clothes> clothesList = repository.findAllByNameContainingIgnoreCase(name);
        return clothesList
                .stream()
                .map(Util::mapToClothesDTO)
                .toList();
    }

    private Clothes findById(Long code){
        return repository.findById(code)
                .orElseThrow(
                        () -> new NotFoundException("No se encontró una prenda con el codigo " + code)
                );
    }
}
