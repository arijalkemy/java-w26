package org.example;

//clase objeto Inscripcion
public class Inscripcion{
    private Categoria categoria; //Declaracion de variales del objeto
    private Participante participante;
    private int abono;
    private boolean puedeInscribirse;

    public Inscripcion(Categoria categoria, Participante participante, int abono){ //constructor del objeto
        this.categoria=categoria;
        this.participante=participante;
        this.abono=abono;
        this.puedeInscribirse=true;


    }
    //metodo getAbono
    public int getAbono(){
        return abono;
    }
    //Metodo getInscripcionIdCategoria
    public int getInscripcionCategoria(){
        return categoria.getId();
    }
    //metodo para imprimir la informacion de una inscripcion
    public void mostrarInscripcion(){
        System.out.println("=================");
        System.out.println("Categoria:\n Id:"+categoria.getId()+" Nombre:"+categoria.getNombre()+" Descripcion:"+categoria.getDescripcion()+"\nParticipante:\nNombre:"+participante.getNombre()+" Edad:"+participante.getEdad()+"\n Abono:"+abono+"\nInscripcion:"+puedeInscribirse);
    }
    // metodo para settear el estado de inscripcion
    public void setPuedeInscribirse(boolean opcion){
        puedeInscribirse=opcion;
    }
}
