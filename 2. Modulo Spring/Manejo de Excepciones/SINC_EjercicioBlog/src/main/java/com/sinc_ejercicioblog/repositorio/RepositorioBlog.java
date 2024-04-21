package com.sinc_ejercicioblog.repositorio;

import com.sinc_ejercicioblog.entidad.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositorioBlog {
    public static List<EntradaBlog> listaEntradasBlogs = new ArrayList<>();

    public void agregarEntradaBlog(EntradaBlog entradaBlog) {
        listaEntradasBlogs.add(entradaBlog);
    }

    public List<EntradaBlog> getListaEntradasBlogs() {
        return listaEntradasBlogs;
    }
}
