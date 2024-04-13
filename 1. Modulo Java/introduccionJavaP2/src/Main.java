import java.util.Random;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Categoria circuitoChico = new Categoria("2k", "chico", "selva y arroyos");
        Categoria circuitoMedio = new Categoria("5k", "medio", "selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria("10k", "avanzado", "selva, arroyos, barro y escalada");

        Participante participante1 = new Participante(1, "Monica",
                "Lopez", "1053", 21,"31223456", "2345678","o+");
        Participante participante2 = new Participante(2, "Fernando",
                "Arias", "1055", 28,"31223676", "2345678","o+");

        Participante participante3 = new Participante(3, "Maria",
                "Tamayo", "1036", 32,"323456", "283838398","a+");

        Participante participante4 = new Participante(4, "sara",
                "Tamayo", "12345", 15,"323456", "283838398","a+");

        try {
            Inscripciones.inscribirParticipante(participante1, circuitoChico);
            Inscripciones.inscribirParticipante(participante2, circuitoMedio);
            Inscripciones.inscribirParticipante(participante3, circuitoAvanzado);
            Inscripciones.inscribirParticipante(participante4, circuitoAvanzado);
        } catch (Exception e) {
            System.err.println( e.getMessage());
        }
        Set<Inscripcion> inscritosCircuitoChico = Inscripciones.getInscriptosCategoria(circuitoChico);
        Set<Inscripcion> inscritosCircuitoMedio = Inscripciones.getInscriptosCategoria(circuitoMedio);
        Set<Inscripcion> inscritosCircuitoAvanzado = Inscripciones.getInscriptosCategoria(circuitoAvanzado);
        System.out.println("Inscitos Categoria Chico " + inscritosCircuitoChico);
        System.out.println("Inscritos Categoria Medio " + inscritosCircuitoMedio);
        System.out.println("Inscritos Categoria Avanzado " + inscritosCircuitoAvanzado);

        Inscripciones.desInscribir(participante1);

        double totalChico = inscritosCircuitoChico.stream()
                .map(inscripcion -> inscripcion.getMonto())
                .reduce((a,b) -> a+b)
                .orElse(0D);

        double totalMedio = inscritosCircuitoMedio.stream()
                .map(inscripcion -> inscripcion.getMonto())
                .reduce((a,b) -> a+b)
                .orElse(0D);

        double totalAvanzado = inscritosCircuitoAvanzado.stream()
                .map(inscripcion -> inscripcion.getMonto())
                .reduce((a,b) -> a+b)
                .orElse(0D);

        double totalCarrera = totalChico + totalMedio + totalAvanzado;

        System.out.println("el total recaudado del circuito chico fue:  " + totalChico);
        System.out.println("el total recaudado del circuito chico fue:  " + totalMedio);
        System.out.println("el total recaudado del circuito avanzado fue:  " + totalAvanzado);
        System.out.println("el total recaudado en la carrera fue :  " + totalCarrera);
    }

}
