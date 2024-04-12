package org.example.classes;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private Map<Integer, List<Prenda>> secciones;

    public GuardaRopa(int id, Map<Integer, List<Prenda>> secciones) {
        this.id = id;
        this.secciones = secciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, List<Prenda>> getSecciones() {
        return secciones;
    }

    public void setSecciones(Map<Integer, List<Prenda>> secciones) {
        this.secciones = secciones;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        secciones.put(secciones.size() + 1, listaDePrenda);
        return secciones.size();
    }

    public void mostrarPrendas() {
        secciones.entrySet().forEach(e -> {
            System.out.println("Key: " + e.getKey());
            System.out.println("Prendas:");
            e.getValue().forEach(Prenda::toString);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasADevolver = secciones.get(numero);
        if (prendasADevolver.size() == 0) {
            System.out.println("No se encontraron las prendas que quiere devolver.");
        } else {
            System.out.println("Se devuelven las prendas: ");
            System.out.println(prendasADevolver.toString());
            secciones.remove(numero);
        }
        return prendasADevolver;
    }
}
