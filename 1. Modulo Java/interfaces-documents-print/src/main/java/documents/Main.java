package documents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Nombre completo", List.of("Habilidad 1", "Habilidad 2"));
        Informe informe = new Informe("Texto del informe", 14, "Blas", "bootcamp");
        Libro libro = new Libro(15, "Shakespeare", "Titulo", "Teatro");

        curriculum.imprimir();
        informe.imprimir();
        libro.imprimir();
    }
}
