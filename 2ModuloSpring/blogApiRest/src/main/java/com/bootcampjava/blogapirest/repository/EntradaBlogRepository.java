package com.bootcampjava.blogapirest.repository;

import com.bootcampjava.blogapirest.exception.ExisteEntradaException;
import com.bootcampjava.blogapirest.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class EntradaBlogRepository implements  IEntradaBlogRepository{
    HashMap<Integer, EntradaBlog> todasEntradas = new HashMap<>();
    @Override
    public HashMap<Integer,EntradaBlog> obtenerTodas() {
        return todasEntradas;
    }

    @Override
    public EntradaBlog traerUnaPorId(Integer id) {

        return todasEntradas.get(id);
    }

    @Override
    public EntradaBlog cargarUno(EntradaBlog nuevaEntrada) {

        todasEntradas.put(nuevaEntrada.getId(), nuevaEntrada);
        return nuevaEntrada;
    }
}
