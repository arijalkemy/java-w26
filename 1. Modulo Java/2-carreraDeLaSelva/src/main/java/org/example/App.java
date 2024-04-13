package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // Creacion categorias de los circuitos y participantes
        Categoria circuitoChico = new Categoria("1", "Circuito chico",
                "2 km por selva y arroyos.", 1500, 1300);
        Categoria circuitoMedio = new Categoria("2", "Circuito medio",
                "5 km por selva, arroyos y barro.", 2300, 2000);
        Categoria circuitoAvanzado = new Categoria("3", "Circuito avanzado",
                "0 km por selva, arroyos, barro y escalada en piedra.", 2800, 0);

        Participante participanteUno = new Participante(1,"39459678", "Camila", "Beczkowski", 28,
                "111223", "11122", "ab+");
        Participante participanteDos = new Participante(2,"38444992", "Luciana", "Beczkowski", 18,
                "111223", "11122", "ab+");
        Participante participanteTres = new Participante(3,"22009399", "Celeste", "Beczkowski", 17,
                "111223", "11122", "ab+");
        Participante participanteCuatro = new Participante(4,"39434567", "Juan", "Beczkowski", 50,
                "111223", "11122", "ab+");
        Participante participanteCinco = new Participante(5,"38444666", "Nicolas", "Beczkowski", 12,
                "111223", "11122", "ab+");

        // Creacion lista de inscripciones con sus respectivas inscripciones filtrando si algun participante menor a 18 se anoto en el circuito avanzado
        Set<Inscripcion> inscripciones = new HashSet<>();
        Inscripcion inscripcionUno = new Inscripcion(1,circuitoChico,participanteUno);
        Inscripcion inscripcionDos = new Inscripcion(2,circuitoMedio,participanteDos);
        Inscripcion inscripcionTres = new Inscripcion(3,circuitoAvanzado,participanteTres);
        Inscripcion inscripcionCuatro = new Inscripcion(4,circuitoAvanzado,participanteCuatro);
        Inscripcion inscripcionCinco = new Inscripcion(5,circuitoChico,participanteCinco);

        System.out.println("----- Inscribiendo participantes -----");
        inscripciones = inscribir(inscripcionUno, inscripciones);
        inscripciones = inscribir(inscripcionDos, inscripciones);
        inscripciones = inscribir(inscripcionTres, inscripciones);
        inscripciones = inscribir(inscripcionCuatro, inscripciones);
        inscripciones = inscribir(inscripcionCinco, inscripciones);

        // Segundo punto, muestra monto a pagar por participante n1
        Inscripcion primerInscripto = inscripciones.stream().filter(i -> i.getNumeroInscripcion() == 1).findFirst().get();
        System.out.println("-- El primer participante inscripto debe pagar:  $" + primerInscripto.getMonto());

        // Tercer punto, filtra por circuito
        String busquedaCircuitoChico = "circuito chico";
        Set<Inscripcion> lstCircuitoChico = inscripcionesSegunCategoria("circuito chico", inscripciones);
        System.out.println("-- Los participantes inscriptos en el "+ busquedaCircuitoChico + ", son: ");
        mostrarParticipantes(lstCircuitoChico);

        // Cuatro punto, elimina un participante y muestra como queda la lista de inscriptos de ese circuito
        inscripciones.removeIf(i -> i.getParticipante().getNumeroParticipante() == 5);
        System.out.println("----- Se elimino de la lista al participante con DNI " + participanteCinco.getDni() + " -----");
        mostrarParticipantes(lstCircuitoChico);

        // Quinto punto, monto por categoria y monto total

        double montoCircuitoChico = montoSegunCategoria(busquedaCircuitoChico, inscripciones);
        double montoCircuitoMedio = montoSegunCategoria("circuito medio", inscripciones);
        double montoCircuitoAvanzado = montoSegunCategoria("circuito avanzado", inscripciones);
        double montoTotal = montoCircuitoChico + montoCircuitoMedio + montoCircuitoAvanzado;

        System.out.println("-- El monto del circuito chico es de : $" + montoCircuitoChico);
        System.out.println("-- El monto del circuito medio es de : $" + montoCircuitoMedio);
        System.out.println("-- El monto del circuito avanzado es de : $" + montoCircuitoAvanzado);
        System.out.println("-- El monto total entre todos los circuitos es de : $" + montoTotal);

    }

    public static Set<Inscripcion> inscribir(Inscripcion insc, Set<Inscripcion> lstInscripciones) {
        Participante p = insc.getParticipante();
        if (insc.getCategoria().getNombre().equalsIgnoreCase("Circuito avanzado") && p.getEdad() < 18) {
            System.out.println(p.getNombre() + " " + p.getApellido() +
                    " no pudo ser inscripta, la edad minima para el circuito avanzado es de 18 años");
        } else {
            lstInscripciones.add(insc);
        }
        return lstInscripciones;
    }

    public static Set<Inscripcion> inscripcionesSegunCategoria (String nom, Set<Inscripcion> lstInscripciones) {
        return lstInscripciones.stream().filter(i -> i.getCategoria().getNombre().equalsIgnoreCase(nom)).collect(Collectors.toSet());
    }

    public static double montoSegunCategoria(String nom, Set<Inscripcion> lstInscripciones) {
        return inscripcionesSegunCategoria("circuito chico", lstInscripciones).stream().mapToDouble(Inscripcion::getMonto).sum();
    }

    public static void mostrarParticipantes(Set<Inscripcion> lstInscripciones) {
        lstInscripciones.forEach( i -> {
            System.out.println("Inscripcion N°: "+ i.getNumeroInscripcion() + " - " + i.getParticipante());
        });
    }
}
