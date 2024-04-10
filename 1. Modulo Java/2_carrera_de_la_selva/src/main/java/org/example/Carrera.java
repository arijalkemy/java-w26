package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Carrera {

    private String name;
    private Set<Inscripcion> inscripciones;

    public Carrera(String name) {
        this.name = name;
        this.inscripciones = new HashSet<>();
    }

    public void inscribirParticipante(Categoria categoria, Participante participante){
        if(participante.getEdad() < 18 && categoria.getId() == 2){
            // Significa que tiene menos de 18 años y se inscribe en la carrera #avanzada
            System.out.println("Error, no es posible crear la inscripción");
            return;
        }
        for(Inscripcion ins : inscripciones){
            if(ins.getParticipante().getNroParticipante() == participante.getNroParticipante()){
                System.out.println("El participante ya se encuentra inscripto en alguna carrera");
                return;
            }
        }
        Inscripcion inscripcion = new Inscripcion(categoria,participante);
        inscripciones.add(inscripcion);
        System.out.println("Corredor inscripto correctamente, a abonar: " + inscripcion.getMonto());
    }

    public void calcularMontosTotales(){
        double montoCircuitoChico = 0.0;
        double montoCircuitoMedio = 0.0;
        double montoCircuitoAvanzado = 0.0;
        for(Inscripcion ins : inscripciones){
            switch (ins.getCategoria().getId()){
                case 0: montoCircuitoChico += ins.getMonto();
                    break;
                case 1: montoCircuitoMedio += ins.getMonto();
                    break;
                case 2: montoCircuitoAvanzado += ins.getMonto();
                    break;
                default: return;
            }
        }
        System.out.println("El monto del circuito chico es: " + montoCircuitoChico);
        System.out.println("El monto del circuito medio es: " + montoCircuitoMedio);
        System.out.println("El monto del circuito grande es: " + montoCircuitoAvanzado);
        System.out.println("El monto total es: " + (montoCircuitoChico + montoCircuitoMedio + montoCircuitoAvanzado));
    }

    public void eliminarParticipante(int nroParticipante){
        this.inscripciones = this.inscripciones.stream().filter(item -> item.getParticipante().getNroParticipante() != nroParticipante).collect(Collectors.toSet());
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public Set<Inscripcion> getInscripciones(int categoriaId) {
        return inscripciones.stream().filter(item -> item.getCategoria().getId() == categoriaId).collect(Collectors.toSet());
    }
}
