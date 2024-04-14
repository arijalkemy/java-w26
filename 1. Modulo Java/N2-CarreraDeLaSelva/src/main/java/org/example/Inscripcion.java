package org.example;

public class Inscripcion {

    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        calcularMonto();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Categoria getCateroria() {
        return categoria;
    }


    public Participante getParticipante() {
        return participante;
    }

    public double getMonto() {
        return monto;
    }

    public void calcularMonto(){
        if(participante.getEdad() < 18 && categoria.getTipo().equals("Circuito chico")){
            this.monto = 1300;
        }
        else if (participante.getEdad() >= 18 && categoria.getTipo().equals("Circuito chico")){
            this.monto = 1500;
        }
        else if (participante.getEdad() < 18 && categoria.getTipo().equals("Circuito medio")){
            this.monto = 2000;
        }
        else if (participante.getEdad() >= 18 && categoria.getTipo().equals("Circuito medio")){
            this.monto = 2300;
        }
        else if (participante.getEdad() >= 18 && categoria.getTipo().equals("Circuito avanzado")){
            this.monto = 2800;
        }
        else {
            System.out.println("No se permite inscripciones a menores de 18 años");
        }
    }
}
