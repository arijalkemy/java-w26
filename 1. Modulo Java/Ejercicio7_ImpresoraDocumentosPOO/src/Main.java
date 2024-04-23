import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creacion y cargue de los distintos tipos de documentos
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Ponchar cables");
        habilidades.add("Arreglar cosas");
        habilidades.add("Circuitos");
        Curriculum curriculum = new Curriculum("Pedro Ortiz", "123123124", "Ing Eléctrico", habilidades);
        Libro libro = new Libro("J. K. Rowling", "Harry Potter Azkaban", "Novela Fantasia", 659);
        Informe informe = new Informe("Ing Johan Munoz", "Ing Miguel Guzman", "texto Random de informe", 129);

        //Uso del metodo imprimir manteniendo la misma firma del metodo y siendo especificado en cada caso
        System.out.println("Tipo - Curriculum");
        System.out.println("------------------------------");
        curriculum.imprimir();
        System.out.println("------------------------------");
        System.out.println("Tipo - Libro en PDF");
        System.out.println("------------------------------");
        libro.imprimir();
        System.out.println("------------------------------");
        System.out.println("Tipo - Informes");
        System.out.println("------------------------------");
        informe.imprimir();
    }
}