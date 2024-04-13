import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Adidas","Camisa");
        Prenda prenda2 = new Prenda("Levis","Pantalon");
        Prenda prenda3 = new Prenda("Oster","Medias");


        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        listaPrendas.add(prenda3);

        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println("**** Punto 3 ****");
        Integer numeroIdentificador = guardaRopa.guardarPrendas(listaPrendas);
        System.out.println(numeroIdentificador);

        System.out.println("**** Punto 4 **** ");
        System.out.println("Prendas guardas: ");
        guardaRopa.mostrarPrendas();

        //System.out.println("Prendas asociasdas a su correspondiente identificador " + numeroIdentificador + " : ");
        //List<Prenda> prendasAsocidas = guardaRopa.getDiccionario().get(numeroIdentificador);
        //for (Prenda prenda : prendasAsocidas){
        //    System.out.println("Marca: " + prenda.getMarca() + " - Modelo: " + prenda.getModelo());
        //}
        System.out.println("**** Punto 5 ****");
        for (Prenda prenda : guardaRopa.devolverPrendas(1)){
            System.out.println("Marca: " + prenda.getMarca() + " - Modelo: " + prenda.getModelo());
        }
        System.out.println("Numero de identiciador: " + guardaRopa.devolverPrendas(1));
    }
}