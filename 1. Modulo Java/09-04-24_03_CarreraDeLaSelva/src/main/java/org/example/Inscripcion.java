package org.example;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto() {
        int edad = participante.getEdad();
        switch (categoria.getNombre()) {
            case "Circuito chico":
                return (edad < 18) ? 1300 : 1500;
            case "Circuito medio":
                return (edad < 18) ? 2000 : 2300;
            case "Circuito avanzado":
                if (edad < 18) throw new IllegalArgumentException("Menores de 18 años no pueden inscribirse en el Circuito avanzado");
                return 2800;
            default:
                throw new IllegalArgumentException("Categoría desconocida");
        }
    }

    // Getters y setters
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
