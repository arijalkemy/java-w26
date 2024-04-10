import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Inscripcion> listaInscriptos = new ArrayList<Inscripcion>();

        // Crear 3 objetos tipo categoria
        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.", 0);
        Categoria medio = new Categoria(1, "Circuito medio", "5 km por selva, arroyos y barro.", 0);
        Categoria avanzado = new Categoria(1, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 18);
    
        // Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar
        Participante participanteUno = new Participante(1, 40000000, "Lautaro", "Oleastro", 26, 215454545, 221544545, "0+");
        listaInscriptos.add(
            new Inscripcion(1, chico, participanteUno)
        );
    }

    
}

