
public class LibroMain {
    public static void main(String[] args){
        Libro libro = new Libro("Harry Potter","J.K.Rowling",20);
        System.out.print(libro.mostrarLibro());
        System.out.print("\nLa cantidad de ejemplares es:"+libro.cantidadDeEjemplares());
    }
}
