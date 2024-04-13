import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map <Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa (){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> identificador) {
        this.diccionario = identificador;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public int getContador() {
        return contador;
    }

    public Map<Integer, List<Prenda>> getIdentificador() {
        return diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(++contador,listaDePrenda);
        return contador;
    }
    public void mostrarPrendas(){
        for (Map.Entry<Integer,List<Prenda>> entry: diccionario.entrySet()){
            System.out.println("Numero identificador: " + entry.getKey());
            List<Prenda> prendas = entry.getValue();
            for (Prenda prenda : prendas){
                System.out.println("Marca: " + prenda.getMarca() + " - Modelo: " +prenda.getModelo());
            }
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }
}
