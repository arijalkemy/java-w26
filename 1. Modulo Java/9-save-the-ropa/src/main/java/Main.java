import savetheropa.GuardaRopa;
import savetheropa.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creo dos prendas
        Prenda bufanda = new Prenda("H&M" , "Bufanda fachera");
        Prenda jean = new Prenda("Levis", "Jean negro");
        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(bufanda);
        listaDePrendas.add(jean);

        // Las guardo
        GuardaRopa guardarropa = new GuardaRopa();
        guardarropa.guardarPrendas(listaDePrendas);

        // Creo dos mas
        Prenda buzo = new Prenda("GAP" , "Buzo comodo");
        Prenda campera = new Prenda("Columbia", "Campera azul");
        List<Prenda> nuevaListaDePrendas = new ArrayList<>();
        nuevaListaDePrendas.add(buzo);
        nuevaListaDePrendas.add(campera);

        // Las guardo
        guardarropa.guardarPrendas(nuevaListaDePrendas);

        // Muestro la informacion
        guardarropa.mostrarPrendas();

        // Obtengo la informacion
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor ingrese la clave de la lista que desea recuperar: ");
        int clave = scanner.nextInt();

        List<Prenda> listaDePrendasDevueltas = guardarropa.devolverPrendas(clave);
        System.out.println("Prendas devueltas:");
        System.out.println(listaDePrendasDevueltas);
        System.out.println("Así quedó el guardarropas:");
        guardarropa.mostrarPrendas();
    }
}
