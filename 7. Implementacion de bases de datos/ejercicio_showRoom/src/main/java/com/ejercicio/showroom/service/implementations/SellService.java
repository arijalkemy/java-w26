package com.ejercicio.showroom.service.implementations;

import com.ejercicio.showroom.dto.ClotheDTO;
import com.ejercicio.showroom.dto.MessageResponseDTO;
import com.ejercicio.showroom.dto.SellDTO;
import com.ejercicio.showroom.entities.Sell;
import com.ejercicio.showroom.exception.NotFoundException;
import com.ejercicio.showroom.repository.SellRepository;
import com.ejercicio.showroom.service.interfaces.ISellService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SellService implements ISellService {
    private final SellRepository sellRepository;
    private final ModelMapper modelMapper;

    public SellService(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageResponseDTO createSell(SellDTO sellDTO) {
        Sell toCreate = modelMapper.map(sellDTO, Sell.class);
        Sell created = sellRepository.save(toCreate);
        return new MessageResponseDTO("Id " + created.getId());
    }

    @Override
    public List<SellDTO> getAllSells() {
         return sellRepository.findAll()
                .stream()
                .map(sell -> modelMapper.map(sell, SellDTO.class))
                .toList();
    }

    @Override
    public SellDTO getSellById(int id) {
        Optional<Sell> result = sellRepository.findById(id);
        if(result.isPresent()) return modelMapper.map(result.get(), SellDTO.class);
        throw new NotFoundException("No se encontraron ventas para el id: " + id);
    }

    @Override
    public SellDTO updateSell(int id, SellDTO sellDTO) {
        getSellById(id);
        sellDTO.setId(id);
        Sell toUpdate = modelMapper.map(sellDTO, Sell.class);
        Sell updated = sellRepository.save(toUpdate);
        return modelMapper.map(updated, SellDTO.class);
    }

    @Override
    public void deleteSell(int id) {
        getSellById(id);
        sellRepository.deleteById(id);
    }

    @Override
    public List<SellDTO> getAllByDate(LocalDate date) {
        List<Sell> result = sellRepository.findAllByDate(date);
        return result
                .stream()
                .map(sell -> modelMapper.map(sell, SellDTO.class))
                .toList();
    }

    @Override
    public List<ClotheDTO> getAllClothesFromSale(int sellId) {
        SellDTO sell = getSellById(sellId);
        return sell.getClothes()
                .stream()
                .map(clothe -> modelMapper.map(clothe, ClotheDTO.class))
                .toList();
    }
}
