package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    Map<Integer, List<Prenda>> ropero= new HashMap<>();
    int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador=+1;
        ropero.put(contador,listaDePrenda);
        return contador;
    }
    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry: ropero.entrySet()){
            System.out.println("Indice : "+ entry.getKey()+"\n");
            for (Prenda prenda: entry.getValue()){
                System.out.println(prenda.toString());
            }
        }
    }
    public void mostrarPrendas(int codigo){
        List<Prenda> prendas = ropero.get(codigo);
        for (Prenda prenda: prendas){
            System.out.println(prenda.toString());
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return ropero.get(numero);
    }



}
