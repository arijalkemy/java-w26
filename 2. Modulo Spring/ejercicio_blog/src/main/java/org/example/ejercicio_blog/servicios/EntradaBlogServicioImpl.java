package org.example.ejercicio_blog.servicios;

import org.example.ejercicio_blog.dtos.BlogDTO;
import org.example.ejercicio_blog.excepciones.AllReadyExistsException;
import org.example.ejercicio_blog.excepciones.NotFoundException;
import org.example.ejercicio_blog.modelos.EntradaBlog;
import org.example.ejercicio_blog.repositorios.BlogRepositorio;
import org.example.ejercicio_blog.repositorios.IBlogRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EntradaBlogServicioImpl  implements IEntradaBlogServicio {

    private IBlogRepositorio repositorio = new BlogRepositorio();

    @Override
    public BlogDTO crearEntrada(BlogDTO entradaDTO) {
        if(repositorio.obtenerTodos().stream().anyMatch(x-> x.getId().equals(entradaDTO.getId()))){
            throw new AllReadyExistsException("La entrada con ID : "+ entradaDTO.getId() + " ya existe en el sistema");
        };
        repositorio.crear(entradaDTO);
        return entradaDTO;
    }

    @Override
    public BlogDTO obtenerPorID(Long id) {
        if (repositorio.obtenerPorId(id)==null){
            throw new NotFoundException("La entrada de blog no existe");
        }
        EntradaBlog entradaBlog = repositorio.obtenerPorId(id);
        return new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }

    @Override
    public List<BlogDTO> obtenerTodos() {
        List<BlogDTO> entradas = new ArrayList<>();
        repositorio.obtenerTodos().forEach(entrada -> {
            entradas.add(new BlogDTO(entrada.getId(),entrada.getTitulo(),entrada.getNombreAutor(),entrada.getFechaPublicacion()));
        });
        return entradas;
    }
}
