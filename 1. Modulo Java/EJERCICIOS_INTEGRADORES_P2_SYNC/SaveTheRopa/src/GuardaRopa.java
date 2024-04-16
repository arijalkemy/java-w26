import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private Integer contador;

    private Map<Integer, List<Prenda> > guardaRopa;

    public GuardaRopa()
    {
        this.contador = Integer.valueOf(0);
        this.guardaRopa = new HashMap<>();
    }

    @Override
    public String toString() {
        return "GuardaRopa [contador=" + contador + ", guardaRopa=" + guardaRopa + "]";
    }

    public Integer guardarRopa(List<Prenda> guardaRopa)
    {
        Integer key = contador;
        this.guardaRopa.put(key, guardaRopa);
        contador++;
        return key;
    }

    public void mostrarPrendas()
    {
        for (var iterable_element : guardaRopa.entrySet()) {
            System.out.println(iterable_element);
        }
    }

    public List<Prenda> devolverRopa(Integer id_ropero)
    {
        return guardaRopa.remove(id_ropero);
    }


    public Map<Integer, List<Prenda>> getPrendas() {
        return guardaRopa;
    }

    public void setPrendas(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    
    
}
