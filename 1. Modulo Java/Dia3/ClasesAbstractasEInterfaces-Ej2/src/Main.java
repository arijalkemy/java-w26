import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear objetos de cada tipo de documento
        Curriculum curriculum = new Curriculum("Juan Perez", 30, Arrays.asList("Java", "Python", "SQL"));
        curriculum.setNombre("Juan Perez");
        curriculum.setEdad(30);
        curriculum.getHabilidades(Arrays.asList("Java", "Python", "SQL"));

        LibroPDF libroPDF = new LibroPDF();
        libroPDF.setTitulo("El nombre del viento");
        libroPDF.setAutor("Patrick Rothfuss");
        libroPDF.setGenero("Fantasía");
        libroPDF.setCantidadPaginas(672);

        Informe informe = new Informe();
        informe.setAutor("Ana García");
        informe.setRevisor("Carlos Martinez");
        informe.setCantidadPaginas(10);
        informe.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");

        Imprimible.imprimirDocumento(curriculum);
        System.out.println("");
        Imprimible.imprimirDocumento(libroPDF);
        System.out.println("");
        Imprimible.imprimirDocumento(informe);
    }
}