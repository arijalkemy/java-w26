package com.example.Compra.service;

import com.example.Compra.model.Compra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompraService {
    public Compra saveCompra(Compra compra);
    public List<Compra> getAllCompras();

}
