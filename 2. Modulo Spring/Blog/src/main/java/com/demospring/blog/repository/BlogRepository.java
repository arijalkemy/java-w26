package com.demospring.blog.repository;

import com.demospring.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    private List<EntradaBlog> entradas;

    public BlogRepository() {
        this.entradas = crearEntradas();
    }

    private List<EntradaBlog> crearEntradas(){
        return new ArrayList<>(){{
            add(new EntradaBlog(1, "10 formas de mejorar tu productividad", "Juan Perez", "2024-04-18"));
            add(new EntradaBlog(2, "Los beneficios de la meditación diaria", "María López", "2024-04-17"));
            add(new EntradaBlog(3, "Cómo empezar un negocio en línea", "Carlos Ramirez", "2024-04-16"));
            add(new EntradaBlog(4, "Recetas saludables para la cena", "Ana González", "2024-04-15"));
            add(new EntradaBlog(5, "Consejos para mejorar tu sueño", "Roberto Martinez", "2024-04-14"));
        }};
    }

    @Override
    public void addEntrada(EntradaBlog entrada) {
        this.entradas.add(entrada);
    }

    @Override
    public EntradaBlog getEntrada(int id) {
        return this.entradas.stream().filter(entradaBlog -> entradaBlog.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<EntradaBlog> getEntradas() {
        return this.entradas;
    }
}
