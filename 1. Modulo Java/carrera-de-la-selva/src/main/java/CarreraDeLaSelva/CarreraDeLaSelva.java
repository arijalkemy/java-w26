package CarreraDeLaSelva;

import Categorias.Categoria;
import Categorias.CircuitoAvanzado;
import Categorias.CircuitoChico;
import Categorias.CircuitoMediano;
import Inscripcion.Inscripcion;
import Participante.Participante;
import enums.ECategoria;
import java.util.ArrayList;
import java.util.List;

public class CarreraDeLaSelva {
    private List<Categoria> categorias = new ArrayList<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public CarreraDeLaSelva(){
        categorias.add(new CircuitoAvanzado());
        categorias.add(new CircuitoChico());
        categorias.add(new CircuitoMediano());
    }

    public void inscribir(Participante participante, Categoria categoria){
        //chequeo que no este inscripto
        if(inscripciones.contains(participante)){
            System.out.println("El participante ya esta inscripto.");
            return;
        }


        // chequeo que el participante pueda anotarse
        if(!categoria.puedeInscribirse(participante)){
            System.out.println("El participante " + participante.getNombre() + " " + participante.getApellido() +
            " no puede anotarse en la categoria " + categoria.getNombre());
            return;
        }

        inscripciones.add(new Inscripcion(inscripciones.size() + 1,
                categoria,
                participante,
                categoria.getMontoAAbonar(participante)));

        System.out.println("inscripcion exitosa de " + participante.getNombre() + " a " + categoria.getNombre());

    }

    public void desinscribir(Participante participante){
        if(!inscripciones.stream().anyMatch(i -> i.getParticipante() == participante)){
            System.out.println("este participante no esta inscripto");
            return;
        }

        this.inscripciones = inscripciones.stream().filter(i -> i.getParticipante() != participante).toList();


        System.out.println("Desinscripcion de " + participante.getNombre() + " exitosa");
        mostrarInscripciones();
    }

    public void mostrarTotalRecaudado(){
        System.out.println();
        System.out.println();
        System.out.println("---RECAUDO TOTAL---");
        System.out.println(this.inscripciones.stream().mapToDouble(i -> i.getMontoAAbonar()).sum());
    }

    public void mostrarMontoRecaudadoPorCategoria(){
        List<Inscripcion> inscripcionesCircuitoAvanzado = new ArrayList<>();
        List<Inscripcion> inscripcionesCircuitoMediano = new ArrayList<>();
        List<Inscripcion> inscripcionesCircuitoChico = new ArrayList<>();

        for(Inscripcion inscripcion : inscripciones){
            if(ECategoria.ID_CIRCUITO_MEDIANO.ordinal() == inscripcion.getCategoria().getId()){
                inscripcionesCircuitoMediano.add(inscripcion);
            } else if (ECategoria.ID_CIRCUITO_AVANZADO.ordinal() == inscripcion.getCategoria().getId()){
                inscripcionesCircuitoAvanzado.add(inscripcion);
            } else {
                inscripcionesCircuitoChico.add(inscripcion);
            }
        }

        System.out.println();
        System.out.println("---MONTO RECAUDADO INSCRIPCIONES CIRCUITO CHICO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoChico){
            System.out.println(inscripcionesCircuitoChico.stream().mapToDouble(i -> i.getMontoAAbonar()).sum());
        }
        System.out.println();
        System.out.println("---MONTO RECAUDADO INSCRIPCIONES CIRCUITO MEDIANO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoMediano){
            System.out.println(inscripcionesCircuitoMediano.stream().mapToDouble(i -> i.getMontoAAbonar()).sum());
        }
        System.out.println();
        System.out.println("---MONTO RECAUDADO INSCRIPCIONES CIRCUITO AVANZADO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoAvanzado){
            System.out.println(inscripcionesCircuitoAvanzado.stream().mapToDouble(i -> i.getMontoAAbonar()).sum());
        }

    }

    public void mostrarInscripciones(){
        List<Inscripcion> inscripcionesCircuitoAvanzado = new ArrayList<>();
        List<Inscripcion> inscripcionesCircuitoMediano = new ArrayList<>();
        List<Inscripcion> inscripcionesCircuitoChico = new ArrayList<>();

        for(Inscripcion inscripcion : inscripciones){
            if(ECategoria.ID_CIRCUITO_MEDIANO.ordinal() == inscripcion.getCategoria().getId()){
                inscripcionesCircuitoMediano.add(inscripcion);
            } else if (ECategoria.ID_CIRCUITO_AVANZADO.ordinal() == inscripcion.getCategoria().getId()){
                inscripcionesCircuitoAvanzado.add(inscripcion);
            } else {
                inscripcionesCircuitoChico.add(inscripcion);
            }
        }
        
        
        System.out.println();
        System.out.println("---INSCRIPCIONES CIRCUITO CHICO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoChico){
            System.out.println(inscripcion.toString());
        }
        System.out.println();
        System.out.println("---INSCRIPCIONES CIRCUITO MEDIANO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoMediano){
            System.out.println(inscripcion.toString());
        }
        System.out.println();
        System.out.println("---INSCRIPCIONES CIRCUITO AVANZADO---");
        for(Inscripcion inscripcion : inscripcionesCircuitoAvanzado){
            System.out.println(inscripcion.toString());
        }
    }



}
