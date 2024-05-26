package org.example.compra.services;

import org.example.compra.Dto.CompraRequestDto;
import org.example.compra.model.Compra;
import org.example.compra.repository.CompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    CompraRepository compraRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public CompraRequestDto create(CompraRequestDto compraRequestDto) {
        Compra compra =compraRepository.save(modelMapper.map(compraRequestDto, Compra.class));
        return modelMapper.map(compra, CompraRequestDto.class);
    }
}
