package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exceptions.AlreadyExistsException;
import com.example.blog.exceptions.NotFoundException;
import com.example.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class EntradaBlogService implements IServiceEntradaBlog {


    @Autowired
    EntradaBlogRepository repository;

    @Override
    public EntradaBlogDTO guardarEntrada(EntradaBlogDTO entrada) {
        List<EntradaBlog> entradas = repository.getEntradas();

        if (!entradas.isEmpty()) {
            for (EntradaBlog item : entradas) {
                if (item.getId() == entrada.getId()) {
                  throw new AlreadyExistsException("No se pudo crear: ya existe una entrada con la ID especificada");
                }
            }
        }

        EntradaBlog nuevaEntrada = new EntradaBlog(entrada.getId(), entrada.getTitulo(), entrada.getNombreAutor(),
                entrada.getFechaPublicacion());
        repository.guardarEntradas(nuevaEntrada);

        return entrada;

    }

    public EntradaBlogDTO mostrarEntrada(int id) {

        EntradaBlog entradaBlog = repository.getEntrada(id);
        if(entradaBlog == null) throw new NotFoundException("No existe la entrada con id: "+ id );
        return new
                EntradaBlogDTO(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion());
    }

    public List<EntradaBlogDTO> mostrarEntradas() {
        List<EntradaBlogDTO> entradasDTO = new ArrayList<>();

        if(repository.getEntradas().isEmpty()) throw new NotFoundException("No existen entradas");
        for (EntradaBlog item : repository.getEntradas()

        ) {
            entradasDTO.add(new EntradaBlogDTO(item.getId(), item.getTitulo(), item.getNombreAutor(),
                    item.getFechaPublicacion()));

        }
        return entradasDTO;
    }


}
