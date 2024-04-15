import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    /**
     * Clase que almacena, muestra y devuelve prendas.
     *
     */
    private static int contador = 0;
    private int id;
    private List<Prenda> listaPrendas;
    private static Map<Integer, List> dictGuardarropa = new HashMap<>();

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        this.id = ++contador;
        this.listaPrendas = listaPrendas;
        dictGuardarropa.put(id, listaPrendas);
        System.out.println("Se guardaron las prendas exitosamente. Tu codigo de retiro es: " + id);
        return id;
    }

    public void mostrarPrendas(){
        /**
         * Recorre el diccionario y muestra por pantalla el contenido del guardarropa
         */
        if (dictGuardarropa.isEmpty()){
            System.out.println("El guardarropas está vacío.");
        }else {
            dictGuardarropa.entrySet()
                    .stream()
                    .forEach(value -> {
                        int clave = value.getKey();
                        List<Prenda> prendas = value.getValue();
                        System.out.println("ID: " + clave);
                        System.out.println("Prendas: ");
                        prendas.forEach(prenda -> System.out.println(prenda.toString()));
                    });
        }
    }

    public List<Prenda> devolverPrendas(int numeroID){
        /**
         * Devuelve la lista de objetos Prenda almacenada y elimina las mismas del guardarropa (map)
         */
        List<Prenda> prendasDevolver = dictGuardarropa.get(numeroID);
        dictGuardarropa.remove(numeroID);
        System.out.println("Se devuelven las prendas correspondientes al ID: "+ numeroID);
        return prendasDevolver;
    }

}
