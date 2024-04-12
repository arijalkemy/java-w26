import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2KM por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5KM por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "0 km por selva, arroyos, barro y escalada en piedra.");

        Participante participanteUno = new Participante(10, "1010230", "Juan", "Alvarez", 21, "315", "316", "A+", circuitoMedio);
        Participante participanteDos = new Participante(33,"33333333","Fernando","Alonso",42,"33","314","O-",circuitoAvanzado);
        Participante participanteTres = new Participante(1,"17237","Luisa","Ramirez",21,"345","355","AB+",circuitoChico);

        Participante participanteCuatro = new Participante(7,"12314","Juanita","Brown",17,"+57","+52","O+",circuitoMedio);
        Participante participanteCinco = new Participante(77,"1234","Danny","Cole",54,"556","4586","O+",circuitoAvanzado);
        Participante participanteSeis = new Participante(46,"12394","Daniel","Nesa",68,"+89","+1","O+-",circuitoChico);


        inscripciones.add(new Inscripcion(11, participanteUno.getCategoria(), participanteUno, logicaInscripcion(participanteUno.getCategoria().getId(),participanteUno.getEdad())));
        inscripciones.add(new Inscripcion(12, participanteDos.getCategoria(), participanteDos, logicaInscripcion(participanteDos.getCategoria().getId(),participanteDos.getEdad())));
        inscripciones.add(new Inscripcion(13, participanteTres.getCategoria(), participanteTres, logicaInscripcion(participanteTres.getCategoria().getId(),participanteTres.getEdad())));
        inscripciones.add(new Inscripcion(14,participanteCuatro.getCategoria(),participanteCuatro,logicaInscripcion(participanteCuatro.getCategoria().getId(),participanteCuatro.getEdad())));
        inscripciones.add(new Inscripcion(15,participanteCinco.getCategoria(),participanteCinco,logicaInscripcion(participanteCinco.getCategoria().getId(),participanteCinco.getEdad())));
        inscripciones.add(new Inscripcion(16,participanteSeis.getCategoria(), participanteSeis,logicaInscripcion(participanteSeis.getCategoria().getId(),participanteSeis.getEdad())));

        List<Inscripcion> infoCategoriaChico = inscripciones
                .stream()
                .filter(inscrito->inscrito.getCategoria().getId() == 1)
                .collect(Collectors.toList());
        List<Inscripcion> infoCategoriaMedio = inscripciones
                .stream()
                .filter(inscripcion->inscripcion.getCategoria().getId() == 2)
                .collect(Collectors.toList());
        List<Inscripcion> infoCategoriaAvanzado = inscripciones
                .stream()
                .filter(inscripcion->inscripcion.getCategoria().getId() == 3)
                .collect(Collectors.toList());

        System.out.println("Inscritos circuito chico: ");

        for(Inscripcion element : infoCategoriaChico){
            System.out.println("Numero de inscripcion: "+element.getNumero() +" "+ element.getParticipante().toString());
        }
        infoCategoriaChico.remove(0);

        System.out.println("Luego de eliminar");
        for(Inscripcion element : infoCategoriaChico){
            System.out.println("Numero de inscripcion: "+element.getNumero() +" "+ element.getParticipante().toString());
        }

        int recaudoChico = infoCategoriaChico.stream().mapToInt(Inscripcion::getMonto).sum();
        int recaudoMedio = infoCategoriaMedio.stream().mapToInt(Inscripcion::getMonto).sum();
        int recaudoAvanzado = infoCategoriaAvanzado.stream().mapToInt(Inscripcion::getMonto).sum();

        System.out.println("Apartado de inscripciones");

        System.out.println("Recaudo chico: " + recaudoChico);

        System.out.println("Recaudo medio: " + recaudoMedio);

        System.out.println("Recaudo avanzado: " + recaudoAvanzado);

        int totalRecaudo = recaudoChico + recaudoMedio + recaudoAvanzado;

        System.out.println("Total recaudado en la carrera: " + totalRecaudo);

        infoCategoriaChico.forEach(System.out::println);
        infoCategoriaMedio.forEach(System.out::println);
        infoCategoriaAvanzado.forEach(System.out::println);
    }



    public static int logicaInscripcion(int categoria, int edad) {
        if (categoria == 1)
            return edad < 18 ? 1300 : 1500;
        if (categoria == 2)
            return edad < 18 ? 2000 : 2300;
        if (categoria == 3)
            return edad < 18 ? -1 : 2800;
        return 0;
    }
}