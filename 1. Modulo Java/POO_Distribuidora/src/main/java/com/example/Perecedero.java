package com.example;

import java.util.Map;

public class Perecedero extends Producto{
    /*
     * Esta clase debe heredar de Producto y sobreescribir el método calcular(),
     * el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad
     * de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
     */

    
    private final Map<Integer,Double> DIAS_CADUCACION = Map.of(
        1,0.25,
        2,1/3D,
        3,0.5
    );

    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return this.diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }


    @Override
    public String toString() {
        return super.toString() + "{" +
            " diasPorCaducar='" + getDiasPorCaducar() + "'" +
            "}";
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = precio * cantidadDeProductos * DIAS_CADUCACION.getOrDefault(diasPorCaducar,1.0);
        return resultado;
    }
}
