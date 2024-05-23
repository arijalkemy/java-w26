package com.example.Compra.service.impl;

import com.example.Compra.model.Compra;
import com.example.Compra.repository.ICompraRepository;
import com.example.Compra.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Override
    public Compra saveCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

}
