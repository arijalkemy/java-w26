import java.util.HashMap;
import java.util.List;

public class Wardrobe {

    private HashMap<Integer, List<Clothing>> clothesList;
    private static int contador;

    public Wardrobe() {
        this.clothesList = new HashMap<Integer, List<Clothing>>();
        contador = 0;
    }

    public HashMap<Integer, List<Clothing>> getListaPrendas() {
        return clothesList;
    }

    public void setClothesList(HashMap<Integer, List<Clothing>> listaPrendas) {
        this.clothesList = listaPrendas;
    }

    public int guardarPrendas(List<Clothing> listaPrendas) {
        this.clothesList.put(++contador, listaPrendas);
        return contador;
    }

    public void mostrarPendas() {
        clothesList.forEach((key, value) -> {
            System.out.print(key + "   ");
            System.out.println(value);
        });
    }

    public List<Clothing> devolverPrendas(Integer numero)
    {
        return clothesList.get(numero);
    }

}
