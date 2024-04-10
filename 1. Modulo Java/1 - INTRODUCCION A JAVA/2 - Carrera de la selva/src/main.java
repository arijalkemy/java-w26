import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class main {
    public static void main(String[] args) {

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        ArrayList<Participante> participantes = new ArrayList<>();


        Categoria circuitoChico = new CircuitoChico(1);
        Categoria circuitoMedio = new CircuitoMedio(2);
        Categoria circuitoAvanzado = new CircuitoAvanzado(3);

        Participante participante1 = new Participante(124, 42427909, "Lucas",
                "Martinez", 23, "+541133755923",
                "+541133755923", "O+");

        Participante participante2 = new Participante(953, 42427919, "Matias",
                "Perez", 15, "+54113373i9923",
                "+541133734323", "O+");

        Participante participante3 = new Participante(325, 42427942, "Nahuel",
                "Sequeira", 48, "+541133765523",
                "+541133755241", "O+");

        Participante participante4 = new Participante(435, 42427958, "Fernando",
                "Palomo", 29, "+541133754923",
                "+541133754221", "AB+");

        // Inscribiendo participantes
        try{
            inscripciones.add(new Inscripcion(282, "Inscripcion circuito chico", participante1, circuitoChico));
            inscripciones.add(new Inscripcion(29141, "Inscripcion circuito medio", participante3, circuitoMedio));
            inscripciones.add(new Inscripcion(9393, "Inscripcion circuito avanzado", participante2, circuitoAvanzado));
            inscripciones.add(new Inscripcion(8477, "Inscripcion circuito avanzado", participante4, circuitoAvanzado));

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Inscriptos\n");
        for (Inscripcion inscripcion : inscripciones){
            String datosParticipante = inscripcion.getParticipante().toString();
            System.out.println(inscripcion.getCategoria().getNombre() + " - " + datosParticipante);
        }

        System.out.println("\nUn partcipante se esta por desinscribir\n");

        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante().getDni() == 42427909);
        System.out.println("Inscriptos\n");
        for (Inscripcion inscripcion : inscripciones){
            String datosParticipante = inscripcion.getParticipante().toString();
            System.out.println(inscripcion.getCategoria().getNombre() + " - " + datosParticipante);
        }

        double totalCircuitoChico = 0;
        double totalCircuitoMedio = 0;
        double totalCircuitoAvanzado = 0;
        double totalCarrera = 0;

        for (Inscripcion inscripcion : inscripciones){
            switch (inscripcion.getCategoria().getNombre()){
                case "CircuitoChico":
                    totalCircuitoChico += inscripcion.getMontoAPagar();
                    break;
                case "CircuitoMedio":
                    totalCircuitoMedio += inscripcion.getMontoAPagar();
                    break;
                case "CircuitoAvanzado":
                    totalCircuitoAvanzado += inscripcion.getMontoAPagar();
                    break;
            }
        }
        totalCarrera = totalCircuitoChico + totalCircuitoMedio + totalCircuitoAvanzado;
        System.out.println("Lo recaudado por circuito chico fue: " + totalCircuitoChico);
        System.out.println("Lo recaudado por circuito medio fue: " + totalCircuitoMedio);
        System.out.println("Lo recaudado por circuito avanzado fue: " + totalCircuitoAvanzado);
        System.out.println("Lo recaudado por la carrera fue: " + totalCarrera);
    }
}
