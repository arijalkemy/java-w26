package org.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas = new HashMap<Integer, List<Prenda>>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        prendas.put(contador, listaDePrendas);
        System.out.println("el id de la orden es: " + contador );
        return contador++;
    }
    public void mostrarPrendas(){
        prendas.forEach((k,v) -> {
            System.out.println("Id de la orden " + k);
            v.forEach(prenda -> System.out.println(prenda.getMarca() + " " + prenda.getModelo()));
        });
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }


}
