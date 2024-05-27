package com.example.mapeoclavecompuesta.service;

import com.example.mapeoclavecompuesta.model.Compra;

import java.util.List;

public interface ICompraService {
    void saveCompra(Compra compra);
    List<Compra> getAllCompras();
}
