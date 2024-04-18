package com.bootcamp.c4blog.repository;

import com.bootcamp.c4blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibrosRepository {

    List<EntradaBlog> entradaBlogList;

    public LibrosRepository() {
        this.entradaBlogList = new ArrayList<>();
    }

    public int agregarEntrada(EntradaBlog entradaBlog){
        entradaBlogList.add(entradaBlog);
        return entradaBlog.getId();
    }

    public List<EntradaBlog> mostrarEntradas(){
        return entradaBlogList;
    }

    public boolean existeEntrada(int id){
        return entradaBlogList.stream().anyMatch(entradaBlog -> entradaBlog.getId() == id);
    }

    public EntradaBlog buscarEntrada(int id){
        return entradaBlogList.stream().filter(entradaBlog -> entradaBlog.getId() == id).findFirst().orElse(null);
    }

    public List<EntradaBlog> obtenerTodasLasEntradas(){
        return entradaBlogList;
    }

}
