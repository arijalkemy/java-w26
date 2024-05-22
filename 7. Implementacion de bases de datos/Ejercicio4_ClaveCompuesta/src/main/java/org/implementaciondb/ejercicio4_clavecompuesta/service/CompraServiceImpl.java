package org.implementaciondb.ejercicio4_clavecompuesta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.implementaciondb.ejercicio4_clavecompuesta.dto.CompraDto;
import org.implementaciondb.ejercicio4_clavecompuesta.entity.Compra;
import org.implementaciondb.ejercicio4_clavecompuesta.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Override
    public void saveCompra(CompraDto compraDto) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Compra compra = mapper.convertValue(compraDto, Compra.class);
        compraRepository.save(compra);
    }
}
