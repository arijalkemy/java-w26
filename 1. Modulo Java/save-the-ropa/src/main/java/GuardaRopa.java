import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private static Integer contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda)
    {
        this.prendas.put(++contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        this.prendas.entrySet().forEach( x ->{
                    System.out.println( x.getKey() + " ");
                    System.out.println(x.getValue());
        }
        );
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                '}';
    }
}
