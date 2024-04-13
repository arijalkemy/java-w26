import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionarioPrendas = new HashMap<>();
    private int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador += 1;
        diccionarioPrendas.put(contador, listaDePrenda);
        return contador;

    }

    public void mostrarPrendas(){
        diccionarioPrendas.entrySet().stream().forEach(entry -> System.out.println("el identificador es: " + entry.getKey()
                + "las prendas son" + entry.getValue() ));

    }

    public List<Prenda> devolverPrendas(Integer numero){
       return  diccionarioPrendas.get(numero);
    }

}

