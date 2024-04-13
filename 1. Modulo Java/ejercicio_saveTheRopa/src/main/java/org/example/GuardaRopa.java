package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int contador;
    private HashMap<Integer, List<Prenda>> diccionario;

    public GuardaRopa(){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public GuardaRopa(int contador, HashMap<Integer, List<Prenda>> diccionario) {
        this.contador = contador;
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.diccionario.put(contador, listaDePrendas);
        contador++;
        return contador;
    }

    public void mostrarPrendas(){
        this.diccionario.forEach((key, value) -> {
                System.out.println("Llave: " + key + "\n");
                for(Prenda prenda: value){
                    System.out.println(prenda);
                };
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.diccionario.get(numero);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }
}
