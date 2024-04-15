package org.example;

import java.util.HashMap;
import java.util.Map;

public class Categoria {
    private String nombre;
    private String descripcion;
    private double costoMayores;
    private double costoMenores = 0;
    private boolean permiteMenores = true;
    private static int numeroDeInscripcion = 0;
    private double montoRecaudado = 0.0;
    private Map<Integer, Participante> listaDeInscripciones = new HashMap<>();

    /**
     * constructor para las categorias circuito chico y circuito medio
     * @param nombre nombre de la categoria
     * @param descripcion descripcion de la categoria
     * @param costoMayores costo de inscripcion para mayores
     * @param costoMenores costo de inscripcion para menores.
     */
    public Categoria(String nombre, String descripcion, double costoMayores, double costoMenores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMayores = costoMayores;
        this.costoMenores = costoMenores;

    }


    /**
     * constructor para las categoria circuito avanzado
     * @param nombre nombre de la categoria
     * @param descripcion descripcion de la categoria
     * @param costoMayores costo de inscripcion para mayores
     * @param permiteMenores para saber si admite inscripciones de menores
     */
    public Categoria(String nombre, String descripcion, double costoMayores, boolean permiteMenores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMayores = costoMayores;
        this.permiteMenores = permiteMenores;
    }

    //metodo para inscribir un participante a una categoria
    public void inscribirParticipante(Participante participante) {
        for (Map.Entry<Integer, Participante> inscripcion : this.listaDeInscripciones.entrySet()) {
            if (inscripcion.getValue().equals(participante)) {
                System.out.println("El participante: " + participante.getNombre() + " ya se encuentra en la categoria " + this.nombre + " por lo tanto no puede volver a ser inscripto");
                return;
            }
        }

        if (participante.getEdad() > 18) {
            this.listaDeInscripciones.put(++numeroDeInscripcion, participante);
            this.montoRecaudado += this.costoMayores;
            System.out.println("El participante: " + participante.getNombre() + " fue inscripto correctamente " + "en la categoria " + this.nombre + " por: " + this.costoMayores);
        } else {
            if (!this.permiteMenores) {
                System.out.println("El participante: " + participante.getNombre() + "  no fue inscrito porque " + "la categoria " + this.nombre + " solo acepta mayores");
            } else {
                this.listaDeInscripciones.put(++numeroDeInscripcion, participante);
                this.montoRecaudado += this.costoMenores;
                System.out.println("El participante: " + participante.getNombre() + " fue inscripto correctamente" + "en la categoria " + this.nombre + " por: " + this.costoMenores);
            }
        }
    }

    //metodo para desinscribir un participante de una determinada categoria.
    public void desinscribirParticipante(Participante participante) {
        for (Map.Entry<Integer, Participante> inscripcion : this.listaDeInscripciones.entrySet()) {
            if (inscripcion.getValue().equals(participante)) {
                int inscripcionBorrada = inscripcion.getKey();
                String inscripcionNombre = inscripcion.getValue().getNombre();
                double montoADevolver;
                if (participante.getEdad() > 18){
                    montoADevolver = this.costoMayores;
                }else {
                    montoADevolver = this.costoMenores;
                }
                //remuevo el participante
                this.listaDeInscripciones.remove(inscripcion.getKey());
                //si no hay ningun error eliminandolo hago los descuentos y muestro por pantalla que ya fue eliminado
                this.montoRecaudado -= montoADevolver;
                System.out.println("\nSe elimino de la categoria: " + this.nombre +", la inscripcion: #" + inscripcionBorrada + " perteneciente a: " + inscripcionNombre + ".");
                    break;
            }
        }
        this.mostrarParticipantes();
    }

    //metodo para mostrar la lista de participantes incriptos a una determinada categoria
    public void mostrarParticipantes() {
        System.out.println("\nlista de inscriptos en categoria " + this.nombre + ": ");
        System.out.println("===============================================");
        for (Map.Entry<Integer, Participante> inscripcion : this.listaDeInscripciones.entrySet()) {
            System.out.println("numero de inscripcion: " + inscripcion.getKey() + ", participante: " + inscripcion.getValue());
        }
    }

    public double getMontoRecaudado() {
        return montoRecaudado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoMayores() {
        return costoMayores;
    }

    public void setCostoMayores(double costoMayores) {
        this.costoMayores = costoMayores;
    }

    public double getCostoMenores() {
        return costoMenores;
    }

    public void setCostoMenores(double costoMenores) {
        this.costoMenores = costoMenores;
    }

    @Override
    public String toString() {
        return "Categoria{\n" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costoMayores=" + costoMayores +
                ", costoMenores=" + costoMenores +
                ", permiteMenores=" + permiteMenores +
                ", listaDeInscripciones=" + listaDeInscripciones +
                "\n}";
    }
}
