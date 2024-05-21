package com.example.clavecompuesta.service.impl;

import com.example.clavecompuesta.entity.Compra;
import com.example.clavecompuesta.repository.ICompraRepository;
import com.example.clavecompuesta.service.ICompraService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements ICompraService {

    private final ICompraRepository compraRepository;

    @Override
    @Transactional
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }
}
