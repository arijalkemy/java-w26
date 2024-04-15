import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println(guardaRopa.guardarPrendas(List.of(
                new Camisa("X", "Y"),
                new Camisa("A", "B"),
                new Pantalon("C", "D")
        )));
        System.out.println(guardaRopa.guardarPrendas(List.of(
                new Camisa("E", "F"),
                new Pantalon("G", "H"),
                new Pantalon("I", "J")
        )));

        guardaRopa.mostrarPrendas();

        System.out.println("index 1");
        guardaRopa.devolverPrendas(1).forEach(System.out::println);
    }
}
