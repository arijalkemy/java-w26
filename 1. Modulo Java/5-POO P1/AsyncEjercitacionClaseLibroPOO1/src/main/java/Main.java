public class Main {
    public static void main(String[] args) {
        Libro primerLibro = new Libro("Viaje al centro de la tierra", "Julio Verne", 10);
        System.out.println(primerLibro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este libro es de : " + primerLibro.cantidadEjemplares());
    }
}
