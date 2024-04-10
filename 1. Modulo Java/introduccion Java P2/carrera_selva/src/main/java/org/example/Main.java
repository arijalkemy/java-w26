package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.example.Clases.Categoria;
import org.example.Clases.Inscripcion;
import org.example.Clases.Participante;

/**
 * Hello world!
 *
 */
public class Main {
    //Se crea la estructura para guardar las inscripciones
    static Set<Inscripcion> inscripciones = new HashSet();

    public static void main(String[] args) {

        //Se crea los tres tipo de categoria
        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria medio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria avanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        //Se crean los participantes
        Participante participante = new Participante(0,27363672,"Julian","Ramirez",24,"32000000","322746484","O");
        Participante participante_uno = new Participante(1, 12345678, "Juan", "López", 25, "3001234567", "3119876543", "A");
        Participante participante_dos = new Participante(2, 23456789, "María", "González", 19, "3102345678", "3218765432", "B");
        Participante participante_tres = new Participante(3, 34567890, "Pedro", "Martínez", 30, "3203456789", "3327654321", "AB");
        Participante participante_cuatro = new Participante(4, 45678901, "Ana", "Pérez", 17, "3304567890", "3436543210", "O");
        Participante participante_cinco = new Participante(5, 56789012, "Laura", "Hernández", 15, "3405678901", "3545432109", "A");
        Participante participante_seis = new Participante(6, 67890123, "Carlos", "Díaz", 12, "3506789012", "3654321098", "B");

        inscribirParticipante(participante_uno,chico,0);
        inscribirParticipante(participante_cuatro,chico,1);
        inscribirParticipante(participante_dos,medio,2);
        inscribirParticipante(participante_cinco,medio,3);
        inscribirParticipante(participante_tres,avanzado,4);
        inscribirParticipante(participante_seis,avanzado,5);
        inscribirParticipante(participante,chico,6);

        imprimirParticipantePorCategoria(chico);
        desiscribirParticipante(participante);
        imprimirParticipantePorCategoria(chico);
        imprimirRecaudoPorCategoria(chico);
        imprimirRecaudoPorCategoria(medio);
        imprimirRecaudoPorCategoria(avanzado);
        imprimirRecaudoTotal();

    }


    public static void inscribirParticipante(Participante participante, Categoria c, int numeroInscripcion) {

        if(calcularMontoInscripcion(c.getId(), participante) != 0){
            Inscripcion inscripcion = new Inscripcion(numeroInscripcion,c,participante,calcularMontoInscripcion(c.getId(), participante));
            inscripciones.add(inscripcion);
        }else {
            System.out.println("No se puede inscribir a "+participante.getNombre()+" "+participante.getApellido()+" en la categoria "+c.getNombre()+" porque es menor de edad");
        }
    }

    public static void desiscribirParticipante(Participante participante) {
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getParticipante().equals(participante)) {
                inscripciones.remove(inscripcion);
                break;
            };
        }
    }

    public static int calcularMontoInscripcion(int idCategoria, Participante participante) {
        return switch (idCategoria) {
            case 1 -> participante.getEdad() < 18 ? 1300 : 1500;
            case 2 -> participante.getEdad() < 18 ? 2000 : 2300;
            case 3 -> participante.getEdad() < 18 ? 0 : 2800;
            default -> 0;
        };
    }

    public static void imprimirParticipantePorCategoria(Categoria categoria) {
        System.out.println("---------------------------------------------------------------");
        System.out.println(" Lista de participantes de la categoria "+categoria.getNombre()); ;
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoría().getId() == categoria.getId()) System.out.println(inscripcion);
        }
        System.out.println("---------------------------------------------------------------");
    }

    public static void imprimirRecaudoPorCategoria(Categoria categoria) {
        System.out.println("---------------------------------------------------------------");
        double valor = 0.0;
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoría().getId() == categoria.getId()) valor+= inscripcion.getMonto();
        }
        System.out.println("El recaudo de la categoria "+categoria.getNombre()+" es: "+valor);
        System.out.println("---------------------------------------------------------------");
    }

    public static void imprimirRecaudoTotal() {
        System.out.println("---------------------------------------------------------------");
        double valor = 0.0;
        for(Inscripcion inscripcion : inscripciones){
             valor+= inscripcion.getMonto();
        }
        System.out.println("El recaudo en todas las categorias es: "+valor);
        System.out.println("---------------------------------------------------------------");
    }



}
