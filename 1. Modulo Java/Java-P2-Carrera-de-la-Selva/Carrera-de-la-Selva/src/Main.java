import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Se crea un set para guardar las inscripciones
        Set<Inscripcion> listaDeInscripciones = new HashSet<>();

        // Instancio categorias
        Categoria circuitoChico = new Categoria("1", "Circuito chico",
                "2 km por selva y arroyos.", 1500, 1300);
        Categoria circuitoMedio = new Categoria("2", "Circuito medio",
                "5 km por selva, arroyos y barro.", 2300, 2000);
        Categoria circuitoAvanzado = new Categoria("3", "Circuito avanzado",
                "0 km por selva, arroyos, barro y escalada en piedra.", 2800, 0);

        // Instancio participantes
        Participante participanteUno = new Participante(1, 111, "Participante", "Uno",
                21, 111, 111, "0");
        Participante participanteDos = new Participante(2, 111, "Participante", "Dos",
                21, 111, 111, "0");
        Participante participanteTres = new Participante(3, 111, "Participante", "Tres",
                21, 111, 111, "0");

        // Instancio inscripciones y las agrego al set
        listaDeInscripciones.add(new Inscripcion(1, circuitoChico, participanteUno));
        listaDeInscripciones.add(new Inscripcion(2, circuitoMedio, participanteDos));
        listaDeInscripciones.add(new Inscripcion(3, circuitoAvanzado, participanteTres));

        // Muestro la inscripción del primer participante y el monto a pagar
        Inscripcion inscripcionUno = listaDeInscripciones.stream()
                .filter(inscripcion -> inscripcion.getParticipante().equals(participanteUno))
                .findFirst().orElse(null);

        if (inscripcionUno != null)
            System.out.println("Inscripcion participante: " + inscripcionUno.getParticipante().getApellido() + " monto a pagar: " + inscripcionUno.getMonto());

        // Obtiene listado de inscripciones de la categoria "Circuito chico"
        System.out.println("----- Inscripciones a circuito chico ------");
        filtrarCategoriaSegunNombre(listaDeInscripciones, "Circuito chico")
                .forEach(inscripcion -> {
                    System.out.println("Numero de inscripcion: " + inscripcion.getNumeroInscripcion());
                    System.out.println(inscripcion.getParticipante().toString());
                });
        System.out.println("---------------");

        // Desinscribo al participante uno
        listaDeInscripciones.remove(inscripcionUno);

        // Vuelvo a filtrar por circuito chico y muestro la lista resultante
        System.out.println("----- Inscripciones luego de remover un participante ------");
        filtrarCategoriaSegunNombre(listaDeInscripciones, "Circuito chico")
                .forEach(inscripcion -> {
                    System.out.println("Numero de inscripcion: " + inscripcion.getNumeroInscripcion());
                    System.out.println(inscripcion.getParticipante().toString());
                });
        System.out.println("---------------");
        //Calculo y muestro los montos para cada categoria
        System.out.println("Monto total circuito chico: " + calcularMontoSegunCategoria(listaDeInscripciones, "Circuito chico"));
        System.out.println("Monto total circuito medio: " + calcularMontoSegunCategoria(listaDeInscripciones, "Circuito medio"));
        System.out.println("Monto total circuito avanzado: " + calcularMontoSegunCategoria(listaDeInscripciones, "Circuito avanzado"));

        //Calculo y muestro el monto total
        System.out.println("Monto total: " + calcularMontoTotal(listaDeInscripciones));
    }

    // Método para filtrar categoria segun un nombre enviado por parametro
    private static Stream<Inscripcion> filtrarCategoriaSegunNombre(Set<Inscripcion> inscripciones, String nombreCategoria) {
        return inscripciones.stream()
                .filter(t -> t.getCategoria().getNombre().equals(nombreCategoria));
    }

    // Método para calcular el monto de una categoria enviada por parametro
    private static double calcularMontoSegunCategoria(Set<Inscripcion> inscripciones, String nombreCategoria){
        return filtrarCategoriaSegunNombre(inscripciones, nombreCategoria)
                .mapToDouble(Inscripcion::getMonto).sum();
    }

    // Método para calcular el monto total
    private static double calcularMontoTotal(Set<Inscripcion> inscripciones){
        return inscripciones.stream()
                .mapToDouble(Inscripcion::getMonto).sum();
    }
}