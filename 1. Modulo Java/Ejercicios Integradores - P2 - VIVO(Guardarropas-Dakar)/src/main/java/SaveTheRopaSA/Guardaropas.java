package SaveTheRopaSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropas {
    //Crear la clase GuardaRopa que contenga como atributos un diccionario (o MAP)
    // y un contador que se utilizará como identificador. Las claves del diccionario
    // serán de tipo entero y como valor una lista de prendas.

    private int contador;//identificador
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();

    public Guardaropas(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    //Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda),
    // en la Clase GuardaRopa, que recibe una lista de prendas y devuelve el número identificador
    //en donde quedaron asignadas las prendas, es decir la clave del diccionario en donde guardamos las mismas.

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador, listaDePrenda);
        return contador++;
    }

    //Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla
    //todas las prendas que quedan en el guardarropas junto con el número que les corresponde.

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()){
            System.out.println("Número: " + entry.getKey() + " Prendas: " + entry.getValue().toString());
        }
    }

    //Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa
    // que devuelve la lista de prendas que están guardadas bajo ese número.

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

    //
}
