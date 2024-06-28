import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GuardaRopa miRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("levis", "falda");
        Prenda prenda2 = new Prenda("channel", "chaqueta");

       Integer identificador  = miRopa.guardarPrendas(List.of(prenda1, prenda2));
        List<Prenda> miListaRopa =  miRopa.devolverPrendas(identificador);
        miListaRopa.forEach(prenda -> System.out.println(prenda));
    }
}