import java.util.LinkedList;
import java.util.List;

import Documentos.Curriculmn;
import Documentos.Informes;
import Documentos.LibroPDF;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<String> habilidades = new LinkedList<>();

        Curriculmn c = new Curriculmn("Nilson", "Vargas", 22, habilidades);
        LibroPDF pdf = new LibroPDF(197, "Julio Verne", "La vuelta al mundo en 80 días.", "Ficción de aventuras");
        Informes informe = new Informes("Informe de Desempeño del Departamento de Ventas", 20, "Ana Rodríguez", "Carlos Gomez");


        Imprimible.imprimir(c);
        Imprimible.imprimir(pdf);
        Imprimible.imprimir(informe);
    }
}
