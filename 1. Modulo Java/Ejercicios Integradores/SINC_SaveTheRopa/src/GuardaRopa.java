import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static int identificador;
    private Map<Integer, List<Prenda>> prendasPorIdentificador;

    public GuardaRopa() {
        identificador = 0;
        prendasPorIdentificador = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        identificador ++;
        prendasPorIdentificador.put(identificador, listaDePrendas);
        return identificador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> item : prendasPorIdentificador.entrySet()) {
            int identificador = item.getKey();
            List<Prenda> listaPrendas = item.getValue();
            System.out.println("Identificador: " + identificador);
            System.out.println("Prendas incluidas: ");
            for (Prenda prenda : listaPrendas) {
                System.out.println(prenda.toString());
            }
        }
    }

    public List<Prenda> devolverPrendas (Integer numero){
        for (Map.Entry<Integer, List<Prenda>> listaPrendas : prendasPorIdentificador.entrySet()) {
            if (listaPrendas.getKey() == numero) {
                listaPrendas.getValue().stream().forEach(x -> System.out.println(x.toString()));
            }
        }
        return null;
    }
}
