package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{
    private List<EntradaBlog> entradas;

    public EntradaBlogRepository (){
        this.entradas = new ArrayList<>();
    }
    @Override
    public void guardarEntradas(EntradaBlog entrada) {
        System.out.println("guardado!!");
        entradas.add(entrada);
    }

    @Override
    public List<EntradaBlog> getEntradas() {
        return entradas;
    }

    @Override
    public EntradaBlog getEntrada(int id){
      return  entradas.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
    }
}
