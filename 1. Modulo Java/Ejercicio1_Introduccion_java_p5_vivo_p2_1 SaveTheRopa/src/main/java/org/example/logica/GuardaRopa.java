package org.example.logica;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GuardaRopa {
    //Atributo
    private Map<Integer, List<Prenda>> diccionario_guarda_ropa;
    private int contador;

    //Constructor
    public GuardaRopa() {
        this.diccionario_guarda_ropa = new HashMap<Integer, List<Prenda>>();
        this.contador = 0;
    }

    //Metodo que permite guardar prenda
    public Integer guardarPrenda(List<Prenda> prenda) {
        diccionario_guarda_ropa.put(contador, prenda);
        this.contador++;
       return contador - 1;
    }
    //Permite mostrar prendas
    public void mostrarPrendas() {
        for (List<Prenda> prenda : diccionario_guarda_ropa.values()) {
            for (Prenda prenda1 : prenda) {
                System.out.println(prenda1.toString());
            }
        }
    }

    //Permite devolver prendas
    public List<Prenda> devolverPrenda(Integer numero) {
        return diccionario_guarda_ropa.get(numero);
    }


}
