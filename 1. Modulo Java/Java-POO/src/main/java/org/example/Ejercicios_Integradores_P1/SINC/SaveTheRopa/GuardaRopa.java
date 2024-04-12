package org.example.Ejercicios_Integradores_P1.SINC.SaveTheRopa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas = new HashMap<>();

    private int contador = 0;

    public int guardarPrendas(List<Prenda> listaDePrenda) {
        this.prendas.put(this.getContador(), listaDePrenda);
        this.setContador(this.getContador() + 1);
        return this.getContador();
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(int numero) {
        return prendas.get(numero);
    }
}
