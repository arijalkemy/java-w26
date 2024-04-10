import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Categoria circuitoChico = Categoria.CIRCUITO_CHICO;
        Categoria circuitoMediano = Categoria.CIRCUITO_MEDIANO;
        Categoria circuitoAvanzado = Categoria.CIRCUITO_AVANZADO;
        Categoria[] categorias = {circuitoChico, circuitoMediano, circuitoAvanzado};
        Inscripcion inscripcion = new Inscripcion();

        Participante primerParticipante = new Participante(
                "Facundo", "Lopez", 20, 33333333, "112222333",
                "11444444444", "A+"
        );

        inscripcion.inscribirParticipante(primerParticipante,circuitoChico);

        for (int i = 0; i < 9; i++) {
            Participante participante = new Participante(
                    "participante" + i,
                    "apellido" + i,
                    16 + i,
                    34444444 + i,
                    "112233445" + i,
                    "112223333" + i,
                    "B+"
            );
            if(i<3){
                inscripcion.inscribirParticipante(participante, categorias[i]);
            }else{
                Random random = new Random();
                inscripcion.inscribirParticipante(participante, categorias[random.nextInt(3)]);
            }
        }

        inscripcion.mostrarInscripcionesPorCategoria(Categoria.CIRCUITO_CHICO);

        inscripcion.desinscribirParticipante(primerParticipante);

        inscripcion.imprimirMontos();
    }
}