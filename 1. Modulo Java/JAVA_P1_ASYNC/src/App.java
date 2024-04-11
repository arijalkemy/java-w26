import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro("La vuelta al mundo en 80 días.", "Julio Verne", 777);
        System.out.println(libro.mostrarLibro());
        System.out.println("Cantidad de libros: " + libro.cantidadDeEjemplares());

        try {
            FileInputStream fis = new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
