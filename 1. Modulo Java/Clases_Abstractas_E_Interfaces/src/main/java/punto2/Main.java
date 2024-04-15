package punto2;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* List.off para introducir las habilidades en la lista*/
        Curriculum cv = new Curriculum("Jane Doe", "jane@example.com", List.of("Liderazgo", "Java", "Git"));
        LibrosPDF libro = new LibrosPDF(300, "Gabriel García Márquez", "Cien Años de Soledad", "Realismo mágico");
        Informe informe = new Informe(10, 25, "John Doe", "Jane Roe");
        /*Llamar metodo estático de la interfaz para cada objeto*/
        Imprimible.imprimir(cv);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}
