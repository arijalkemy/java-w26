package com.example.BlogAnotation.service.implement;

import com.example.BlogAnotation.repository.IRepoBD;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.BlogAnotation.dto.EntradaBlogDTO;
import com.example.BlogAnotation.entity.EntradaBlog;
import com.example.BlogAnotation.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogImpl implements IEntradaBlogService {
    @Autowired
    IRepoBD database;

    @Override
    public String crearEntradaBlog(EntradaBlogDTO entradaBlog) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return database.crearEntradaBlog(mapper.convertValue(entradaBlog,EntradaBlog.class));
    }

    @Override
    public EntradaBlogDTO obtenerBlogPorId(Integer id) {
        EntradaBlog entrada = database.obtenerBlogPorId(id);
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        System.out.println("Objeto a retornar"+entrada.getNombreAutor());
        return mapper.convertValue(entrada, EntradaBlogDTO.class);
    }

    @Override
    public List<EntradaBlogDTO> obtenerTodosBlogs() {
        List<EntradaBlog> entradas = database.obtenerTodosBlogs();
        List<EntradaBlogDTO> entradasDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        for (EntradaBlog entrada : entradas){
            entradasDTO.add(mapper.convertValue(entrada,EntradaBlogDTO.class));
        }
        return entradasDTO;
    }
}
