package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.RequestClothes;
import com.mercadolibre.showroom.dto.ResponseClothes;
import com.mercadolibre.showroom.model.Clothes;
import com.mercadolibre.showroom.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ClothesService implements IClothesService {

    @Autowired
    IClothesRepository repository;

    ModelMapper mapper = new ModelMapper();

    private ResponseClothes mapToDTO(Clothes clothes) {
        return mapper.map(clothes, ResponseClothes.class);
    }

    private Clothes mapToEntity(RequestClothes requestClothes) {
        return mapper.map(requestClothes, Clothes.class);
    }

    @Override
    public ResponseClothes createClothes(RequestClothes request) {
        Clothes newClothes = mapToEntity(request);
        return mapToDTO(repository.save(newClothes));
    }

    @Override
    public List<ResponseClothes> listResponseClothes() {
        List<Clothes> clothesList = repository.findAll();
        return clothesList
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ResponseClothes responseClothes(Long code) {
        Clothes clothes = this.findById(code);
        return mapToDTO(clothes);
    }

    @Override
    public ResponseClothes updateClothes(Long code, RequestClothes request) {
        Clothes clothes = this.findById(code);

        Clothes clothesUpdate = mapToEntity(request);
        clothesUpdate.setCode(code);
        repository.save(clothesUpdate);

        return mapToDTO(clothesUpdate);
    }

    @Override
    public String deleteClothes(Long code) {
        Clothes clothes = this.findById(code);
        repository.deleteById(code);
        return "La prenda con el codigo " + code + " ha sido eliminado con éxito!";
    }

    @Override
    public List<ResponseClothes> listResponseClothesBySize(String size) {
        List<Clothes> clothesList = repository.findAllBySize(size);
        return clothesList
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<ResponseClothes> listResponseClothesByName(String name) {
        List<Clothes> clothesList = repository.findAllByNameContainingIgnoreCase(name);
        return clothesList
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private Clothes findById(Long code){
        return repository.findById(code)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró una prenda con el codigo " + code)
                );
    }
}
