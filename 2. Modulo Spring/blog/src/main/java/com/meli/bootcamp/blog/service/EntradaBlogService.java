package com.meli.bootcamp.blog.service;

import com.meli.bootcamp.blog.dto.RequestEntradaBlogDto;
import com.meli.bootcamp.blog.dto.ResponseEntradaBlogDto;
import com.meli.bootcamp.blog.exception.DuplicatedEntityException;
import com.meli.bootcamp.blog.exception.NotFoundException;
import com.meli.bootcamp.blog.model.EntradaBlog;
import com.meli.bootcamp.blog.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService {
    IRepository<EntradaBlog> entradaBlogIRepository;

    @Autowired
    public EntradaBlogService(IRepository<EntradaBlog> entradaBlogIRepository) {
        this.entradaBlogIRepository = entradaBlogIRepository;
    }

    public String  add(RequestEntradaBlogDto dto){
        EntradaBlog entradaBlog = parseToEntity(dto);
        Optional<EntradaBlog> entradaBlogOptional = entradaBlogIRepository.findById(entradaBlog.getId());
        if(entradaBlogOptional.isPresent()){
            throw new DuplicatedEntityException("La entidad ya esta en la base de datos");
        }
        else{
            entradaBlogIRepository.add(entradaBlog);
            return "La entrada fue creada correctamente id: " + entradaBlog.getId();
        }
    }

    public ResponseEntradaBlogDto getById(Integer id){
        Optional<EntradaBlog> entradaBlogOptional = entradaBlogIRepository.findById(id);
        if(entradaBlogOptional.isPresent()){
            return parseToDto(entradaBlogOptional.get());
        }
        else{
            throw new NotFoundException("Entrada no encontrada con id: " + id);
        }
    }

    public List<ResponseEntradaBlogDto> getAll(){
        List<EntradaBlog> entradaBlogs = entradaBlogIRepository.getAll();
        return entradaBlogs.stream()
                .map(this::parseToDto)
                .collect(Collectors.toList());
    }

    private ResponseEntradaBlogDto parseToDto(EntradaBlog e){
        return new ResponseEntradaBlogDto(e.getTitulo(),e.getAutor(),e.getFechaPublicacion());
    }
    private EntradaBlog parseToEntity(RequestEntradaBlogDto dto){
        return new EntradaBlog(dto.getId(),dto.getTitulo(),dto.getAutor(),dto.getFechaPublicacion());
    }
}
