package org.example;

public class Inscripcion {

    private int id;
    private Participante participante;
    private Categoria categoria;
    private double monto;
    public Inscripcion(int id, Participante participante, Categoria categoria) {
        this.id = id;
        this.participante = participante;
        this.categoria = categoria;
        this.setMonto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {

        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto() {

        if (participante.getEdad() >= 18){
            switch (categoria.getId()){
                case 1: this.monto = 1500;
                break;
                case 2: this.monto = 2300;
                break;
                case 3: this.monto = 2800;
                break;
                default: this.monto = 0;
            }
        }
        else {
            switch (categoria.getId()){
                case 1: this.monto = 1300;
                    break;
                case 2: this.monto = 2000;
                    break;
                default: this.monto = 0;
            }
        }
    }

    @Override
    public String toString() {
        return
                " id=" + id +
                "\n PARTICIPANTE: \n" + participante +
                        "\n __________________________________________________" +
                "\n  CATEGORIA: \n" + categoria +
                        "\n __________________________________________________" +
                        "\n  monto=" + monto +
        "\n __________________________________________________" ;
    }
}
