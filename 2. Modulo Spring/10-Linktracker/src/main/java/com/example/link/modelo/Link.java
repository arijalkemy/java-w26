package com.example.link.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private int cantidadDeVecesQueSeRedirecciono = 0;
    private boolean estaInvalidado  = false;

    public Link(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public void redireccionar(){
        this.cantidadDeVecesQueSeRedirecciono ++;
    }

    public void invalidar(){
        estaInvalidado = true;
    }
}
