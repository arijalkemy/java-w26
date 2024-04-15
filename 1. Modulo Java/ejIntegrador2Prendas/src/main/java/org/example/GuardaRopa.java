package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    HashMap<Integer, List<Prenda>> mapPrenda;
    Integer contador;

    public GuardaRopa() {
        mapPrenda = new HashMap<Integer, List<Prenda>>();
        contador = 0;
    }

    /**
     * Guarda lista de prendas en hashmap
     * @param listaDePrendas
     * @return ID
     */
    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contador++;
        mapPrenda.put(contador, listaDePrendas);
        return contador;
    }

    /**
     * Busca e imprime todas las prendas del guardaropa
     *
     */
    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entrada: mapPrenda.entrySet()){
            System.out.printf("ID: %d \t Prenda: %s", entrada.getKey(), entrada.getValue());
        }
    }

    /**
     * Devuelve una listaprendas específica
     * @param numero
     * @return listaPrendas
     */
    public List<Prenda> devolverPrendas(Integer numero){
        return mapPrenda.get(numero);
    }

}
