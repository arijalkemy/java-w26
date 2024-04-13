package org.example.ropero;

import org.example.prenda.Prenda;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> mapPrendas;

    private int contador;

    public GuardaRopa() {
        mapPrendas = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        contador++;

        mapPrendas.put(contador, listaDePrendas);
        System.out.println("Se guardo la prenda en la posición " + contador);

        return contador;
    }

    public void imprimirPrendas(List<Prenda> listaPrendas) {
        System.out.println("Lista de prendas: ");
        listaPrendas.forEach(prenda -> {
            // Imprimir la marca y el modelo de cada prenda
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        });
    }

    public void mostrarPrendas(){
        mapPrendas.forEach((clave, listaPrendas) -> {
            System.out.println("Clave: " + clave);
            imprimirPrendas(listaPrendas);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return mapPrendas.get(numero);
    }

}
