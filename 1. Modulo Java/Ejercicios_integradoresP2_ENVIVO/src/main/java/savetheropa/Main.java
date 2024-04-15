package savetheropa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Seven seven","Camibuzo");
        Prenda prenda2 = new Prenda("Nike","Falda");

        Integer id = guardaRopa.guardarPrendas(Arrays.asList(prenda1,prenda2));
        System.out.println("Código identificador recibido: "+id);
        guardaRopa.mostrarPrendas();
        //Prendas guardadas
        List<Prenda> prendasGuardadas =guardaRopa.devolverPrendas(id);
        System.out.println("Prendas guardadas con el identificador "+id+" :");
        prendasGuardadas.forEach(System.out::println);
        //Devuolución
        System.out.println("Devolución: ");
        List<Prenda> prendasDevueltas =guardaRopa.devolverPrendas(id);
        if(prendasDevueltas != null){
            prendasDevueltas.forEach(prenda -> System.out.println("Devolviendo: "+prenda));
            guardaRopa.getDiccionario().remove(id);
            System.out.println("Prendas devueltas y retiradas del sistema");
        }else{
            System.out.println("No se encontraron prendas con el id");
        }
    }
}
