package com.implementaciondb.ejercicio11_showroom_elasticsearch.service;

import com.implementaciondb.ejercicio11_showroom_elasticsearch.exception.NotFoundException;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.mapper.GarmentMapper;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.entity.Garment;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.repository.IGarmentRepository;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.service.interfaces.IGarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarmentServiceImpl implements IGarmentService {

    private final String GARMENT_NOT_FOUND = "Prenda no encontrada";

    @Autowired
    private IGarmentRepository garmentRepository;

    @Override
    public GarmentResponseDto saveGarment(GarmentRequestDto garmentRequestDto) {
        Garment garment = garmentRepository.save(GarmentMapper.mapToGarment(garmentRequestDto));
        return GarmentMapper.mapToGarmentResponseDto(garment);
    }

    @Override
    public List<GarmentResponseDto> findAllClothes() {
        List<Garment> clothes = garmentRepository.findAll();
        if (clothes.isEmpty()) {
            throw new NotFoundException("No se encontrarón prendas registradas");
        }
        return clothes.stream().map(GarmentMapper::mapToGarmentResponseDto).toList();
    }

    @Override
    public GarmentResponseDto findGarmentByCode(String code) {
        Garment garment = garmentRepository.findById(code)
                .orElseThrow(() -> new NotFoundException(GARMENT_NOT_FOUND));
        return GarmentMapper.mapToGarmentResponseDto(garment);
    }

    @Override
    public GarmentResponseDto deleteGarmentByCode(String code) {
        GarmentResponseDto garmentResponseDto = findGarmentByCode(code);
        garmentRepository.deleteById(code);
        return garmentResponseDto;
    }

    @Override
    public List<GarmentResponseDto> findGarmentBySize(Integer size) {
        List<Garment> garments = garmentRepository.findAllBySize(size);
        return GarmentMapper.mapToGarmentResponseDtoList(garments);
    }

    @Override
    public List<GarmentResponseDto> findClothesByKeyWordName(String name) {
        List<Garment> garments = garmentRepository.findAllByNameContainsIgnoreCase(name);
        return GarmentMapper.mapToGarmentResponseDtoList(garments);
    }

}
