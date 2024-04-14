import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Inscripcion> listInscriptos = new ArrayList<>();

        Categoria circuitoChico = new Categoria("Circuito Chico","2 km por selva y arroyos.",1500.0, Optional.of(1300.0));
        Categoria circuitoMedio = new Categoria("Circuito Medio","5 km por selva, arroyos y barro.",2300.0, Optional.of(2000.0));
        Categoria circuitoAvanzado = new Categoria("Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra.",2800.0, Optional.empty());


        Participante participante1 = new Participante("39235557","Rodrigo","Arguello",27,351878889,"A+");
        Participante participante2 = new Participante("39935578","Juan","Gomez",25,351878333,"A+");
        Participante participante3 = new Participante("39935599","Joaquin","Perez",22,351878811,"A+");
        Participante participante4 = new Participante("399355588","Jose","Garcia",17,351878434,"A+");



        Inscripcion inscripcion1 = inscribir(circuitoChico, participante1);

        if(inscripcion1 != null) listInscriptos.add(inscripcion1);

        Inscripcion inscripcion2 = inscribir(circuitoMedio, participante2);

        if(inscripcion2 != null) listInscriptos.add(inscripcion2);

        Inscripcion inscripcion3 = inscribir(circuitoAvanzado, participante3);

        if(inscripcion3 != null) listInscriptos.add(inscripcion3);

        Inscripcion inscripcion4 = inscribir(circuitoAvanzado, participante4);

        if(inscripcion4 != null) listInscriptos.add(inscripcion4);

        Inscripcion inscripcion5 = inscribir(circuitoChico, participante3);

        if(inscripcion5 != null) listInscriptos.add(inscripcion5);

        String nombreFiltroCategoria = "Circuito Chico";

        List<Inscripcion> listInscriptosPorCategoria = getInscriptosPorCategoria(nombreFiltroCategoria,listInscriptos);

        System.out.println("Listado de participantes inscriptos a la categoria: "+nombreFiltroCategoria);

        listInscriptosPorCategoria.forEach(i -> {
            System.out.println("N° de inscripción: "+i.getId());
            System.out.println(i.getParticipante().toString());
        });

        Inscripcion inscripcionEliminar = listInscriptos.stream()
                .filter(i -> i.getCategoria().getNombre().toLowerCase().equals(nombreFiltroCategoria.toLowerCase()))
                .findFirst().get();

        if(inscripcionEliminar != null) listInscriptos.remove(inscripcionEliminar);

        List<Inscripcion> nuevaListaInscriptosPorCategoria = getInscriptosPorCategoria(nombreFiltroCategoria,listInscriptos);


        System.out.println("Listado de participantes inscriptos a la categoria : "+nombreFiltroCategoria+", después de eliminarle un participante");
        nuevaListaInscriptosPorCategoria.forEach(i -> {
            System.out.println("N° de inscripción: "+i.getId());
            System.out.println(i.getParticipante().toString());
        });

        double montoCircuitoChico = calcularMontoPorCategoria("circuito chico",listInscriptos);

        double montoCircuitoMedio = calcularMontoPorCategoria("circuito medio", listInscriptos);

        double montoCircuitoAvanzado = calcularMontoPorCategoria("circuito avanzado", listInscriptos);

        double montoTotal = listInscriptos.stream().mapToDouble(i -> i.getMonto()).sum();

        System.out.println("El monto recaudado por circuito CHICO es: $"+ montoCircuitoChico);
        System.out.println("El monto recaudado por circuito MEDIO es: $"+ montoCircuitoMedio);
        System.out.println("El monto recaudado por circuito AVANZADO es: $"+ montoCircuitoAvanzado);
        System.out.println("El monto recaudado TOTAL es: $"+ montoTotal);




    }

    private static Inscripcion inscribir(Categoria categoria, Participante participante){

        if(categoria.isAceptaMenor() == false && participante.getEdad()<18) {
            System.out.println("No se puede inscribir al participante con id: "+ participante.getId()+", porque es menor de edad y esa categoría no acepta menores de edad.");
         return null;
        }

        Inscripcion nuevaInscripcion = new Inscripcion(categoria,participante);

        return nuevaInscripcion;

    }

    private static List<Inscripcion> getInscriptosPorCategoria(String nombreCategoria, List<Inscripcion> listInscripcion){
        return  listInscripcion.stream()
                .filter(i -> i.getCategoria().getNombre().toLowerCase().equals(nombreCategoria.toLowerCase()))
                .toList();
    }

    private static double calcularMontoPorCategoria(String nombreCategoria, List<Inscripcion> listInscriptos){
        return getInscriptosPorCategoria(nombreCategoria, listInscriptos).stream().mapToDouble( i -> i.getMonto()).sum();
    }
}