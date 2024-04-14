package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(
                1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria categoria2 = new Categoria(
                2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoria3 = new Categoria(
                3, "Circuito avanzado", " 10 km por selva, arroyos, barro y " +
                "escalada en piedra.");

        Participante participante = new Participante(1234, 23456788, "Pepe",
                "Rodriguez", 55, 123456789, 123467, "A");
        Participante participante2 = new Participante(12345, 23456798, "Paula",
                "Rodriguez", 45, 123459989, 99999, "A");
        Participante participante3 = new Participante(1234, 23456788, "Hernan",
                "Rodriguez", 65, 240456789, 88888, "A");

        Carrera carrera = new Carrera();

        carrera.inscribirParticipante(participante,categoria1);
        carrera.inscribirParticipante(participante2,categoria2);
        carrera.inscribirParticipante(participante3,categoria3);

        carrera.agregarCategoria(categoria1,categoria2,categoria3);
        carrera.getParticipantes().forEach(System.out::println);

        System.out.println("Desinscribir participante");

        Participante participante4 = new Participante(5555, 555555, "Maria",
                "Rodriguez", 45, 2456789, 45678, "A");

        carrera.inscribirParticipante(participante4, categoria1);

        carrera.desinscribirParticipante(participante);

        carrera.mostrarInsriptos(categoria1);

        System.out.println("Total recaudado por la categoría " + categoria1.getNombre() + ": $" + carrera.calcularTotalPorCategoria(categoria1));
        System.out.println("Total recaudado por la categoría " + categoria2.getNombre() + ": $" + carrera.calcularTotalPorCategoria(categoria2));
        System.out.println("Total recaudado por la categoría " + categoria3.getNombre() + ": $" + carrera.calcularTotalPorCategoria(categoria3));
        System.out.println(carrera.calcularTotalCarrera());




    }
}
