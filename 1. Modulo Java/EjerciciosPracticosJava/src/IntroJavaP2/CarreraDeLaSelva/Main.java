package IntroJavaP2.CarreraDeLaSelva;
import java.util.*;

public class Main {
    private static final Map<String, Map<String, List<String>>> categorias = new HashMap<>(); //categoria -> participantes -> info participante
    private static final Map<String, List<String>> infoCategorias = new HashMap<String, List<String>>();

    // a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
    private static final Map<String, List<String>> participantesCircuitoChico = new HashMap<>();
    private static final Map<String, List<String>> participantesCircuitoMedio = new HashMap<>();
    private static final Map<String, List<String>> participantesCircuitoAvanzado = new HashMap<>();

    public static void main(String[] args) {
        inscribirParticipantes();
        inicializarInfoCategorias();
        mostrarIntegrantesCategoria("Circuito chico");
    }

    // b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
    public static void inscribirParticipantes() {
        List<String> infoParticipante1 = Arrays.asList("tomas", "ledesma", "22", "11202020", "911", "O+");
        List<String> infoParticipante2 = Arrays.asList("juan", "perez", "25", "12202020", "922", "A-");

        participantesCircuitoChico.put("202020", infoParticipante1);
        participantesCircuitoChico.put("303030", infoParticipante2);
        categorias.put("Circuito chico", participantesCircuitoChico);

    }

    public static void inicializarInfoCategorias() {
        List<String> infoCircuitoChico = Arrays.asList("1", "2 km por selva y arroyos.");
        infoCategorias.put("Circuito chico", infoCircuitoChico);

        List<String> infoCircuitoMedio = Arrays.asList("2", "5 km por selva, arroyos y barro.");
        infoCategorias.put("Circuito Medio", infoCircuitoMedio);

        List<String> infoCircuitoAvanzado = Arrays.asList("3", "10 km por selva, arroyos, barro y escalada de piedra.");
        infoCategorias.put("Circuito Avanzado", infoCircuitoAvanzado);

    }

    //d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
    public static void mostrarIntegrantesCategoria(String categoria) {
        System.out.println("Integrantes de la categoría " + categoria + ":");
        Map<String, List<String>> participantesCategoria = categorias.get(categoria);

        if (participantesCategoria != null) {
            for (Map.Entry<String, List<String>> entry : participantesCategoria.entrySet()) {
                String dni = entry.getKey();
                List<String> infoParticipante = entry.getValue();
                System.out.println("DNI: " + dni);
                System.out.println("Nombre: " + infoParticipante.get(0));
                System.out.println("Apellido: " + infoParticipante.get(1));
                System.out.println("Edad: " + infoParticipante.get(2));
                System.out.println("Fecha de nacimiento: " + infoParticipante.get(3));
                System.out.println("Teléfono: " + infoParticipante.get(4));
                System.out.println("Grupo sanguíneo: " + infoParticipante.get(5));
                System.out.println();
            }
        } else {
            System.out.println("No hay inscritos en la categoría " + categoria);
        }
    }
}