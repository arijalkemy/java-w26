package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.prendas = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        Integer hashCode = listaDePrendas.hashCode();
        prendas.put(hashCode, listaDePrendas);
        return hashCode;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet() ) {
            Integer clave = entry.getKey();
            List<Prenda> valorLista = entry.getValue();
            System.out.println("Prendas guardadas en la clave " + clave + ':' + '\n' + valorLista);
        }
    }

    public List<Prenda> devolverPrendas(Integer clave) {
        List<Prenda> listaDePrendas = this.prendas.get(clave);
        this.prendas.remove(clave);
        return listaDePrendas;
    }
}
