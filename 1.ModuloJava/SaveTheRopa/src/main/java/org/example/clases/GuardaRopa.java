package org.example.clases;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class GuardaRopa {
    private String ubicacion;
    private int id;
    private Map<Integer, List<Prenda>> prendasGuardadas;



    public void guardarPrendas(List<Prenda> prendas){
        Random random = new Random();

        // Generar un número entero aleatorio
        int alet = random.nextInt(9999);
        this.prendasGuardadas.put(alet,prendas);
        System.out.println("Su lista de prendas se guardo en el Guarda Ropa de ubcacion "+ this.ubicacion+" El codigo de retiro es"+ alet);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GuardaRopa(String ubicacion, int id, Map<Integer, List<Prenda>> prendasGuardadas) {
        this.ubicacion = ubicacion;
        this.id = id;
        this.prendasGuardadas = prendasGuardadas;
    }

    public Map<Integer, List<Prenda>> getPrendasGuardadas() {
        return prendasGuardadas;
    }

    public void setPrendasGuardadas(Map<Integer, List<Prenda>> prendasGuardadas) {
        this.prendasGuardadas = prendasGuardadas;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : prendasGuardadas.entrySet()){
            System.out.println("Prendas con codigo "+ entry.getKey() + " { ");
            for (Prenda p: entry.getValue()){
                System.out.println(p.toString());
            }
            System.out.println(" } ");
        }
    }
    public void devolverPrendas(int k){
        List<Prenda> auxiliar = this.prendasGuardadas.get(k);
        this.prendasGuardadas.remove(k);
        System.out.println("Las siguientes prendas se devolvieron");
        for (Prenda p: auxiliar){
            System.out.println(p.toString());
        }

    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "ubicacion='" + ubicacion + '\'' +
                ", id=" + id +
                ", prendasGuardadas=" + prendasGuardadas +
                '}';
    }
}
