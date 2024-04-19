package com.meli.blog.service;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.dto.MensajeDTO;
import com.meli.blog.exceptions.NotFoundException;
import com.meli.blog.model.EntradaBlog;
import com.meli.blog.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository repository;

    @Override
    public MensajeDTO crearEntrada(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entrada = convertDto(entradaBlogDTO);
        try {
            repository.save(entrada);
        } catch (Exception e) {
            throw new NotFoundException("No se pudo crear la entrada al blog");
        }

        return new MensajeDTO("Se guardaron los cambios y se creo la entrada con ID: " + entrada.getId());
    }

    @Override
    public EntradaBlogDTO getEntrada(String id) {
        EntradaBlog entrada = repository.buscarPorId(id);
        if(entrada == null) {
            throw new NotFoundException("No se encontro la entrada con el id: " + id);
        }

        return converToDto(repository.buscarPorId(id));
    }

    @Override
    public List<EntradaBlogDTO> getListaEntradas() {
        return repository.getAll().stream()
                .map(this::converToDto)
                .toList();
    }

    private EntradaBlog convertDto(EntradaBlogDTO entradaBlogDTO){
        return new EntradaBlog(
                entradaBlogDTO.getTitulo(),
                entradaBlogDTO.getAutor(),
                LocalDate.parse(entradaBlogDTO.getFechaPublicacion()));
    }

    private EntradaBlogDTO converToDto(EntradaBlog entradaBlog){
        return new EntradaBlogDTO(entradaBlog.getTitulo(), entradaBlog.getAutor(),
                entradaBlog.getFechaPublicacion().toString());
    }
}
