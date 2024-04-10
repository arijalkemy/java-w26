package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase de carga para generar valores en memoria.
 */
public class Loader {

    public static List<Categoria> CATEGORIAS;
    public static List<Participante> PARTICIPANTES;
    public static List<Inscripcion> INSCRIPCIONES;

    /**
     * Metodo principal de la clase que funciona como gestor para la carga de datos automatico.
     */
    public static void load(){
        Scanner sc = new Scanner(System.in);
        cargarCategorias();
        cargarParticipantes(sc);
    }

    /**
        Realiza la carga de las 3 categorias de la carrera.
     */
    private static void cargarCategorias(){
        System.out.println("<< Cargando categorias...");
        CATEGORIAS = new ArrayList<Categoria>();
        Categoria c1 = new Categoria("Circuito Chico","2km por selva y arroyos.");
        Categoria c2 = new Categoria("Circuito Medio","5km por selva, arroyos y barro.");
        Categoria c3 = new Categoria("Circutio Avanzado","10km por serva, arroyos, barro y escalada en piedra.");

        CATEGORIAS.add(c1);
        CATEGORIAS.add(c2);
        CATEGORIAS.add(c3);
        System.out.println("<< Carga de categorias terminado.");
    }

    /**
     * Metodo que realiza la carga automatica de participantes e inscripciones.
     * @param sc Objeto scanner que sirve para la lectura por teclado.
     */
    private static void cargarParticipantes(Scanner sc){
        PARTICIPANTES = new ArrayList<Participante>();
        INSCRIPCIONES = new ArrayList<Inscripcion>();

        System.out.println("Seleccione la cantidad de participantes a crear: ");
        int cantidadParticipantes = sc.nextInt();
        System.out.println("<< Cargando participantes...");
        for(int i = 0; i < cantidadParticipantes; i++){
            crearParticipante();
        }
        System.out.println("<< Carga de participantes terminado.");
    }

    /**
     * Crea un nuevo participante
     */
    private static void crearParticipante(){
        Participante participante =  new Participante();
        System.out.println(participante);
        PARTICIPANTES.add(participante);
        inscribirParticipante(participante);
    }

    /**
     * Inscribe a un participante a una categoria en particular (siempre que pueda inscribirse)
     * @param participante objeto que representa un participante a inscribirse
     */
    private static void inscribirParticipante(Participante participante){
        Categoria categoria = CATEGORIAS.get((int) (Math.random() * 3));
        if(Inscripcion.sePuedeInscribir(participante,categoria)){
            Inscripcion inscripcion = new Inscripcion(categoria,participante);
            categoria.sumarMonto(inscripcion.getMonto());
            INSCRIPCIONES.add(inscripcion);
        }
    }

    public static Participante obtenerParticipanteAlAzar(){
        return PARTICIPANTES.get((int) (Math.random() * PARTICIPANTES.size()));
    }

    public static Inscripcion desinscribirParticipante(){
        Participante participante = obtenerParticipanteAlAzar();
        for (Inscripcion inscripcion : INSCRIPCIONES){
            if(inscripcion.getParticipante().equals(participante)){
                System.out.println("<< Se desinscribira al participante: " + participante);
                INSCRIPCIONES.remove(inscripcion);
                Categoria categoria = CATEGORIAS.get(inscripcion.getCategoria().getId());
                categoria.restarMonto(inscripcion.getMonto());
                return inscripcion;
            }
        }
        return null;
    }

    public static Categoria obtenerCategoriaAlAzar(){
        return CATEGORIAS.get((int) (Math.random() * 3));
    }
}
