package com.example.mapeoclavecompuesta.service;

import com.example.mapeoclavecompuesta.model.Compra;
import com.example.mapeoclavecompuesta.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService {

    private final ICompraRepository compraRepository;

    public CompraService(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void saveCompra(Compra compra) {
        this.compraRepository.save(compra);
    }

    @Override
    public List<Compra> getAllCompras() {
        return this.compraRepository.findAll().stream().toList();
    }
}
