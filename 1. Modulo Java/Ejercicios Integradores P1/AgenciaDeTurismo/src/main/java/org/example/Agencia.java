package org.example;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Localizador> localizadores;

    public Agencia(){
        this.localizadores = new ArrayList<>();
    }

    public void imprimirLocalizadores(){
        this.localizadores.forEach(x -> System.out.println(x.toString()));
    }

    public void agregarLocalizador(Localizador localizador){
        if (this.localizadores.stream().filter(x -> x.getCliente().equals(localizador.getCliente())).count() >= 2){
            localizador.agregarDescuento(new Descuento(0.05));
        }
        localizadores.add(localizador);
    }
}
