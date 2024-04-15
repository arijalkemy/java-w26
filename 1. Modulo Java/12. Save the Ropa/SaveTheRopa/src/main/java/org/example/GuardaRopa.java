package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;
    private Integer id = 0;

    public GuardaRopa() {

    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.id = this.id + 1;

        Map<Integer, List<Prenda>> prendasAGuardar = new HashMap<>();
        prendasAGuardar.put(this.id, listaDePrenda);

        this.prendas = prendasAGuardar;
        return this.id;

        /*
        for (Map.Entry<Integer, List<Prenda>> prenda : this.prendas.entrySet()) {
            if (prenda.getValue().equals(listaDePrenda)) {
                id = prenda.getKey();
                break;
            }
        }
        */

    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> prenda : this.prendas.entrySet()) {
            Integer idPrenda = prenda.getKey();
            List <Prenda> prendaEnGuardaRopa = prenda.getValue();

            System.out.println("--------------");
            System.out.println("Prendas con id: " + idPrenda);

            prendaEnGuardaRopa.stream().forEach(prendaGuardada -> System.out.println("Marca: " + prendaGuardada.getMarca() + " Modelo: " + prendaGuardada.getModelo()));

        }

    }

    public List<Prenda> devolverPrenda(Integer numero) {

        return this.prendas.get(numero);

    }
}
