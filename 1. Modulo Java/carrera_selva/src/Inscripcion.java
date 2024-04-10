import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    int id = 0;
    Set<Participante> inscriptos = new HashSet<>();
    public Inscripcion() {}

    public void inscribirParticipante(Participante participante, Categoria categoria){
        boolean inscripcionExitosa = Categoria.inscribirParticipante(participante, categoria);
        if(inscripcionExitosa){
            inscriptos.add(participante);
            id++;
            participante.setId(id);
        }
    }

    public void mostrarInscripcionesPorCategoria(Categoria categoria){
        String participantesCategoria = "La categoria " + categoria.getNombre() + " tiene los siguientes participantes \n";
        for(Participante participante : inscriptos){
            if(participante.getCategoria().equals(categoria)) {
                participantesCategoria += participante.toString();
            }
        }
        System.out.println(participantesCategoria);
    }

    public void desinscribirParticipante(Participante participante){
        inscriptos.remove(participante);
        mostrarInscripcionesPorCategoria(participante.getCategoria());
    }

    public void imprimirMontos(){
        Double montoCircuitoChico = 0.0;
        Double montoCircuitoMediano = 0.0;
        Double montoCircuitoAvanzado = 0.0;

        for(Participante participante : inscriptos){
            switch(participante.getCategoria()){
                case CIRCUITO_CHICO:
                    montoCircuitoChico += Categoria.getPrecio(participante);
                    break;
                    case CIRCUITO_MEDIANO:
                        montoCircuitoMediano += Categoria.getPrecio(participante);
                        break;
                case CIRCUITO_AVANZADO:
                    montoCircuitoAvanzado += Categoria.getPrecio(participante);
                    break;
            }
        }

        System.out.println("el monto total del circuito chico es: " + montoCircuitoChico);
        System.out.println("el monto total del circuito mediano es: " + montoCircuitoMediano);
        System.out.println("el monto total del circuito avanzado es: " + montoCircuitoAvanzado);
        System.out.println("el monto total recaudado es: " +(montoCircuitoChico+montoCircuitoMediano+montoCircuitoAvanzado));

    }
}
