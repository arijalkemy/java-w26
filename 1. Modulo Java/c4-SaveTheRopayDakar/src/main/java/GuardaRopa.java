import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa<T>{
    private HashMap<Integer, List<Prenda>> prendas;
    private Integer contador;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(contador, listaDePrenda);
        return contador++;
    }
    public void mostrarPrendas(){
        prendas.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v.toString()));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> resultado = new ArrayList<>();
        if (this.prendas.containsKey(numero)){
            return prendas.get(numero);
        }
        else{
            System.out.println("No se encontraron prendas con el numero ingresado");
        }
        return resultado;
    }

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public GuardaRopa<T> setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
        return this;
    }

    public Integer getContador() {
        return contador;
    }

    public GuardaRopa<T> setContador(Integer contador) {
        this.contador = contador;
        return this;
    }
}
