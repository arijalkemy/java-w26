import java.util.Arrays;

public class Main
    {
        public static void main(String[] args) {
            Curriculum cv = new Curriculum(new Persona("Pepe", "Perez", 30 ), Arrays.asList("c++", "java", "c#"));
            cv.imprimir();

            System.out.println("--------");

            LibrosPDF harrypotter = new LibrosPDF(4000, "JK Rowling", "Harry Potter y la piedra filosofal", "Fantasia");
            harrypotter.imprimir();

            System.out.println("---------");

            Informes info = new Informes("Hola esto es un texto de relleno",1,"Emiliano","Jorge");
            info.imprimir();
        }
    }

