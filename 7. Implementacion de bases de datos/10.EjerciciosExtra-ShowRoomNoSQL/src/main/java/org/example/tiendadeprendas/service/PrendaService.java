package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.exception.NotFoundException;
import org.example.tiendadeprendas.model.Prenda;
import org.example.tiendadeprendas.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PrendaService implements IPrendaService{

    @Autowired
    IPrendaRepository prendaRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createPrenda(PrendaDto prendaDto) {
        prendaRepository.save(modelMapper.map(prendaDto, Prenda.class));
    }

    @Override
    public PrendaDto findByCode(String code) {
        Prenda prenda = prendaRepository.findById(code).orElseThrow(
                () -> new NotFoundException("NO SE ENCONTRÓ LA PRENDA CON EL CODIGO"+ code)
        );
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public void updatePrenda(String code, PrendaDto prendaDto) {
        findByCode(code);
        Prenda prenda = modelMapper.map(prendaDto,Prenda.class);
        prenda.setCodigo(code);
        prendaRepository.save(prenda);
    }

    @Override
    public void deletePrenda(String code) {
        prendaRepository.deleteById(code);
    }

    @Override
    public List<PrendaDto> allPrendas() {
        Iterable<Prenda> iterable = prendaRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList()
                .stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> prendasBySize(String size) {
        Iterable<Prenda> iterable = prendaRepository.findPrendasByTalla(size);
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList()
                .stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }


    public List<PrendaDto> findPrendasByName(String name) {
        Iterable<Prenda> iterable = prendaRepository.findByNombre(name);
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList()
                .stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }
}
