import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {

    private int contador;
    private Map<Integer, List> diccionario;

    public Guardarropa() {
        diccionario = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        diccionario.put(contador,listaPrendas);
        Integer posicion = contador;
        this.contador++;
        return posicion;
    }
    public void mostrarPrendas() {
        for (Map.Entry<Integer, List> entry : diccionario.entrySet()) {
            System.out.println("Numero asignado en el guardarropa: " + entry.getKey());
            System.out.println("Prendas guardadas en este ticket...");
            List<Prenda> prendas = entry.getValue();
            for (Prenda prenda : prendas) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
            System.out.println("----");
        }
    }
}
