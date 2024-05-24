package clave.compuesta.service;

import clave.compuesta.dto.CompraRequestDto;
import clave.compuesta.dto.CompraResponseDto;
import clave.compuesta.model.Compra;
import clave.compuesta.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraService implements ICompraService{
    private final ICompraRepository compraRepository;
    private final ModelMapper modelMapper;

    public CompraService(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
        this.modelMapper = new ModelMapper();
    }

    public CompraResponseDto saveCompra(CompraRequestDto compraRequestDto) {
        Compra compra = modelMapper.map(compraRequestDto, Compra.class);
        compraRepository.save(compra);
        return modelMapper.map(compra, CompraResponseDto.class);
    }

    public List<CompraResponseDto> findAll() {
        return compraRepository.findAll().stream()
                .map(compra -> modelMapper.map(compra, CompraResponseDto.class))
                .collect(Collectors.toList());
    }
}
