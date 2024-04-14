import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 25, "123456789", "987654321", "O+");
        Participante participante2 = new Participante(2, "87654321", "María", "González", 17, "987654321", "123456789", "A-");
        Participante participante3 = new Participante(3, "13579246", "Pedro", "Rodriguez", 32, "456789123", "456123789", "AB+");

        inscribirParticipante(participante1, circuitoChico);
        inscribirParticipante(participante2, circuitoChico);
        inscribirParticipante(participante3, circuitoMedio);

        inscribirParticipanteAleatorio(circuitoChico);
        inscribirParticipanteAleatorio(circuitoMedio);
        inscribirParticipanteAleatorio(circuitoAvanzado);

        mostrarInscriptos(circuitoMedio);

        desinscribirParticipante(participante2, circuitoChico);

        mostrarInscriptos(circuitoChico);

        calcularMontosRecaudados(circuitoChico, circuitoMedio, circuitoAvanzado);
    }

    public static void inscribirParticipante(Participante participante, Categoria categoria) {
        categoria.inscribirParticipante(participante);
        System.out.println("Participante " + participante.getNombre() + " inscrito en " + categoria.getNombre() + ". Monto a abonar: $" + categoria.calcularMonto(participante.getEdad()));
    }

    public static void inscribirParticipanteAleatorio(Categoria categoria) {
        Participante participanteAleatorio = generarParticipanteAleatorio();
        inscribirParticipante(participanteAleatorio, categoria);
    }

    public static Participante generarParticipanteAleatorio() {
        return new Participante(0, "00000000", "Participante", "Aleatorio", 20, "000000000", "000000000", "O-");
    }

    public static void mostrarInscriptos(Categoria categoria) {
        System.out.println("Inscriptos en la categoría " + categoria.getNombre() + ":");
        List<Participante> inscriptos = categoria.getInscriptos();
        for (Participante participante : inscriptos) {
            System.out.println("Número de inscripción: " + participante.getNumeroInscripcion() + ", Nombre: " + participante.getNombre() + ", Edad: " + participante.getEdad());
        }
    }

    public static void desinscribirParticipante(Participante participante, Categoria categoria) {
        categoria.desinscribirParticipante(participante);
        System.out.println("Participante " + participante.getNombre() + " desinscrito de " + categoria.getNombre());
    }

    public static void calcularMontosRecaudados(Categoria... categorias) {
        double totalGeneral = 0;
        for (Categoria categoria : categorias) {
            double totalCategoria = categoria.calcularTotalRecaudado();
            totalGeneral += totalCategoria;
            System.out.println("Monto total recaudado en la categoría " + categoria.getNombre() + ": $" + totalCategoria);
        }
        System.out.println("Monto total recaudado en toda la carrera: $" + totalGeneral);
    }
}
