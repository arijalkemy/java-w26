package EjerciciosIntegradores.P2.SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zapatilla zapatillas = new Zapatilla("Altas", "Llantas");
        Campera campera = new Campera("Campera", "Buenarda");

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>(){
            {
                add(zapatillas);
                add(campera);
            }
        };

        List<Prenda> prendas2 = new ArrayList<>(){
            {
                add(zapatillas);
            }
        };

        int locker = guardaRopa.guardarPrendas(prendas);

        guardaRopa.guardarPrendas(prendas2);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevuelvo = guardaRopa.devolverPrendas(locker);

        System.out.println("Prendas guardadas: ");
        for (Prenda prenda : prendasDevuelvo) {
            System.out.println(prenda);
        }
    }
}