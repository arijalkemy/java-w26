package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;

import java.util.List;

public interface IServiceEntradaBlog {

    public EntradaBlogDTO guardarEntrada(EntradaBlogDTO entrada);
    public EntradaBlogDTO mostrarEntrada(int id);
    public List<EntradaBlogDTO> mostrarEntradas();
}
