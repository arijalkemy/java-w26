package org.example;

//clase del objeto Participante
public class Participante{
    private int numero; //Declaracion de variales del objeto
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String emergencia;
    private String sangre;
    //constructor del objeto Participante
    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String emergencia, String sangre){
        this.numero=numero;
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.celular=celular;
        this.emergencia=emergencia;
        this.sangre=sangre;
    }
    //metodo mostrarParticipante para imprimir la informacion de el participante
    public void mostrarParticipante(){
        System.out.println("Nombre:"+nombre+" Edad:"+edad);
    }
    //metodo getEdad
    public int getEdad(){
        return edad;
    }
    //metodo getNombre
    public String getNombre(){
        return nombre;
    }
}
