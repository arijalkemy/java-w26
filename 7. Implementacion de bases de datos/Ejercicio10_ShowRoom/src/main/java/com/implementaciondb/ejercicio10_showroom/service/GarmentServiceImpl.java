package com.implementaciondb.ejercicio10_showroom.service;

import com.implementaciondb.ejercicio10_showroom.exception.NotFoundException;
import com.implementaciondb.ejercicio10_showroom.mapper.GarmentMapper;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import com.implementaciondb.ejercicio10_showroom.repository.IGarmentRepository;
import com.implementaciondb.ejercicio10_showroom.service.interfaces.IGarmentService;
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
    public GarmentResponseDto findGarmentByCode(Long code) {
        Garment garment = garmentRepository.findById(code)
                .orElseThrow(() -> new NotFoundException(GARMENT_NOT_FOUND));
        return GarmentMapper.mapToGarmentResponseDto(garment);
    }

    @Override
    public GarmentResponseDto deleteGarmentByCode(Long code) {
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
