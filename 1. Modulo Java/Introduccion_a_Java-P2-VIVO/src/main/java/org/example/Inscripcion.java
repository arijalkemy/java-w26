package org.example;

public class Inscripcion {

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    Categoria categoria;
    Participante participante;
    Integer monto;



    public Inscripcion(Categoria categoria, Participante participante) {

        this.categoria = categoria;
        this.participante = participante;
        switch (categoria.getId()){
            case 1:
                if(participante.getEdad()<18){
                    this.monto = 1300;
                }
                else {this.monto = 1500;}
                break;
            case 2:
                if(participante.getEdad()<18){
                    this.monto = 2000;
                }
                else {this.monto = 2300;}
                break;
            case 3:
                if(participante.getEdad()<18){
                    this.monto = 0;
                }
                else {this.monto = 2800;}
                break;

        }
    }
}
