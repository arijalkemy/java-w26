import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {

    private static int id = 0;

    private Map<Integer, List<Prenda>> listTickets = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listPrendas){
        id++;
        this.listTickets.put(id,listPrendas);
        return id;
    }

    public void mostrarPrendas(){
        listTickets.forEach((key,value) -> System.out.println("Clave:"+key+"\n"+"Prendas"+value.toString()+"\n"));
    }

    public List<Prenda> devolverPrendas(Integer id){

        return listTickets.get(id);
    }
}
