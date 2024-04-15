import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveTheRopa {
    public static void main(String[] args){

        //se instancia GuardaRopa
        GuardaRopa guardaRopa = new GuardaRopa();


        //se hace ingreso manual para testear funcionamiento.

        List<Prenda> prendasAGuardar = new ArrayList<>(Arrays.asList(
                new Prenda("Gucci", "Bolso"),
                new Prenda("Adidas", "Buzo")));



        int codigoRetiro = guardaRopa.guardarPrendas(prendasAGuardar);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigoRetiro);

        guardaRopa.mostrarPrendas();

    }
}
