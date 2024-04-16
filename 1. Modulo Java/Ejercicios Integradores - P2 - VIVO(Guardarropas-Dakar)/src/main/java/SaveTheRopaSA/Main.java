package SaveTheRopaSA;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
        // reciba el código y luego consulta por sus prendas guardadas.


        Guardaropas guardaropas = new Guardaropas(1);

        Prenda prenda1 = new Prenda("Nike", "Air Force 1");
        Prenda prenda2 = new Prenda("Adidas", "Superstar");

        guardaropas.guardarPrendas(List.of(prenda1, prenda2));

        guardaropas.mostrarPrendas();


    }

}
