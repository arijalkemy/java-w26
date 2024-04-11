import java.util.*;

public class Main {

    public static void main(String[] args) {
        //instanciamos la clase CarreraDeLaSelva y los HashMap usados para representar las categorias y los participantes
        CarreraDeLaSelva carreraDeLaSelva = new CarreraDeLaSelva();
        Map<Integer, String> categorias = new HashMap<>();
        Map<Integer, Map<String, Object>> participantes = new HashMap<>();

        // a.)Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        categorias.put(1, "Circuito chico: 2 km por selva y arroyos.");
        categorias.put(2, "Circuito medio: 5 km por selva, arroyos y barro.");
        categorias.put(3, "Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");

        // b.) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
        carreraDeLaSelva.inscribirParticipante(1, "Edwin", "Guayacan", 21, 123, "123456789", "911", "O+", participantes);


        // c.) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        carreraDeLaSelva.inscribirParticipante(2, "Pepito", "Gomez", 22, 1234, "23456789", "911", "O+", participantes);
        carreraDeLaSelva.inscribirParticipante(3, "Lucas", "Silva", 31, 12345, "3456789", "911", "O+", participantes);
        carreraDeLaSelva.inscribirParticipante(2, "Pedro", "Lopez", 15, 123456, "456789", "911", "O+", participantes);
        carreraDeLaSelva.inscribirParticipante(1, "Luis", "Suarez", 16, 1234567, "6789", "911", "O+", participantes);


        // d.) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        carreraDeLaSelva.mostrarInscritosPorCategoria(2, categorias, participantes);

        // e.) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        carreraDeLaSelva.desinscribirParticipante(2, participantes);
        participantes.forEach((key, value) -> System.out.println(key + " : " + value));

        // f.) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        carreraDeLaSelva.calcularTotalRecaudado(categorias, participantes);
    }


}
