package org.example;

import java.util.HashMap;
import java.util.Map;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        try {
            if (this.diasPorCaducar == 0) throw new IllegalArgumentException("Producto caducado");
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 4);
            map.put(2, 3);
            map.put(3, 2);
            double precio = super.calcular(cantidadDeProductos);
            if (map.containsKey(diasPorCaducar)) return precio / map.get(diasPorCaducar);
            return precio;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
