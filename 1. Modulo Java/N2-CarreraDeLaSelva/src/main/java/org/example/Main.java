package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Participante> participantes;
    static List<Categoria> categorias;
    static List<Inscripcion> inscripciones;

    public static void main(String[] args) {
        categorias = new ArrayList<>();
        participantes = new ArrayList<>();
        inscripciones = new ArrayList<>();

        Categoria categoriaMenor = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria categoriaMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoriaAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
        categorias.add(categoriaMenor);
        categorias.add(categoriaMedio);
        categorias.add(categoriaAvanzado);


        Participante participante1 = new Participante(1, 12345678, "Maria", "Gomez", 13, 123123123, 232323232, "A+");
        Participante participante2 = new Participante(2, 12345679, "Eduardo", "Ramirez", 18, 123123145, 232328756, "AB+");
        Participante participante3 = new Participante(3, 12345677, "Mariano", "Mosconni", 26, 123345345, 233421232, "0-");
        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        Inscripcion inscripcion1 = new Inscripcion(1, categoriaMenor, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, categoriaMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoriaAvanzado, participante3);
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);


        Participante participante4 = new Participante(4, 12345647, "Pablo", "Ferrari", 34, 123345345, 233421232, "B+");
        Participante participante5 = new Participante(5, 15345677, "Martin", "Prietto", 24, 123345345, 233421232, "AB-");
        participantes.add(participante4);
        participantes.add(participante5);

        Inscripcion inscripcion4 = new Inscripcion(4, categoriaMedio, participante4);
        Inscripcion inscripcion5 = new Inscripcion(5, categoriaAvanzado, participante5);
        inscripciones.add(inscripcion4);
        inscripciones.add(inscripcion5);


        System.out.println("------------------Muestra de datos pre-cargados------------------");
        System.out.println("Mostrar participantes por categoria");
        mostrarParticipantesPorCategoria();
        eliminarParticipante(1);
        System.out.println("Mostrar participantes por categoria luego de desinscribir un participante");
        mostrarParticipantesPorCategoria();
        System.out.println("Mostrar total recaudado por categoria");
        montoTotalPorCategoria();
        System.out.println("Mostrar total recaudado");
        montoTotal();

        System.out.println(" -------------------------------------------------------- \n " +
                "-------------------------------------------------------- ");


    }
    public static void mostrarParticipantesPorCategoria() {
        List<Participante> participanteCategoriaMenor = new ArrayList<>();
        List<Participante> participanteCategoriaMedio = new ArrayList<>();
        List<Participante> participanteCategoriaAvanzado= new ArrayList<>();

        for (Inscripcion inscripcion : inscripciones) {
            if(inscripcion.getCateroria().getTipo().equals("Circuito chico")) {
                participanteCategoriaMenor.add(inscripcion.getParticipante());
            }else if(inscripcion.getCateroria().getTipo().equals("Circuito medio")) {
                participanteCategoriaMedio.add(inscripcion.getParticipante());
            }else{
                participanteCategoriaAvanzado.add(inscripcion.getParticipante());
            }
        }

        for(Participante participante : participanteCategoriaMenor) {
            System.out.println("Participante con id " + participante.getId() +
                    "se encuentra inscripto en la categoria de circuito chico" );
        }
        for(Participante participante : participanteCategoriaMedio) {
            System.out.println("Participante con id " + participante.getId() +
                    "se encuentra inscripto en la categoria de circuito medio" );
        }
        for(Participante participante : participanteCategoriaAvanzado) {
            System.out.println("Participante con id " + participante.getId() +
                    "se encuentra inscripto en la categoria de circuito avanzado" );
        }
    }
    public static void eliminarParticipante(long id) {
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante().getId() == id);
    }

    public static void montoTotalPorCategoria() {
        double totalChico = 0;
        double totalMedio = 0;
        double totalAvanzado = 0;
        for(Inscripcion inscripcion : inscripciones) {
            if(inscripcion.getCateroria().getTipo().equals("Circuito chico")) {
                totalChico = totalChico + inscripcion.getMonto();
            } else if (inscripcion.getCateroria().getTipo().equals("Circuito medio")){
                totalMedio = totalMedio + inscripcion.getMonto();
            } else {
                totalAvanzado = totalAvanzado + inscripcion.getMonto();
            }
        }

        System.out.println("El monto total recaudado de la categoria circuito chico es: $" + totalChico + "\n" +
                "El monto total recaudado de la categoria circuito medio es: $" + totalMedio + "\n" +
                "El monto total recaudado de la categoria circuito avanzado es: $" + totalAvanzado);
    }

    public static void montoTotal() {
        double total = 0;
        for(Inscripcion inscripcion : inscripciones) {
            total =  total + inscripcion.getMonto();
        }

        System.out.println("El monto total recaudado es: $" + total);
    }
}