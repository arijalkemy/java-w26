import java.util.*;
import java.util.stream.Collectors;

public class Inscripciones {

    private static Set<Inscripcion> inscritos = new HashSet<>();
    private static int contador = 0;


    public static void inscribirParticipante(Participante participante, Categoria categoria) throws Exception {
        if(inscritos.stream().anyMatch(inscripcion -> inscripcion.getParticipante().equals(participante))){
            throw new Exception("El participante "+participante+" ya esta insctito");
        }
        contador ++;
        Inscripcion inscripcion = new Inscripcion(contador, categoria, participante);
        inscritos.add(inscripcion);

    }

    public static Set<Inscripcion> getInscriptosCategoria(Categoria categoria){
       return inscritos.stream()
               .filter(inscripcion -> inscripcion.getCategoria().equals(categoria))
               .collect(Collectors.toSet());
    }

    public static void desInscribir(Participante participante){
        Optional<Inscripcion> inscripcionOptional = inscritos.stream()
                .filter(inscripcion -> inscripcion.getParticipante().equals(participante))
                .findAny();
        if(inscripcionOptional.isEmpty()) {
            System.out.println("No se encontro el participante");
            return;
        }
        Inscripcion inscripcion = inscripcionOptional.get();
        inscritos.remove(inscripcion);
        Set<Inscripcion> inscriptosCategoria = getInscriptosCategoria(inscripcion.getCategoria());
        System.out.println("participante desInscrito");
        System.out.println("Lista de inscritos en la categoria " + inscripcion.getCategoria().getNombre() + ": " + inscriptosCategoria);

    }
}
