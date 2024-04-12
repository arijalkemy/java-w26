package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private Integer contador;

    GuardaRopa(){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }


    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador += 1;
        this.diccionario.put(this.contador,listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> dicEntry : diccionario.entrySet()) {
            System.out.println(dicEntry);
        }
    }


    public List<Prenda> devolverPrendas(Integer identificador){
        return diccionario.get(identificador);
    }

}
