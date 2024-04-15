import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Save the ropa
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Nike", "Air Force 1");
        Prenda prenda2 = new Prenda("Adidas", "Superstar");
        Prenda prenda3 = new Prenda("Puma", "Suede");

        Prenda prenda4 = new Prenda("Nike", "Air Force 1");
        Prenda prenda5 = new Prenda("Adidas", "Superstar");
        Prenda prenda6 = new Prenda("Puma", "Suede");

        guardaRopa.guardarPrendas(List.of(prenda1, prenda2, prenda3));
        guardaRopa.guardarPrendas(List.of(prenda4, prenda5, prenda6));

        System.out.println("las prendas de 0 son: \n"+guardaRopa.devolverPrendas(0));

        guardaRopa.mostrarPrendas();

        //Dakar
        Vehiculo auto1 =  new Auto(80, 10, 30, "ABC123");
        Vehiculo moto1 = new Moto(80, 10, 30, "DEF456");
    }
}
