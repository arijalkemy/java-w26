package com.bootcampjava.blogapirest.service;

import com.bootcampjava.blogapirest.exception.BaseDeDatosVaciaException;
import com.bootcampjava.blogapirest.exception.ExisteEntradaException;
import com.bootcampjava.blogapirest.exception.NotFoundException;
import com.bootcampjava.blogapirest.model.DTO.EntradBlogDTO;
import com.bootcampjava.blogapirest.model.EntradaBlog;
import com.bootcampjava.blogapirest.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogService implements IEntradaBlogService{
    private final static String mensajeBaseDeDatos = "Existe una entrada en la base de datos con Id ";
    @Autowired
    EntradaBlogRepository entradasRepo;

    @Override
    public EntradBlogDTO traerUnaPorId(Integer id) {
        if(entradasRepo.obtenerTodas().containsKey(id)== false){
            throw  new NotFoundException("no existe la entrada de blog con "+ id);
        }
        EntradaBlog entrada =entradasRepo.traerUnaPorId(id);
        return mapToDto(entrada);
    }

    @Override
    public List<EntradBlogDTO> traerTodas() {
        List<EntradaBlog> entradas =entradasRepo.obtenerTodas().values().stream().toList();
        List<EntradBlogDTO> respuesta = new ArrayList<>();
        if(entradas.isEmpty()){
            throw new BaseDeDatosVaciaException();
        }
            return entradas.stream().map(e-> mapToDto(e)).toList();


    }

    @Override
    public EntradBlogDTO cargarUna(EntradaBlog nuevaEntrada) {
        if(entradasRepo.obtenerTodas().containsKey(nuevaEntrada.getId())){
            throw  new ExisteEntradaException(mensajeBaseDeDatos + nuevaEntrada.getId());
        }else{
             entradasRepo.cargarUno(nuevaEntrada);
             return mapToDto(nuevaEntrada);
        }
    }
    EntradBlogDTO mapToDto(EntradaBlog entrada){
        return new EntradBlogDTO(entrada.getTitulo(),entrada.getFechaSubida(), entrada.getNombreAutor());
    }
}
