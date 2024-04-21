package com.sinc_ejercicioblog.servicio.implementacion;

import com.sinc_ejercicioblog.dto.EntradaBlogDTO;
import com.sinc_ejercicioblog.entidad.EntradaBlog;
import com.sinc_ejercicioblog.excepcion.IdBlogExistente;
import com.sinc_ejercicioblog.excepcion.IdBlogInexistente;
import com.sinc_ejercicioblog.repositorio.RepositorioBlog;
import com.sinc_ejercicioblog.servicio.IEntradaBlogServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogServicioImplementacion implements IEntradaBlogServicio {

    @Autowired
    private RepositorioBlog repoBlog;

    @Override
    public String crearEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        String mensaje = "";
        if (repoBlog.getListaEntradasBlogs()
                .stream()
                .filter(b -> b.getIdBlog() == entradaBlogDTO.getIdBlog())
                .findFirst()
                .orElse(null) == null) {
            //el id ingresado no esta en suo
            repoBlog.agregarEntradaBlog(convertirDTO(entradaBlogDTO));
            mensaje = String.format("El blog ha sido creado con el id %d", entradaBlogDTO.getIdBlog());
        } else {
            //ya existe el id
            mensaje = "El id ingresado ya está en uso. No se agrega el blog.";
            throw new IdBlogExistente(mensaje);
        }
        return mensaje;
    }

    @Override
    public EntradaBlogDTO buscarEntradaBlogPorId(int id) {
        EntradaBlog entradaBlog = repoBlog.getListaEntradasBlogs()
                                            .stream()
                                            .filter(b -> b.getIdBlog() == id)
                                            .findFirst()
                                            .orElse(null);
        if (entradaBlog != null) {
            //si existe blog con el id ingresado
            return convertirADTO(entradaBlog);
        } else {
            String mensaje = "No existe blog con el id " + id;
            throw new IdBlogInexistente(mensaje);
        }
    }

    @Override
    public List<EntradaBlogDTO> buscarTodosLosBlogs() {
        List<EntradaBlogDTO> entradaBlogDTOList = new ArrayList<>();
        for (EntradaBlog entradaBlog : repoBlog.getListaEntradasBlogs()) {
            entradaBlogDTOList.add(convertirADTO(entradaBlog));
        }
        return entradaBlogDTOList;
    }

    public EntradaBlog convertirDTO(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDTO.getIdBlog(),
                                        entradaBlogDTO.getTitulo(),
                                        entradaBlogDTO.getNombreAutor(),
                                        entradaBlogDTO.getFechaPublicacion());
        return entradaBlog;
    }

    public EntradaBlogDTO convertirADTO(EntradaBlog entradaBlog) {
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO(entradaBlog.getIdBlog(),
                entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion());
        return entradaBlogDTO;
    }
}
