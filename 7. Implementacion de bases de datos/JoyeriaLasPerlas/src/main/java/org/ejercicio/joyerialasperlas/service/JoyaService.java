package org.ejercicio.joyerialasperlas.service;

import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.ejercicio.joyerialasperlas.dto.JoyaCreatedDto;
import org.ejercicio.joyerialasperlas.dto.JoyaResponseDto;
import org.ejercicio.joyerialasperlas.dto.JoyaUpdateDto;
import org.ejercicio.joyerialasperlas.exception.BadRequestException;
import org.ejercicio.joyerialasperlas.exception.NotFoundException;
import org.ejercicio.joyerialasperlas.model.Joya;
import org.ejercicio.joyerialasperlas.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    private JoyaRepository joyaRepository;
    private ModelMapper modelMapper = new ModelMapper();;

    @Override
    public JoyaCreatedDto guardarJoya(JoyaCreateDto joyaDto) {
        Joya joya = modelMapper.map(joyaDto, Joya.class);
        joya = joyaRepository.save(joya);
        return modelMapper.map(joya, JoyaCreatedDto.class);
    }

    @Override
    public JoyaResponseDto actualizarJoya(Long id, JoyaUpdateDto joyaDto) {
        Joya joya = joyaRepository.findById(id).orElseThrow(()->
                new NotFoundException("No existe la joya con id" + id));

        modelMapper.map(joyaDto, joya);

        joya = joyaRepository.save(joya);

        return modelMapper.map(joya, JoyaResponseDto.class);
    }

    @Override
    public List<JoyaResponseDto> obtenerJoyas() {
        //Obtiene todas las joyas del repositorio, las filtra por las que estén en venta y después lo mapea al
        // DTO correspondiente
        return modelMapper.map(joyaRepository.findAll().stream().filter(j-> j.getVentaONo().equals(Boolean.TRUE))
                        .toList(),
                new TypeToken<List<JoyaResponseDto>>() {}
                .getType());
    }

    @Override
    public void eliminarJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElseThrow(()->
                new NotFoundException("No existe la joya con id" + id));

        if(joya.getVentaONo()){
            throw new BadRequestException("No se puede eliminar una joya en venta");
        }

        joyaRepository.deleteById(joya.getId());
    }


}
