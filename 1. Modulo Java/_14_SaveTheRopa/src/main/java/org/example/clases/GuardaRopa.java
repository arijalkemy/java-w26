package org.example.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> almacenamiento;
    private int id=0;

    public Map<Integer, List<Prenda>> getAlmacenamiento() {
        return almacenamiento;
    }

    public GuardaRopa(){
        this.almacenamiento = new HashMap<>();
    }

    public GuardaRopa(List<Prenda> prendas) {
        this.id = aumentarId();
        this.almacenamiento.put(id,prendas);
    }

    public void setAlmacenamiento( List<Prenda> prendas) {
        this.id = aumentarId();
        this.almacenamiento.put(id,prendas);
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        this.id = aumentarId();
        this.almacenamiento.put(id,prendas);

        return id;
    }


    public List<Prenda> devolverPrendas(Integer id){
        return almacenamiento.entrySet().stream()
                .filter(entry->entry.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
    private int aumentarId(){
        this.id += 1;
        return this.id;
    }

    public void mostrarPrendas(){
        almacenamiento.forEach((id, prendas) -> {
            System.out.println("ID: " + id);
            prendas.forEach(System.out::println);
        });
    }
}
