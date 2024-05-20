package org.ggomezr.clavescompuestas.application.service.impl;

import org.ggomezr.clavescompuestas.application.service.interfaces.ICompraService;
import org.ggomezr.clavescompuestas.domain.dto.CompraDTO;
import org.ggomezr.clavescompuestas.domain.model.Compra;
import org.ggomezr.clavescompuestas.domain.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService {

    private final ICompraRepository compraRepository;
    private final ModelMapper modelMapper;

    public CompraService(ICompraRepository compraRepository, ModelMapper modelMapper) {
        this.compraRepository = compraRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompraDTO crearCompra(CompraDTO compraDTO) {
        compraRepository.save(convertCompraDtoToCompra(compraDTO));
        return compraDTO;
    }

    @Override
    public List<CompraDTO> obtenerTodasLasCompras() {
        return compraRepository.findAll().stream()
                .map(this::convertCompraToCompraDTO)
                .toList();
    }

    private CompraDTO convertCompraToCompraDTO(Compra compra){
        return modelMapper.map(compra, CompraDTO.class);
    }

    private Compra convertCompraDtoToCompra(CompraDTO compraDTO){
        return modelMapper.map(compraDTO, Compra.class);
    }
}
