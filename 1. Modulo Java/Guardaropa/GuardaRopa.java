import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static Integer id = 0;
    Map<Integer, List<Prenda>> dic;

    public GuardaRopa() {
        dic = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        dic.put(++id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> i: dic.entrySet()){
            System.out.println(i.getKey() + " - " + i.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer id){
        return dic.get(id);
    }
}
