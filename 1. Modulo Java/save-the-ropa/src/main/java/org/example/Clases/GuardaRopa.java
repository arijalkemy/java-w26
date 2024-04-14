package org.example.Clases;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> listaPrendas;
    private static int contador;

    public GuardaRopa() {
        this.listaPrendas = new HashMap<Integer, List<Prenda>>();
        contador = 0;
    }

    public HashMap<Integer, List<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(HashMap<Integer, List<Prenda>> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public int guardarPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas.put(++contador, listaPrendas);
        return contador;
    }

    public void mostrarPendas() {
        listaPrendas.entrySet().forEach(x -> {
            System.out.print(x.getKey() + "   ");
            System.out.println(x.getValue());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {

        return listaPrendas.remove(numero);
    }


}
