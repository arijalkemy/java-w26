import Model.archivos.Curriculum;
import Model.archivos.Informe;
import Model.archivos.PDF;
import Model.impresora.Impresora;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PDF pdf = new PDF("Viktor Frankl", "El hombre en busca de sentido",
                "Autobiografia", 260);

        Informe informe = new Informe(30,30,"Juan","Jose");

        Curriculum curriculum = new Curriculum("Nacho","Ruiz Diaz",
                "44080739",  Arrays.asList("Emprendedor", "Carismatico"));

        Impresora.imprimir(pdf);
        System.out.println();
        System.out.println();
        Impresora.imprimir(informe);
        System.out.println();
        System.out.println();
        Impresora.imprimir(curriculum);


    }
}
