package org.example.clavescompuestas.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.clavescompuestas.dto.CompraDTO;
import org.example.clavescompuestas.entity.Compra;
import org.example.clavescompuestas.repository.CompraRepository;
import org.example.clavescompuestas.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    private ObjectMapper objectMapper;

    public CompraServiceImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public List<CompraDTO> getAllCompras() {
        List<Compra> compras = compraRepository.findAll();
        return compras.stream().map(this::convertToDTO).toList();
    }

    @Override
    public CompraDTO save(CompraDTO compra) {
        return convertToDTO(compraRepository.save(convertToCompra(compra)));
    }

    Compra convertToCompra(CompraDTO compraDTO) {
        return objectMapper.convertValue(compraDTO, Compra.class);
    }

    CompraDTO convertToDTO(Compra compra) {
        return objectMapper.convertValue(compra, CompraDTO.class);
    }
}
