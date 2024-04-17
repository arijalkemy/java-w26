package com.example.ejdeportevivo.repositorios;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class Repositorio<T> {

    List<T> lista = new ArrayList<>();

    public void guardar(T objecto){
        this.lista.add(objecto);
    }

    public List<T> obtenerTodos(){
        return this.lista;
    }

}
