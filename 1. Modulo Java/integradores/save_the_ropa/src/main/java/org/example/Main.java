package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardarropa = new GuardaRopa();
        List<Prenda> prendas1 = new ArrayList<Prenda>(){{
            add(new Prenda("campera","cuero"));
            add(new Prenda("pantalon","blanco"));
        }};
        guardarropa.mostrarPrendas();
        List<Prenda> prendas2 = new ArrayList<Prenda>(){{
            add(new Prenda("remera","corta"));
            add(new Prenda("sombrero","negro"));
        }};
        //guardo dos prendas
        int codigoPrimerprenda = guardarropa.guardarPrendas(prendas1);
        int codigoSeguindaPrenda = guardarropa.guardarPrendas(prendas2);

        guardarropa.mostrarPrendas();

        System.out.println("imprimo prenda guardada: "+ codigoPrimerprenda);
        System.out.println(
                guardarropa.devolverPrendas(codigoPrimerprenda)
        );
    }
}
