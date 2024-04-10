package org.ggomezr;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int abonoParticipante;

    private static int ultimaInscripcion;

    public Inscripcion( Categoria categoria, Participante participante) {
        this.numeroInscripcion = ++ultimaInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.abonoParticipante = calcularMontoAbonoParticipante();
    }

    public int calcularMontoAbonoParticipante(){
        abonoParticipante = 0;
        if(categoria.getNombre().equalsIgnoreCase("circuito chico")){
            abonoParticipante = participante.getEdad() < 18 ? 1300 : 1500;
        }else if(categoria.getNombre().equalsIgnoreCase("circuito medio")){
            abonoParticipante = participante.getEdad() < 18 ? 2000 : 2300;
        }else{
            abonoParticipante = participante.getEdad() < 18 ? 0 : 2800;
        }
        return abonoParticipante;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

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

    public int getAbonoParticipante() {
        return abonoParticipante;
    }

    public void setAbonoParticipante(int abonoParticipante) {
        this.abonoParticipante = abonoParticipante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", abonoParticipante=" + abonoParticipante +
                '}';
    }
}
