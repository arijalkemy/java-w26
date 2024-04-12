package org.example;

public class Inscripcion {
    private int id;
    private Categorias categoria;
    private Participante participante;

    public Inscripcion() {
    }

    public Inscripcion(int id, Categorias categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int montoInscripcion(){
        System.out.println(categoria.getNombre());
        switch(categoria.getNombre()){
            case "chico": if(participante.getEdad()<18){
                return 1300;
            }else{
                return 1500;
            }
            case "mediana": if(participante.getEdad()<18){
                return 2000;
            }else{
                return 2300;
            }
            case "avanzada": if(participante.getEdad()<18){
                return 0;
            }else{
                return 2800;
            }
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", participante=" + participante +
                '}';
    }
}
