
package com.meli;
import java.util.*;

/**
 * La clase GuardarRopa se encarga de almacenar prendas de ropa en un mapa.
 * Cada conjunto de prendas se almacena con una clave única.
 */
public class GuardarRopa {
    /**
     * Mapa para almacenar las prendas de ropa. La clave es un entero único y el valor es una lista de prendas.
     */
    Map<Integer , List<Prenda>> guardarRopa = new HashMap<>();

    /**
     * Este método se encarga de guardar un conjunto de prendas en el mapa.
     * @param listaDePrenda La lista de prendas a guardar.
     * @return El identificador único del conjunto de prendas guardado, o null si la lista de prendas está vacía.
     */
    public Integer guardarPrendas(List<Prenda> listaDePrenda)
    {
        if (!listaDePrenda.isEmpty()) {
            int pos = guardarRopa.size() + 1;
            listaDePrenda.forEach(prenda -> guardarRopa.put(pos, listaDePrenda));
            return pos;
        }

        return null;
    }

    /**
     * Este método imprime todas las prendas almacenadas en el mapa.
     */
    public void mostrarPrendas() {
        guardarRopa.forEach((key, value) -> {
            System.out.println("Clave: " + key);
            System.out.println(value.toString());
        });
    }

    /**
     * Este método se encarga de devolver un conjunto de prendas y eliminarlo del mapa.
     * @param numero El identificador único del conjunto de prendas a devolver.
     * @return La lista de prendas correspondiente al identificador proporcionado, o una lista vacía si no se encontró ninguna prenda.
     */
    public List<Prenda> devolverPrendas(Integer numero)
    {
        List<Prenda> prendas = guardarRopa.remove(numero);
        return prendas != null ? prendas : new ArrayList<>();
    }
}
