package org.example.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private final Map<Integer, List<Prenda>> prendasGuardadas;
    private int siguienteCodigo;


    public GuardaRopa() {
        this.prendasGuardadas = new HashMap<>();
        this.siguienteCodigo = 1;
    }


    public Integer guardarPrendas(List<Prenda> prendas) {

        int codigoPrendas = siguienteCodigo++;

        this.prendasGuardadas.put(codigoPrendas, prendas);

        return codigoPrendas;
    }

    public void mostrarPrendas() {

        if (this.prendasGuardadas.isEmpty()) {
            System.out.println("Este guardaropa no tiene prendas guardadas");
        }
        else {
            System.out.println("Prendas en este guardaropa:");

            this.prendasGuardadas.forEach((codigo, prendas) -> {
                System.out.print("Codigo: " + codigo + " | ");
                System.out.print("Prendas: " + prendas);
                System.out.print("\n");
            });
        }
    }

    public List<Prenda> devolverPrendas(Integer codigo) {

        if (!this.prendasGuardadas.containsKey(codigo))
            throw new RuntimeException("No existe en el guardaropa un conjunto de prendas guardado con ese código");

        List<Prenda> prendasARetirar = this.prendasGuardadas.get(codigo);
        this.prendasGuardadas.remove(codigo);

        return prendasARetirar;
    }
}
