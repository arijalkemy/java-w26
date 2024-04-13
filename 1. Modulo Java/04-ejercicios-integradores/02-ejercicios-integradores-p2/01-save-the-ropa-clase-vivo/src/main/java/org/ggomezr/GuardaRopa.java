package org.ggomezr;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private HashMap<Integer, List<Prenda>> listaPrendas;

    public GuardaRopa() {
        this.listaPrendas = new HashMap<>();
        this.id = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        listaPrendas.put(id, listaDePrenda);
        return id++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry: listaPrendas.entrySet()){
            int id = entry.getKey();
            List<Prenda> prendas = entry.getValue();
            System.out.println("Identificador: " + id);
            for(Prenda prenda : prendas){
                System.out.println("Modelo: " + prenda.getModelo() +  ", Marca: " + prenda.getMarca());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        listaPrendas.remove(numero);
        return listaPrendas.get(numero);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(HashMap<Integer, List<Prenda>> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }
}
