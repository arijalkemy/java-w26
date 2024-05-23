package com.ejerciciosjpa.extrajpa.service.implementation;

import com.ejerciciosjpa.extrajpa.dto.ClothRequestDto;
import com.ejerciciosjpa.extrajpa.dto.ClothResponseDto;
import com.ejerciciosjpa.extrajpa.entities.Cloth;
import com.ejerciciosjpa.extrajpa.repository.IClothesRepository;
import com.ejerciciosjpa.extrajpa.service.IClotheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothServiceImpl implements IClotheService {

    @Autowired
    IClothesRepository clothesRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public List<ClothResponseDto> getAllClothes() {
        return clothesRepository.findAll().stream().map(e->mapper.map(e, ClothResponseDto.class)).toList();
    }

    @Override
    public ClothResponseDto getClothByCode(Long code) {
        return mapper.map(clothesRepository.findByCodigo(code),ClothResponseDto.class);
    }

    @Override
    public List<ClothResponseDto> getClothBySize(Integer size) {
        return clothesRepository.findClothByTalle(size).stream().map(e->mapper.map(e,ClothResponseDto.class)).toList();
    }

    @Override
    public ClothResponseDto addCloth(ClothRequestDto request) {
        Cloth response = clothesRepository.save(mapper.map(request,Cloth.class));
        return mapper.map(response,ClothResponseDto.class);
    }

    @Override
    public ClothResponseDto updateCloth(Long codigo, ClothRequestDto request) {
        Cloth cloth = mapper.map(getClothByCode(codigo),Cloth.class);
        cloth.setCodigo(cloth.getCodigo());
        cloth.setNombre(request.getNombre());
        cloth.setTipo(request.getTipo());
        cloth.setMarca(request.getMarca());
        cloth.setTalle(request.getTalle());
        cloth.setCantidad(request.getCantidad());
        cloth.setPrecioVenta(request.getPrecioVenta());

        Cloth response = clothesRepository.save(cloth);
        return mapper.map(response,ClothResponseDto.class);
    }

    @Override
    public List<ClothResponseDto> getClothesByKey(String word) {
        return clothesRepository.findClothByNombre(word).stream().map(e->mapper.map(e,ClothResponseDto.class)).toList();
    }

    @Override
    public void deleteClothById(Long code) {
        clothesRepository.deleteById(code);
    }
}
