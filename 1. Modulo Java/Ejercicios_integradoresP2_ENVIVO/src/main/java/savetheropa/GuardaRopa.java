package savetheropa;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class GuardaRopa {
    private Map<Integer,List <Prenda>> diccionario = new HashMap<>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> listaPrenda) {
        int id = contador++;
        diccionario.put(id, listaPrenda);
        return id;
    }
    public void mostrarPrendas(){
        diccionario.forEach((id, prendas)->{
            System.out.println("Id: "+id);
            prendas.forEach(prenda-> System.out.println(prenda));
        });
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }
}
